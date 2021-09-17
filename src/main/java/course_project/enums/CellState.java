package course_project.enums;

public enum CellState {
    EMPTY ('~'),
    DECK ('O'),
    MISS ('*'),
    HIT ('X');

    private final char state;

    CellState(char state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return String.valueOf(state);
    }
}
