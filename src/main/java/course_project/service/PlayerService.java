package course_project.service;

import course_project.model.Battlefield;
import course_project.model.Designation;
import course_project.model.Player;

import java.io.IOException;
import java.util.Scanner;

public class PlayerService {

    private final BattleFieldService battleFieldService;
    private final Player player;

    public PlayerService(Player player, BattleFieldService battleFieldService) {
        this.player = player;
        this.battleFieldService = battleFieldService;
    }

    public boolean makeShot(Player currentPlayer, Player enemy, Scanner readIt) throws IOException {
        int shipAmount = enemy.getShipsAmount();

        System.out.println("Your battlefield:");
        battleFieldService.print(currentPlayer.getField());
        System.out.println("Enemy battlefield:");
        battleFieldService.print(currentPlayer.getEnemyField());

        System.out.println("Player " + currentPlayer.getName() + "is playing. Enter coordinates int format \"A1\"");

        while (true) {
            String strCoord = readIt.nextLine();

            if (strCoord.length() != 2 ||
                    Character.isDigit(strCoord.charAt(0)) || !Character.isDigit(strCoord.charAt(1))) {
                System.out.println("Invalid format of input! Enter coordinates in format \"A1\"");
                throw new IOException();
            }

            int x = Character.getNumericValue(strCoord.charAt(1));
            int y = strCoord.charAt(0) - 64;

            if (enemy.getGrid()[x][y] == Designation.SHIP) {

                enemy.getGrid()[x][y] = Designation.HIT;
                enemy.getField().getGrid()[x][y] = Designation.HIT;

                if (battleFieldService.isDead(enemy.getField(), x, y)) {
                    battleFieldService.surroundDeadShip(currentPlayer.getEnemyField(), x, y);
                    battleFieldService.surroundDeadShip(enemy.getField(), x, y);
                }

                System.out.println("Your field:");
                battleFieldService.print(currentPlayer.getField());
                System.out.println("Enemy field:");
                battleFieldService.print(currentPlayer.getEnemyField());
                System.out.println("HIT!");

                if (battleFieldService.isDead(enemy.getField(), x, y)) {
                    System.out.println("Ship totally destroyed!");
                    enemy.setShipsAmount(shipAmount--);
                }

                if (enemy.getShipsAmount() == 0) {
                    System.out.println("Congratulations to player " + currentPlayer + "!");
                    return false;
                } else {
                    System.out.println("Shoot one more time!");
                }

            } else if (enemy.getGrid()[x][y] == Designation.HIT) {
                System.out.println("You already shoot here! Shoot one more time!");
            } else {
                enemy.getGrid()[x][y] = Designation.MISS;
                currentPlayer.getEnemyField().getGrid()[x][y] = Designation.MISS;
                System.out.println("Your field:");
                battleFieldService.print(currentPlayer.getField());
                System.out.println("Enemy field:");
                battleFieldService.print(currentPlayer.getEnemyField());
                System.out.println("MISS!");
                break;
            }
        }
        System.out.println(currentPlayer.getName() + ", your turn is over. Press Enter to pass the turn to another player");
        readIt.nextLine();
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
        return true;
    }

}
