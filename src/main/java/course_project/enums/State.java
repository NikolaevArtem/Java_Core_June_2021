package course_project.enums;

public enum State {
    DECK('#'),
    MISS('*'),
    HIT('X');

    private final char state;

    State(char state) {
        this.state = state;
    }

    public char getState() {
        return state;
    }

    @Override
    public String toString() {
        return String.valueOf(state);
    }
}

