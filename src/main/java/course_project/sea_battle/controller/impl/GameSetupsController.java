package course_project.sea_battle.controller.impl;

import course_project.sea_battle.controller.FieldController;
import course_project.sea_battle.controller.ShipController;
import course_project.sea_battle.model.Field;

public final class GameSetupsController {
    private final int[] DECK_4 = {4, 0};
    private final int[] DECK_3 = {3, 0};
    private final int[] DECK_2 = {2, 0};
    private final int[] DECK_1 = {1, 2};

    private final ShipController shipController = ShipControllerImpl.getInstance();
    private final IOControllerImpl ioController = IOControllerImpl.getInstance();
    private final FieldController fieldController = FieldControllerImpl.getInstance();

    private GameSetupsController() {}

    public void setShips(Field field) {
        setShipsByType(field, DECK_4);
        setShipsByType(field, DECK_3);
        setShipsByType(field, DECK_2);
        setShipsByType(field, DECK_1);
    }

    private void setShipsByType(Field field, int[] deck) {
        String coordinate;
        String vector;
        ioController.print("Введите " + deck[0] + " палубных коробля. Количество: " + deck[1]);
        for (int i = 0; i < deck[1]; i++) {
            do {
                coordinate = ioController.dialog("Введите координаты\n(Exemple: a1):");
                vector = ioController.dialog("Введите направление(v/g):");
            } while (!shipController.placeShip(field, coordinate, vector, deck[0]));
            fieldController.drawFields(field);
        }
    }

    public static GameSetupsController getInstance() {
        return GameSetupsController.Holder.INSTANCE;
    }

    private static class Holder {
        static final GameSetupsController INSTANCE = new GameSetupsController();
    }
}
