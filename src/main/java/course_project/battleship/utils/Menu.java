package course_project.battleship.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class Menu {
    private static final Scanner scanner = new Scanner(System.in);

    private Menu() {
    }

    public static Coordinate createCoordinate() {
        System.out.println("Please, enter the number:");
        int x;
        try {
            x = scanner.nextInt() - 1;
        } catch (InputMismatchException e) {
            return null;
        } finally {
            scanner.nextLine();
        }

        System.out.println("Please, enter the char:");
        String str = scanner.nextLine().toUpperCase();
        if (str.length() != 1) {
            return null;
        }

        int y = (str.charAt(0)) - 65;

        return new Coordinate(x, y);
    }


    public static int createDirection() {
        System.out.println("Choose direction: \n1. Vertical\n2. Horizontal");

        int direction;
        try {
            direction = scanner.nextInt();
        } catch (InputMismatchException e) {
            return -1;
        } finally {
            scanner.nextLine();
        }

        return direction;
    }

    public static int getInt(int range) {
        int number;
        while (true) {
            try {
                number = scanner.nextInt();
                if (number > range || number < 1) {
                    throw new InputMismatchException();
                }
                break;
            } catch (InputMismatchException ignored) {
                System.out.println("Entered invalid value!");
            } finally {
                scanner.nextLine();
            }
        }
        return number;
    }
}
