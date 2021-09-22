package course_project.sea_battle.model;

public enum CellStatus {
    SHIP('█'),
    SHOT('⊙'),
    WATER('~'),
    HIT('X');

    private final char value;

    CellStatus(char value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
