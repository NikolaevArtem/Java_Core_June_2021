package course_project.sea_battle.controller.impl;

import course_project.sea_battle.controller.FireController;
import course_project.sea_battle.model.CellStatus;
import course_project.sea_battle.model.Field;

public final class FireControllerImpl implements FireController {
    private final ValidateControllerImpl validateController = ValidateControllerImpl.getInstance();
    private final ParserControllerImpl parserController = ParserControllerImpl.getInstance();

    private FireControllerImpl() {}

    @Override
    public CellStatus fire(Field targetField, Field enemyField, String coordinate) {
        if (enemyField == null) throw new RuntimeException("Поле не может быть null");

        int[] cordXY = parserController.parseCoordinate(coordinate);
        int x = cordXY[0], y = cordXY[1];

        CellStatus cellBefore = targetField.getCell(x, y);
        CellStatus cellAfter;
        if (cellBefore == CellStatus.SHIP) {
            cellAfter = CellStatus.HIT;
        }
        else {
            cellAfter = CellStatus.SHOT;
        }
        targetField.setCell(x, y, cellAfter);
        enemyField.setCell(x, y, cellAfter);
        return cellAfter;
    }

    @Override
    public boolean checkFire(Field field, String coordinate) {
        if (field == null) return false;
        if (validateController.coordinate(coordinate)) return false;
        int[] cordXY = parserController.parseCoordinate(coordinate);

        return field.getCell(cordXY[0], cordXY[1]) != CellStatus.HIT
                && field.getCell(cordXY[0], cordXY[1]) != CellStatus.SHOT;
    }

    public static FireControllerImpl getInstance() {
        return FireControllerImpl.Holder.INSTANCE;
    }

    private static class Holder {
        static final FireControllerImpl INSTANCE = new FireControllerImpl();
    }
}
