package course_project;

public class Cell {
    private CellState state = CellState.EMPTY;

    public void setState(CellState state) {
        this.state = state;
    }

    public CellState getState() {
        return state;
    }

    @Override
    public String toString() {
        return state.toString();
    }
}
