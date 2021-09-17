package course_project.SeaBattle.Utility;

import course_project.SeaBattle.Models.Square;

import java.util.Scanner;

public class Input {

    private static final Scanner scanner = new Scanner(System.in);

    public static String getPlayerName() {
        String line = readConsole();
        return line;
    }

    public static Square getSquare() {
        String squareXY = readConsole();
        int x = -1;
        int y = -1;

        while (x < 0 && y < 0){
                x = ((int) squareXY.toUpperCase().charAt(0)) - 65;
                y = Integer.parseInt(squareXY.substring(1)) - 1;
        }

        return new Square(x, y, SquareStatus.SHIP);
    }

    public static int getShipDirection() {
        int direction = Integer.parseInt(readConsole());
        return direction;
    }

    private static String readConsole() {
        String line = scanner.nextLine();
        return line;
    }
}
