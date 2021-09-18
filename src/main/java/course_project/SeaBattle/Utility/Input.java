package course_project.SeaBattle.Utility;

import course_project.SeaBattle.Models.Square;

import java.util.Scanner;

public class Input {

    private static final Scanner scanner = new Scanner(System.in);

    public static String getPlayerName() {
        return readConsole();
    }

    public static Square getSquare() {
        String squareXY = readConsole();
        int x;
        int y;

        while (!InputValidator.isLegalCoordinate(squareXY)) {
            System.out.println("Format: [A-J, 1-10], Example : A1 or J7");
            squareXY = readConsole();
        }
            x = ((int) squareXY.toUpperCase().charAt(0)) - 65;
            y = Integer.parseInt(squareXY.substring(1)) - 1;

        return new Square(x, y, SquareStatus.SHIP);
    }

    public static int getShipDirection() {
        String directionString = readConsole();
        int direction;

        while (!InputValidator.isLegalDirection(directionString)) {
            System.out.println("[1 - vertically/ 0 - horizontally]");
            directionString = readConsole();
        }

        direction = Integer.parseInt(directionString) ;

        return direction;
    }

    private static String readConsole() {
        return scanner.nextLine();
    }


    public static int getMod() {
        int mod;
        String line = readConsole();
        while (!InputValidator.isLegalMode(line)) {
            line = readConsole();
        }
        mod = Integer.parseInt(line) ;
        return mod;
    }
}
