package course_project.engine;

import course_project.models.Player;
import course_project.models.Ship;
import course_project.models.Coordinate;


import java.io.IOException;
import java.util.List;

public class Shooter {

    public static void Shoot(Player currentPlayer, Player enemyPlayer) throws IOException {
        boolean shootMore = true;
        while (shootMore) {
            System.out.println(currentPlayer.Name() + " turn! Enter a coordinate to shoot.");
            BoardPrinter.printBothBoards(currentPlayer);
            Coordinate c = getUniqueShoot(currentPlayer);

            for (Ship ship : enemyPlayer.Ships()) {

                if (ship.getCoords().contains(c)) {
                    shootMore = true;
                    ship.decreaseHp();
                    enemyPlayer.reduceHp();
                    addMark(currentPlayer, enemyPlayer, c, "X");

                    if (shipAlive(ship)) {
                        System.out.println("Successful hit! Shoot one more time!");
                    } else {
                        if (enemyPlayer.Hp() == 0) {
                            System.out.println("Enemy " + ship + " killed!");
                            System.out.println(currentPlayer.Name() + " won! Congratulations!!!");
                            shootMore = false;
                            break;
                        }
                        System.out.println("Enemy " + ship + " killed! Shoot one more time!");
                        //TODO get oriole coordinates and fill
                    }
                    break; //another ships cannot contain that coordinate
                } else {
                    shootMore = false;
                }
            }
            if (!shootMore && enemyPlayer.Hp() > 0) {
                System.out.println("Miss!");
                addMark(currentPlayer, enemyPlayer, c, "*");
            }
        }
    }

    private static Coordinate getUniqueShoot(Player currentPlayer) throws IOException {
        while (true) {
            Coordinate c = new Coordinate(Input.getRightCoordinate());
            if (currentPlayer.CheckedCells().contains(c)) {
                System.out.println("That cell is already checked, choose another one");
            } else {
                currentPlayer.CheckedCells().add(c);
                System.out.println("Shooting at cell " + c + "...");
                return c;
            }
        }
    }

    private static boolean shipAlive(Ship ship) {
        return ship.getHp() > 0;
    }

    private static void addMark(Player currentPlayer, Player enemyPlayer, Coordinate c, String sign) {
        enemyPlayer.MainBoard().changeCell(c, sign);
        currentPlayer.ScanBoard().changeCell(c, sign);
    }

    private static void addMark(Player currentPlayer, Player enemyPlayer, List<Coordinate> coordinateList, String sign) {
        for (Coordinate c : coordinateList) {
            enemyPlayer.MainBoard().changeCell(c, sign);
            currentPlayer.ScanBoard().changeCell(c, sign);
        }
    }

//    private static ArrayList<Coordinate> oreole

}
