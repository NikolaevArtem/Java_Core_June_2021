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

        while (!InputValidator.isLegalCoordinate(squareXY)) {
            System.out.println("A-J 1 - 10");
            squareXY = readConsole();
        }
            x = ((int) squareXY.toUpperCase().charAt(0)) - 65;
            y = Integer.parseInt(squareXY.substring(1)) - 1;

        System.out.println("x-" + x + " y-" + y );
        return new Square(x, y, SquareStatus.SHIP);
    }

    public static int getShipDirection() {
        String directionString = readConsole();
        int direction;

        while (!InputValidator.isLegalDirection(directionString)) {
            System.out.println("direction 1 - 0");
            directionString = readConsole();
        }

        direction = Integer.parseInt(directionString) ;

        return direction;
    }

    private static String readConsole() {
        String line = scanner.nextLine();
        return line;
    }


}
