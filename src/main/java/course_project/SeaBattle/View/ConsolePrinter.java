package course_project.SeaBattle.View;

import course_project.SeaBattle.Models.Grid;
import course_project.SeaBattle.Models.Player;
import course_project.SeaBattle.Models.Square;

import static java.lang.System.lineSeparator;

public class ConsolePrinter {

    public  void printGrid(Player player) {
        Square[][] squares = player.getGrid().getSquares();
        Square[][] enemySquares = player.getEnemy().getGrid().getSquares();

        System.out.println("   A B C D E F G H I J             A B C D E F G H I J");

        for (int y = 0; y < squares[0].length; y++) {
            if (String.valueOf(y + 1).length() >= 2) {
                System.out.print(y + 1 + " ");
            } else {
                System.out.print(y + 1 + "  ");
            }

            for (int x = 0; x < squares[0].length; x++) {
                System.out.print(squares[x][y].print() + " ");
                for (int j = 0; j < enemySquares[0].length; j++) ;
            }

            System.out.print("         ");

            if (String.valueOf(y + 1).length() >= 2) {
                System.out.print(y + 1 + " ");
            } else {
                System.out.print(y + 1 + "  ");
            }

            for (int x = 0; x < enemySquares[0].length; x++) {
                if (enemySquares[x][y].print() == '\u272D') {
                    System.out.print(". ");
                } else {
                    System.out.print(enemySquares[x][y].print() + " ");
                }
            }
            System.out.println();

        }
    }



    private static void enemyGrid(Square[][] enemySquares) {

        for (int y = 0; y < enemySquares[0].length; y++) {
            if (String.valueOf(y).length() > 2) {
                System.out.println("      " + y + 1 + " ");
            } else {
                System.out.print("      " + y + 1 + "   ");
            }

            for (int x = 0; x < enemySquares[0].length; x++) {
                if (enemySquares[x][y].print() == '\u272D') {
                    System.out.println(".");
                }
                System.out.print(enemySquares[x][y].print() + " ");
            }

            System.out.println();
        }
    }
}