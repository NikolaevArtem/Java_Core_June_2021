package course_project.sea_battle.controller;

import course_project.sea_battle.model.Field;

public interface FireController {
    boolean fire(Field targetField, Field enemyField, String coordinate);
}
