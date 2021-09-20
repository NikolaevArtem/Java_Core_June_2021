package course_project.sea_battle.controller.impl;

import course_project.sea_battle.controller.FireController;
import course_project.sea_battle.model.CellStatus;
import course_project.sea_battle.model.Field;

public final class FireControllerImpl implements FireController {
    private final ValidateControllerImpl validateController = ValidateControllerImpl.getInstance();
    private final ParserControllerImpl parserController = ParserControllerImpl.getInstance();

    private FireControllerImpl() {}

    @Override
    public CellStatus fire(Field opponentField, Field radar, String coordinate) {
        if (radar == null || opponentField == null) throw new RuntimeException("Поле не может быть null");

        int[] cordXY = parserController.parseCoordinate(coordinate);
        int x = cordXY[0], y = cordXY[1];

        CellStatus cellBefore = opponentField.getCell(x, y);
        CellStatus cellAfter;
        if (cellBefore == CellStatus.SHIP || cellBefore == CellStatus.HIT) {
            cellAfter = CellStatus.HIT;
        }
        else {
            cellAfter = CellStatus.SHOT;
        }
        opponentField.setCell(x, y, cellAfter);
        radar.setCell(x, y, cellAfter);
        return cellAfter;
    }

    @Override
    public boolean checkFire(Field field, String coordinate) {
        if (field == null) return false;
        if (!validateController.coordinate(coordinate)) return false;
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
