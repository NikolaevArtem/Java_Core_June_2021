package course_project;

import java.util.Arrays;

class Ship {

    private final Point[] points;
    private final int size;
    private final String errorMessage = "Wrong ship location!";

    Ship(Point[][] field, Point entry, int size, ShipLocationType type) throws IllegalArgumentException {
        points = new Point[size];
        this.size = size;


        for (int i = 0, x = entry.getX(), y = entry.getY(); i < size; i++) {
            Point point;
            try {
                point = field[x][y];
            } catch (IndexOutOfBoundsException e) {
                throw new IllegalArgumentException(errorMessage);
            }
            if (point.getType() == MapPointType.Ship) {
                throw new IllegalArgumentException(errorMessage);
            }
            checkNearestPoints(field, point);
            points[i] = point;
            switch (type) {
                case TO_DOWN:
                    y++;
                    break;
                case TO_RIGHT:
                    x++;
                    break;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        for (Point point : points) {
            point.setType(MapPointType.Ship);
        }

    }

    private boolean IsShipPoint(Point point) {
        return Arrays.asList(points).contains(point);
    }

    boolean IsDestroyed () {
        return Arrays.stream(points).allMatch(e -> e.getType() == MapPointType.FiredShip);
    }

    private void checkNearestPoints(Point[][] field, Point entry) throws IllegalArgumentException {

        try {
            if (field[entry.getX() - 1][entry.getY()].getType() == MapPointType.Ship && !IsShipPoint(entry)) {
                throw new IllegalArgumentException(errorMessage);
            }
        } catch (IndexOutOfBoundsException e) {

        }

        try {
            if (field[entry.getX() + 1][entry.getY()].getType() == MapPointType.Ship && !IsShipPoint(entry)) {
                throw new IllegalArgumentException(errorMessage);
            }
        } catch (IndexOutOfBoundsException e) {

        }

        try {
            if (field[entry.getX()][entry.getY() - 1].getType() == MapPointType.Ship && !IsShipPoint(entry)) {
                throw new IllegalArgumentException(errorMessage);
            }
        } catch (IndexOutOfBoundsException e) {

        }

        try {
            if (field[entry.getX()][entry.getY() + 1].getType() == MapPointType.Ship && !IsShipPoint(entry)) {
                throw new IllegalArgumentException(errorMessage);
            }
        } catch (IndexOutOfBoundsException e) {

        }
    }

    int getSize() {
        return size;
    }
}
