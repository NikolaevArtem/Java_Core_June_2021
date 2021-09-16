package course_project.util;

import course_project.components.Coordinate;

import java.util.Scanner;

public class UserInputReader {

    private final Scanner scanner;
    private int x;
    private int y;
    private String orientation;

    public UserInputReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public void getInput() {
        x = -1;         // reset state
        y = -1;         // to receive next valid input
        while ((x < 0 || x > 9) || (y < 0 || y > 9)) {
            y = getYFromChar();
            x = scanner.nextInt() - 1;
            orientation = scanner.next();
            validateInput();
        }
    }

    private int getYFromChar() {
        return scanner.next().toUpperCase().charAt(0) - 65;
    }

    private void validateInput() {
        if ((x < 0 || x > 9) || (y < 0 || y > 9)) {
            System.out.println("Coordinates should be in range A-J, 1-10");
        }
        if (!"ver".equalsIgnoreCase(orientation) && !"hor".equalsIgnoreCase(orientation)) {
            System.out.println("Orientation should be \"ver\" or \"hor\"");
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getOrientation() {
        return orientation;
    }

    public static Coordinate getInputForShot(Scanner scanner) {
        int x = -1;
        int y = -1;
        while ((x < 0 || x > 9) || (y < 0 || y > 9)) {
            System.out.print("Enter coordinate to shoot at in A-J 1-10 format (e.g. A 1): ");
            y = scanner.next().toUpperCase().charAt(0) - 65;
            x = scanner.nextInt() - 1;
        }
        return new Coordinate(x, y);
    }
}
