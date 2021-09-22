package course_project.sea_battle.controller.impl;

import course_project.sea_battle.controller.FieldFillController;
import course_project.sea_battle.model.CellStatus;
import course_project.sea_battle.model.Field;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ManualFieldFillControllerTest {
    FieldFillController fieldFillController = ManualFieldFillController.getInstance();
    Field field = FieldControllerImpl.getInstance().instance();

    @Test
    void setShips1Test() {
        fieldFillController.setGameSetupHolder(() -> {
            Map<Integer, Integer> integerIntegerMap = new TreeMap<>(Comparator.reverseOrder());
            integerIntegerMap.put(6, 1);
            return integerIntegerMap;
        });

        IOControllerImpl ioController = IOControllerImpl.getInstance();

        final String value = "a1\nv";
        ioController.setScanner(new Scanner(value));

        fieldFillController.setShips(field);

        assertEquals(6, Arrays.stream(field.getCells())
                .flatMap(Arrays::stream)
                .filter(x -> x.equals(CellStatus.SHIP))
                .count());

        ioController.close();
    }

    @Test
    void setShips2Test() {
        fieldFillController.setGameSetupHolder(() -> {
            Map<Integer, Integer> integerIntegerMap = new TreeMap<>(Comparator.reverseOrder());
            integerIntegerMap.put(6, 2);
            return integerIntegerMap;
        });

        IOControllerImpl ioController = IOControllerImpl.getInstance();

        final String value =
                "a1\nv\n" +
                "c1\ng";

        ioController.setScanner(new Scanner(value));

        fieldFillController.setShips(field);

        assertEquals(6 * 2, Arrays.stream(field.getCells())
                .flatMap(Arrays::stream)
                .filter(x -> x.equals(CellStatus.SHIP))
                .count());

        ioController.close();
    }
}