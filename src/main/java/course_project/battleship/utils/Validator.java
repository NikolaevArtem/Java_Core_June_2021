package course_project.battleship.utils;


import course_project.battleship.model.Field;

public final class Validator {

    private Validator(){}

    public static boolean isAvailable(Coordinate coordinate, int deck, int direction, Field battlefield) {
        if (!isOutOfBound(coordinate, deck, direction, battlefield)) {
            return false;
        }

        if (battlefield.getField()[coordinate.getX()][coordinate.getY()].getState() == Position.State.SHIP) {
            return false;
        }

        if (!checkAroundTheShip(coordinate, direction, deck, battlefield)) {
            return false;
        }

        return true;
    }

    public static boolean isValidDirection(int direction) {
        return 2 >= direction && direction >= 1;
    }

    public static boolean isOutOfBound(Coordinate coordinate, int deck, int direction, Field battlefield) {
        if (direction == 1) {
            if (coordinate.getY() + deck > battlefield.getField().length) {
                return false;
            }
        }
        if (direction == 2) {
            if (coordinate.getX() + deck > battlefield.getField()[0].length) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkAroundTheShip(Coordinate coordinate, int direction, int deck, Field battlefield) {
        for (int i = 0; i < deck; i++) {
            if (direction == 1) {
                if (!checkAroundTheCoordinate(coordinate.getX(), (coordinate.getY() + i), battlefield)) {
                    return false;
                }
            } else {
                if (!checkAroundTheCoordinate((coordinate.getX() + i), coordinate.getY(), battlefield)) {
                    return false;
                }
            }
        }
        return true;
    }



    public static boolean isValidCoordinate(Coordinate coordinate) {
        if (coordinate.getX() < 0 || coordinate.getX() >= 10 ||
                coordinate.getY() < 0 || coordinate.getY() >= 10) {
            return false;
        }
        return true;
    }

    public static boolean checkAroundTheCoordinate(int x, int y, Field battlefield) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int xi = Math.min(Math.max((x + (j - 1)), 0), battlefield.getField().length - 1);
                int yi = Math.min(Math.max((y + (i - 1)), 0), battlefield.getField()[i].length - 1);
                if (battlefield.getField()[xi][yi].getState() != Position.State.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
}
