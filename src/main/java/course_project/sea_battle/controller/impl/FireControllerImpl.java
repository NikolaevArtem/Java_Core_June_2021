package course_project.sea_battle.controller.impl;

import course_project.sea_battle.controller.FireController;
import course_project.sea_battle.model.CellStatus;
import course_project.sea_battle.model.Field;

public final class FireControllerImpl implements FireController {
    private final ValidateControllerImpl validateController = ValidateControllerImpl.getInstance();
    private FireControllerImpl() {}

    @Override
    public boolean fire(Field targetField, Field enemyField, String coordinate) {
        if (targetField == null || enemyField == null) throw new RuntimeException("в атаке что то не так");
        if (validateController.coordinate(coordinate)) return false;
        int x = coordinate.toLowerCase().charAt(0) - 'a';
        int y = Integer.parseInt(coordinate.toLowerCase().substring(1)) - 1;
        CellStatus cellBefore = targetField.getCell(x, y);
        CellStatus cellAfter;
        if (cellBefore == CellStatus.SHOT
                || cellBefore == CellStatus.HIT) {
            return false;
        }else if (cellBefore == CellStatus.SHIP) {
            cellAfter = CellStatus.HIT;
        }
        else {
            cellAfter = CellStatus.SHOT;
        }
        targetField.setCell(x, y, cellAfter);
        enemyField.setCell(x, y, cellAfter);
        return true;
    }

    public static FireControllerImpl getInstance() {
        return FireControllerImpl.Holder.INSTANCE;
    }

    private static class Holder {
        static final FireControllerImpl INSTANCE = new FireControllerImpl();
    }
}
