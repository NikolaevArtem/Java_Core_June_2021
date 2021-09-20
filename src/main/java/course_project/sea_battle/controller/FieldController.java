package course_project.sea_battle.controller;

import course_project.sea_battle.model.Field;

public interface FieldController {
    Field instance();
    void drawFields(Field... fields);
}
