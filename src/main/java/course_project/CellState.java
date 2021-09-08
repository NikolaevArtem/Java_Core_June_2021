package course_project;

public enum CellState {
    EMPTY ('~'),
    DECK ('O'),
    MISS ('*'),
    HIT ('X');

    private final char state;

    CellState(char state) {
        this.state = state;
    }

    public char getSymbol() {
        return state;
    }

    @Override
    public String toString() {
        return String.valueOf(state);
    }
}
