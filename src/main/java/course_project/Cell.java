package course_project;

public class Cell {
    private CellState state = CellState.EMPTY;
    private final Coordinate coordinate;

    public Cell(int row, int column) {
        this.coordinate = new Coordinate(row, column);
    }

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
