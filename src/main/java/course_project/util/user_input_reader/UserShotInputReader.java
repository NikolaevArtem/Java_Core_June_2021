package course_project.util.user_input_reader;

import course_project.components.Coordinate;

import java.util.Scanner;

public class UserShotInputReader extends UserInputReader {

    public UserShotInputReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public Coordinate getPointFromInput() {
        System.out.print("Enter coordinate to shoot at in A-J 1-10 format (e.g. A1): ");
        resetState();
        while (outOfRange(x, y)) {
            String input = scanner.nextLine();
            parseInputForShot(input);
            validateInputForShot();
        }
        return new Coordinate(x, y);
    }

    private void parseInputForShot(String input) {
        if (input.matches("[a-jA-J]([1-9]|10)")) {
            x = Integer.parseInt(input.substring(1)) - 1;
            y = input.toUpperCase().charAt(0) - 65;
        }
    }

    private void validateInputForShot() {
        if (outOfRange(x, y)) {
            System.out.println("Coordinates should be in range A-J, 1-10 (e.g. A1-J10)");
        }
    }
}
