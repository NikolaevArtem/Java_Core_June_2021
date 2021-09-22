package course_project.sea_battle.controller;

import course_project.sea_battle.model.CellStatus;
import course_project.sea_battle.model.Field;

public interface FireController {
    CellStatus fire(Field targetField, Field enemyField, String coordinate);
    boolean checkFire(Field field, String coordinate);
}
