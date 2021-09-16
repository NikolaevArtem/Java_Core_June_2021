package course_project;

public class CellHandler {

    public boolean isLine(String[] coordinates) {
        if (coordinates.length != 2 ||
                !(Coordinate.check(coordinates[0]) && Coordinate.check(coordinates[1]))) {
            return false;
        }
        return sameLine(coordinates, true) || sameLine(coordinates, false);
    }

    public int cellCount(String[] coordinates) {
        Coordinate start = new Coordinate(coordinates[0]);
        Coordinate end = new Coordinate(coordinates[1]);
        if (sameLine(coordinates, true)) {
            return Math.abs(start.column - end.column);
        } else {
            return Math.abs(start.row - end.row);
        }
    }

    public boolean sameLine(String[] coordinates, boolean row) {
        Coordinate start = new Coordinate(coordinates[0]);
        Coordinate end = new Coordinate(coordinates[1]);
        return row ? start.row == end.row : start.column == end.column;
    }

}
