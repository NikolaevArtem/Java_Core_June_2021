package course_project.field_components;

import course_project.enums.CellState;

public class Cell {
    private CellState state = CellState.EMPTY;
    private final Coordinate coordinate;

    public Cell(int r, int c) {
        this.coordinate = new Coordinate(r, c);
    }

    public void setState(CellState state) {
        this.state = state;
    }

    public CellState getState() {
        return state;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    @Override
    public String toString() {
        return state.toString();
    }
}
