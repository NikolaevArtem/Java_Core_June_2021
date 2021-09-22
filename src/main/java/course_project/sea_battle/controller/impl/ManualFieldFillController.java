package course_project.sea_battle.controller.impl;

import course_project.sea_battle.controller.FieldController;
import course_project.sea_battle.controller.FieldFillController;
import course_project.sea_battle.controller.GameSetupHolder;
import course_project.sea_battle.controller.ShipController;
import course_project.sea_battle.model.Field;

import java.util.*;

public final class ManualFieldFillController implements FieldFillController {
    private final ShipController shipController = ShipControllerImpl.getInstance();
    private final IOControllerImpl ioController = IOControllerImpl.getInstance();
    private final FieldController fieldController = FieldControllerImpl.getInstance();
    // я нарушаю свою идею тут, но так проще тестить
    private GameSetupHolder gameSetupHolder = GameSetupHolderImpl.getInstance();

    private ManualFieldFillController() {
    }

    @Override
    public void setShips(Field field) {
        Map<Integer, Integer> mapShips = gameSetupHolder.getMapShips();
        for (Map.Entry<Integer, Integer> entry : mapShips.entrySet()) {
            setShipsByType(field, entry);
        }
    }

    private void setShipsByType(Field field, Map.Entry<Integer, Integer> entry) {
        String coordinate;
        String vector;
        ioController.print("Введите " + entry.getKey() + " палубных коробля. Количество: " + entry.getValue());
        for (int i = 0; i < entry.getValue(); i++) {
            do {
                coordinate = ioController.dialog("Введите координаты\n(Exemple: a1):");
                vector = ioController.dialog("Введите направление(v/g):");
            } while (!shipController.placeShip(field, coordinate, vector, entry.getKey()));
            fieldController.drawFields(field);
        }
    }

    public FieldFillController setGameSetupHolder(GameSetupHolder gameSetupHolder) {
        this.gameSetupHolder = gameSetupHolder;
        return this;
    }

    public static ManualFieldFillController getInstance() {
        return ManualFieldFillController.Holder.INSTANCE;
    }

    private static class Holder {
        static final ManualFieldFillController INSTANCE = new ManualFieldFillController();
    }
}
