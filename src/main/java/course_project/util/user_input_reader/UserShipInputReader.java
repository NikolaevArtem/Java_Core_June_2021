package course_project.util.user_input_reader;

import course_project.components.Coordinate;

import java.util.Scanner;

public class UserShipInputReader extends UserInputReader {

    private String orientation;

    public UserShipInputReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getOrientation() {
        return orientation;
    }

    public Coordinate getPointFromInput() {
        resetState();
        while (outOfRange(x, y)) {
            String input = scanner.nextLine();
            parseInput(input);
            validateInput();
        }
        return new Coordinate(x, y);
    }

    private void parseInput(String input) {
        if (input.matches("[a-jA-J]([1-9]|10) (ver|hor)")) {
            String[] inputWords = input.split(" ");
            x = Integer.parseInt(inputWords[0].substring(1)) - 1;
            y = inputWords[0].toUpperCase().charAt(0) - 65;
            orientation = inputWords[1];
        }
    }

    private void validateInput() {
        if (outOfRange(x, y)) {
            System.out.println("Coordinates should be in range A-J, 1-10 (e.g. A1-J10)");
            System.out.println("Orientation should be \"ver\" or \"hor\"");
        }
    }
}
