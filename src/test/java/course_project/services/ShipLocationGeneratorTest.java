package course_project.services;

import course_project.enums.CellStatus;
import course_project.objects.fields.ComputerField;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShipLocationGeneratorTest {

    @Test
    void generateShipsTest() {
        ComputerField computerField = new ShipLocationGenerator().generateShips();

        int shipCellCount = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (computerField.getCellStatus(i, j) == CellStatus.HAS_SHIP) {
                    shipCellCount++;
                    assertTrue(has0to2shipCellAround(computerField, i, j));

                }
            }
        }

        assertEquals(20, shipCellCount);
    }

    private boolean has0to2shipCellAround(ComputerField field, int x, int y) {
        int hasShipCellCount = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i > 9 || j > 9 || i < 0 || j < 0) {
                    continue;
                }
                if (field.getCellStatus(i, j) == CellStatus.HAS_SHIP) {
                    hasShipCellCount++;
                }
            }
        }
        return hasShipCellCount == 1 || hasShipCellCount == 2 || hasShipCellCount == 3;
    }
}
