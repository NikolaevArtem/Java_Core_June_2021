package course_project.SeaBattle.view;

import course_project.SeaBattle.models.Player;
import course_project.SeaBattle.models.Ship;
import course_project.SeaBattle.models.Square;


public class ConsolePrinter {

    public void printPrepareGrid(Player player) {
        Square[][] squares = player.getGrid().getSquares();

        System.out.println("   A B C D E F G H I J");

        for (int y = 0; y < 10; y++) {
            if (String.valueOf(y + 1).length() >= 2) {
                System.out.print(y + 1 + " ");
            } else {
                System.out.print(y + 1 + "  ");
            }

            for (int x = 0; x < 10; x++) {

                System.out.print(squares[x][y].print() + " ");
            }
            System.out.println();
        }


    }

    public void printPrepareShipMessage(Ship ship) {
        System.out.println("Enter the starting position of the " + ship.getShipType().toString());
    }

    public void printBattleGrids(Player player) {
        if (player.isComputer()) {
            return;
        }
        Square[][] squares = player.getGrid().getSquares();
        Square[][] enemySquares = player.getEnemy().getGrid().getSquares();
        System.out.println("   Yours greed                  " + player.getEnemy().getName() + "'s greed");
        System.out.println("   A B C D E F G H I J             A B C D E F G H I J");

        for (int y = 0; y < squares[0].length; y++) {
            if (String.valueOf(y + 1).length() >= 2) {
                System.out.print(y + 1 + " ");
            } else {
                System.out.print(y + 1 + "  ");
            }

            for (int x = 0; x < squares[0].length; x++) {
                System.out.print(squares[x][y].print() + " ");
            }

            System.out.print("         ");

            if (String.valueOf(y + 1).length() >= 2) {
                System.out.print(y + 1 + " ");
            } else {
                System.out.print(y + 1 + "  ");
            }

            for (int x = 0; x < enemySquares[0].length; x++) {
                if (enemySquares[x][y].print().contains("W")) {
                    System.out.print("\u001B[34m" + ". " + "\u001b[0m");
                } else {
                    System.out.print(enemySquares[x][y].print() + " ");
                }
            }
            System.out.println();

        }
        System.out.println(player.getName() + "'s turn");
    }

    public void printShipDirectionRequest() {
        System.out.println("Enter direction.");
//         [1 - vertically/ 0 - horizontally]
    }

    public void printErrorShipArrange() {
        System.out.println("Crossing ships or a ship outside the border");

    }

    public void cheersMessage(Player winner) {
        Square[][] squares = winner.getGrid().getSquares();
        Square[][] enemySquares = winner.getEnemy().getGrid().getSquares();

        System.out.println("   A B C D E F G H I J             A B C D E F G H I J");

        for (int y = 0; y < squares[0].length; y++) {
            if (String.valueOf(y + 1).length() >= 2) {
                System.out.print(y + 1 + " ");
            } else {
                System.out.print(y + 1 + "  ");
            }

            for (int x = 0; x < squares[0].length; x++) {
                System.out.print(squares[x][y].print() + " ");
            }

            System.out.print("         ");

            if (String.valueOf(y + 1).length() >= 2) {
                System.out.print(y + 1 + " ");
            } else {
                System.out.print(y + 1 + "  ");
            }

            for (int x = 0; x < enemySquares[0].length; x++) {
                System.out.print(enemySquares[x][y].print() + " ");
            }
            System.out.println();

        }
        System.out.println(winner.getName() + " won this battle against " + winner.getEnemy().getName());
    }


    public void printMiss() {
        System.out.println("\u001b[31m" + " Missed" + "\u001b[0m");
    }

    public void printHit() {
        System.out.println("Hit an enemy ship");
    }

    public void printDestroyedShip(Ship ship) {
        System.out.println("You destroyed enemy " + ship.getShipType().toString());
    }

    public void printScore(int score) {
        System.out.println("Your score - " + score);
    }
}