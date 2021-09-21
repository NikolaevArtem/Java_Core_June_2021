package course_project.SeaBattle.view;

import course_project.SeaBattle.model.Player;
import course_project.SeaBattle.model.Ship;
import course_project.SeaBattle.model.Square;


public class ConsolePrinter implements Printer {

    private static final String ANSI_RED = "\u001b[31m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_GREEN = "\u001b[32m";
    private static final String ANSI_RESET = "\u001b[0m";


    @Override
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

                System.out.print(printSquare(squares[x][y]) + " ");
            }
            System.out.println();
        }


    }

    @Override
    public void printPrepareShipMessage(Ship ship) {
        System.out.println("Enter the starting position of the " + ship.getShipType().toString());
    }

    @Override
    public void printBattleGrids(Player player) {
        if (player.isComputer()) {
            return;
        }
        Square[][] squares = player.getGrid().getSquares();
        Square[][] enemySquares = player.getEnemy().getGrid().getSquares();
        System.out.println("   Yours grid                   " + player.getEnemy().getName() + "'s grid");
        System.out.println("   A B C D E F G H I J             A B C D E F G H I J");

        for (int y = 0; y < squares[0].length; y++) {
            if (String.valueOf(y + 1).length() >= 2) {
                System.out.print(y + 1 + " ");
            } else {
                System.out.print(y + 1 + "  ");
            }

            for (int x = 0; x < squares[0].length; x++) {
                System.out.print(printSquare(squares[x][y]) + " ");
            }

            System.out.print("         ");

            if (String.valueOf(y + 1).length() >= 2) {
                System.out.print(y + 1 + " ");
            } else {
                System.out.print(y + 1 + "  ");
            }

            for (int x = 0; x < enemySquares[0].length; x++) {
                if (printSquare(enemySquares[x][y]).contains("W")) {
                    System.out.print(ANSI_BLUE  + ". " + ANSI_RESET);
                } else {
                    System.out.print(printSquare(enemySquares[x][y]) + " ");
                }
            }
            System.out.println();

        }
        System.out.println(player.getName() + "'s turn");
    }

    @Override
    public void printShipDirectionRequest() {
        System.out.println("Enter direction.");
    }

    @Override
    public void printErrorShipArrange() {
        System.out.println("Crossing ships or a ship outside the border");

    }

    @Override
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
                System.out.print(printSquare(squares[x][y]) + " ");
            }

            System.out.print("         ");

            if (String.valueOf(y + 1).length() >= 2) {
                System.out.print(y + 1 + " ");
            } else {
                System.out.print(y + 1 + "  ");
            }

            for (int x = 0; x < enemySquares[0].length; x++) {
                System.out.print(printSquare(enemySquares[x][y]) + " ");
            }
            System.out.println();

        }
        System.out.println(winner.getName() + " won this battle against " + winner.getEnemy().getName());
    }

    @Override
    public void printMiss(Player player) {
        System.out.println(player.getName() + " " + ANSI_RED + "missed" + ANSI_RESET);
    }

    @Override
    public void printDestroyMsg(Player enemy, Ship ship) {
        char x = (char) (ship.getShipSquares().get(1).getX() + 65);
        int y = ship.getShipSquares().get(1).getY() + 1;
        System.out.println(enemy.getEnemy().getName() + " destroyed " + enemy.getName()
                + "'s " + ship.getShipType() + " [" + x + y + "]" );
    }

    @Override
    public void printHit(Player player, Square square) {
        char x = (char) (square.getX() + 65);
        int y = square.getY() + 1;
        System.out.println(player.getName() + " hit " + player.getEnemy().getName() + "'s ship [" + x + y + "]");
    }

    @Override
    public void printScore(int score) {
        System.out.println("Your score - " + score);
    }

    private String printSquare(Square square) {
        String result = " ";
        switch (square.getSquareStatus()) {

            case HIT:
                result = ANSI_RED + 'X' + ANSI_RESET;
                break;
            case SHIP:
                result = ANSI_GREEN + 'W' + ANSI_RESET;
                break;
            case OCEAN:
            case BOARD:
                result = ANSI_BLUE + '.' + ANSI_RESET;
                break;
            case MISSED:
                result = ANSI_BLUE + 'o' + ANSI_RESET;
                break;
        }
        return result;
    }

    @Override
    public void printMsgAlreadyShot() {
        System.out.println("You've already shot this square");
    }

    public void printMainMenu() {
        System.out.println("<-------------------->");
        System.out.println("<-------------------->");
        System.out.println("<-----SeaBattle------>");
        System.out.println("<-------------------->");
        System.out.println("<--[Enter gameMODE]-->");
        System.out.println("<-------------------->");
        System.out.println("<-------------------->");
        System.out.println("<---[0-PvC, 1-PvP]--->");
        System.out.println("<-------------------->");
        System.out.println("<-------------------->");
    }

    public void printShipArrangeMod() {
        System.out.println("<-------------------->");
        System.out.println("<-------------------->");
        System.out.println("<-----SeaBattle------>");
        System.out.println("<-------------------->");
        System.out.println("<------[Select]------>");
        System.out.println("<--[placement mode]-->");
        System.out.println("<-------------------->");
        System.out.println("<[0-Auto, 1-Manually]>");
        System.out.println("<-------------------->");
        System.out.println("<-------------------->");
    }

    public void printEnterName() {
        System.out.println("<-------------------->");
        System.out.println("<-------------------->");
        System.out.println("<-----SeaBattle------>");
        System.out.println("<-------------------->");
        System.out.println("<-------------------->");
        System.out.println("<----[Enter Name]---->");
        System.out.println("<-------------------->");
        System.out.println("<-------------------->");
        System.out.println("<-------------------->");
        System.out.println("<-------------------->");
    }
    public void printClearScreen() {
        System.out.println("<-------------------->");
        System.out.println("<-------------------->");
        System.out.println("<-------------------->");
        System.out.println("<-------------------->");
        System.out.println("<-------------------->");
        System.out.println("<-------------------->");
        System.out.println("<-------------------->");
        System.out.println("<-------------------->");
        System.out.println("<-------------------->");
        System.out.println("<-------------------->");
    }

    public void printCallPlayer() {
        System.out.println("<-------------------->");
        System.out.println("<-------------------->");
        System.out.println("<-------------------->");
        System.out.println("<--------Call-------->");
        System.out.println("<---another player--->");
        System.out.println("<-------------------->");
        System.out.println("<-------------------->");
        System.out.println("<-------------------->");
        System.out.println("<-------------------->");
        System.out.println("<-------------------->");
    }
}