package course_project.battleship.controller;

import course_project.battleship.game.GameRule;
import course_project.battleship.player.Player;
import course_project.battleship.utils.*;


public class HumanController implements PlayerController {

    @Override
    public void placeShips(Player player) {
        System.out.println(player.getName() + " choose the ship placement mode:\n1.Manually\n2.Randomly");
        int setupMode = Menu.getInt(2);
        if (setupMode == 1) {
            new ManualShipPlacement().placeShips(player);
        } else {
            new RandomShipPlacement().placeShips(player);
        }

        System.out.println("Ships are placed!\n");
    }

    public void makeTurns(Player player1, Player player2) {
        System.out.println("Your field: ");
        Display.drawField(player1.getBattlefield());

        while (true) {
            System.out.println();
            System.out.println("" + player1.getName() + ", please, make your turn.");
            Display.drawField(player1.getMonitorField());

            Coordinate coordinate = Menu.createCoordinate();

            if (coordinate == null || !Validator.isValidCoordinate(coordinate)) {
                continue;
            }

            if (!player1.makeTurn(player2,
                    coordinate)) {
                System.out.println("\nMiss! Your opponents turn!\n");
                break;
            }

            if (GameRule.isWinCondition(player1)) {
                break;
            }
//            display.clearConsole();
        }
    }


}
