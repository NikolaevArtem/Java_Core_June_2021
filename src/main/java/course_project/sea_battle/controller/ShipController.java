package course_project.sea_battle.controller;

import course_project.sea_battle.model.Field;

public interface ShipController {
    boolean placeShip(Field field, String coordinate, String vector, int size);
    boolean placeShipByCoordinate(Field field, int x, int y, boolean isVertical, int size);
    boolean isAnyShipAlive(Field field);
}
