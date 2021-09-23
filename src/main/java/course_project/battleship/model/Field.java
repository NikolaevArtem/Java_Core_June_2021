package course_project.battleship.model;

import course_project.battleship.utils.Position;

public class Field {
    public static final int FILED_SIZE = 10;
    private Position[][] field;

    public Field() {
        this.field = new Position[FILED_SIZE][FILED_SIZE];
        initTable();
    }

    private void initTable() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = new Position();
            }
        }
    }

    public Position[][] getField() {
        return field;
    }

    public void setField(Position[][] field) {
        this.field = field;
    }
}
