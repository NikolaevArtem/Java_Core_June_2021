package course_project.services;

import course_project.enums.CellStatus;
import course_project.objects.fields.Field;

import static java.lang.Math.random;

public class ShipLocationGenerator {

    public void generateShips(Field field) {
        placeShips(field, 1, 3);
        placeShips(field, 2, 2);
        placeShips(field, 3, 1);
        placeShips(field, 4, 0);
    }

    private void placeShips(Field field, int amount, int coordDiff) {
        for (int i = 0; i < amount; i++) {
            boolean foundPlace = false;
            while (!foundPlace) {
                int x = (int) (random() * 10);
                int y = (int) (random() * 10);
                if (isValidPlace(field, x, x, y - coordDiff, y)) {
                    fillShip(field, x, x, y - coordDiff, y);
                    foundPlace = true;
                } else if (isValidPlace(field, x, x + coordDiff, y, y)) {
                    fillShip(field, x, x + coordDiff, y, y);
                    foundPlace = true;
                } else if (isValidPlace(field, x - coordDiff, x, y, y)) {
                    fillShip(field, x - coordDiff, x, y, y);
                    foundPlace = true;
                } else if (isValidPlace(field, x, x, y, y + coordDiff)) {
                    fillShip(field, x, x, y, y + coordDiff);
                    foundPlace = true;
                }
            }
        }
    }

    private boolean isValidPlace(Field field, int x1, int x2, int y1, int y2) {
        if (isNotInRange0to9(x1) || isNotInRange0to9(x2) || isNotInRange0to9(y1) || isNotInRange0to9(y2)) {
            return false;
        }
        if (x2 == x1) {
            for (int y = y1 - 1; y <= y2 + 1; y++) {
                if (isNotInRange0to9(y)) {
                    continue;
                }
                if (isNotFreeCell(field, x1, y)) {
                    return false;
                }
                if ((!isNotInRange0to9(x1 - 1) && isNotFreeCell(field, x1 - 1, y)) ||
                        (!isNotInRange0to9(x1 + 1) && isNotFreeCell(field, x1 + 1, y))) {
                    return false;
                }
            }
        } else {
            for (int x = x1 - 1; x <= x2 + 1; x++) {
                if (isNotInRange0to9(x)) {
                    continue;
                }
                if (isNotFreeCell(field, x, y1)) {
                    return false;
                }
                if ((!isNotInRange0to9(y1 - 1) && isNotFreeCell(field, x, y1 - 1)) ||
                        (!isNotInRange0to9(y2 + 1) && isNotFreeCell(field, x, y1 + 1))) {
                    return false;
                }
            }
        }
        return true;
    }

    private void fillShip(Field field, int x1, int x2, int y1, int y2) {
        if (x1 == x2) {
            for (int i = y1; i <= y2; i++) {
                field.setCellStatus(x1, i, CellStatus.HAS_SHIP);
            }
        } else {
            for (int i = x1; i <= x2; i++) {
                field.setCellStatus(i, y1, CellStatus.HAS_SHIP);
            }
        }
    }

    private boolean isNotInRange0to9(int x) {
        return !(0 <= x && x <= 9);
    }

    private boolean isNotFreeCell(Field field, int x, int y) {
        return field.getCellStatus(x, y) != CellStatus.FREE;
    }

}
