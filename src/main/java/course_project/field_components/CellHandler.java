package course_project.field_components;

public class CellHandler {

    public boolean isLine(Coordinate[] coordinates) {
        if (coordinates.length == 1) {
            return true;
        }
        if (coordinates.length != 2) {
            return false;
        }
        return sameLine(coordinates, true) || sameLine(coordinates, false);
    }

    public int cellCount(Coordinate[] coordinates) {
        if (coordinates.length == 1) {
            return 0;
        }
        if (coordinates.length == 2) {
            Coordinate start = coordinates[0];
            Coordinate end = coordinates[1];
            if (sameLine(coordinates, true)) {
                return Math.abs(start.column - end.column);
            } else if (sameLine(coordinates, false)) {
                return Math.abs(start.row - end.row);
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }

    public boolean sameLine(Coordinate[] coordinates, boolean isRow) {
        if (coordinates.length == 1) {
            return true;
        }
        if (coordinates.length == 2) {
            Coordinate start = coordinates[0];
            Coordinate end = coordinates[1];
            return isRow ? start.row == end.row : start.column == end.column;
        } else {
            return false;
        }
    }

}
