package course_project.sea_battle.controller.impl;

import course_project.sea_battle.controller.FieldController;
import course_project.sea_battle.controller.GameSetupHolder;
import course_project.sea_battle.controller.FieldFillController;
import course_project.sea_battle.controller.ShipController;
import course_project.sea_battle.model.Field;

import java.util.Map;
import java.util.Random;

public final class RandomFieldFillController implements FieldFillController {
    private final ShipController shipController = ShipControllerImpl.getInstance();
    private final GameSetupHolder gameSetupHolder = GameSetupHolderImpl.getInstance();
    private final FieldController fieldController = FieldControllerImpl.getInstance();

    private RandomFieldFillController() {}

    @Override
    public void setShips(Field field) {
        Random random = new Random();
        for (Map.Entry<Integer, Integer> entry :
                gameSetupHolder.getMapShips().entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                while (!shipController.placeShipByCoordinate(
                        field,
                        random.nextInt(9),
                        random.nextInt(9),
                        random.nextBoolean(),
                        entry.getKey()));
            }
        }
        fieldController.drawFields(field);
    }

    public static RandomFieldFillController getInstance() {
        return RandomFieldFillController.Holder.INSTANCE;
    }

    private static class Holder {
        static final RandomFieldFillController INSTANCE = new RandomFieldFillController();
    }
}
