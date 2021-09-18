package course_project.engine;

import course_project.models.Board;
import course_project.models.Coordinate;

import java.util.List;

public class PositionChecker {

    public static boolean possibleToPlace(Board b, Coordinate c, int size, String mode) {
        // mode h: left -> right , mode v: up - > down from coordinate given
        int horizSize;
        int vertSize;

        if (mode.equalsIgnoreCase("h")) { // space needed for ship in horizontal mode
            horizSize = size;
            vertSize = 1;
        } else { // space needed for ship in vertical mode
            horizSize = 1;
            vertSize = size;
        }

        List<String> currentRow;
        List<String> upperRow;
        List<String> lowerRow;

        // Checking upper row
        if (b.getBoard().containsKey(c.Row() - 1)) { // if it exist
            upperRow = b.getBoard().get(c.Row() - 1);
            for (int col = c.Col() - 1; col <= c.Col() + horizSize; col++) { // check all cols from current -1 to current + size
                if (col >= 0 && col < 10) { // if mainBoard contains such col
                    if (!upperRow.get(col).equals(" ")) { // cell must be empty
                        return false;
                    }
                }
            }
        }

        // Checking hull rows
        for (int i = 0; i < vertSize; i++) {
            if (!b.getBoard().containsKey(c.Row() + i)) { // if doesn`t exist  -> not enough vertical space
                return false;
            }
            currentRow = b.getBoard().get(c.Row() + i);
            for (int col = c.Col() - 1; col <= c.Col() + horizSize; col++) { // check all cols from current -1 to current + horiz size
                if (col >= 0 && col < 10) { // if mainBoard contains such col
                    if (!currentRow.get(col).equals(" ")) { // cell must be empty
                        return false;
                    }
                } else {
                    if ((col - 1 > 9) && mode.equalsIgnoreCase("h")) { // if not enough space horizontally (last hull coord comes out of the map)
                        return false;
                    }
                }
            }

        }


        // Checking lower row
        if (b.getBoard().containsKey(c.Row() + vertSize)) { // if it exist
            lowerRow = b.getBoard().get(c.Row() + vertSize);
            for (int col = c.Col() - 1; col <= c.Col() + horizSize; col++) { // check all cols from current -1 to current + size
                if (col >= 0 && col < 10) { // if mainBoard contains such col
                    if (!lowerRow.get(col).equals(" ")) { // cell must be empty
                        return false;
                    }
                }
            }
        }

        return true;
    }


}
