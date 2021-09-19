package course_project.SeaBattle.utility;

import course_project.SeaBattle.models.Square;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

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

    public static int getMod() {
        int mod;
        String line = readConsole();
        if (line == null) {
            return 0;
        }
        while (!InputValidator.isLegalMode(line)) {
            line = readConsole();
        }
        mod = Integer.parseInt(line) ;
        return mod;
    }

    private static String readConsole() {
        String line = "";

        try  {
            line = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }
}
