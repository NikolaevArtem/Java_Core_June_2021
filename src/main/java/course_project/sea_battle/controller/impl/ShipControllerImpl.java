package course_project.sea_battle.controller.impl;

import course_project.sea_battle.controller.ShipController;
import course_project.sea_battle.model.CellStatus;
import course_project.sea_battle.model.Field;

import java.util.Arrays;

public final class ShipControllerImpl implements ShipController {
    private final ValidateControllerImpl validateController = ValidateControllerImpl.getInstance();
    private final ParserControllerImpl parserController = ParserControllerImpl.getInstance();

    private ShipControllerImpl() {}

    @Override
    public boolean placeShip(Field field, String coordinate, String vector, int size) {
        if (field == null) return false;
        if (!validateController.coordinate(coordinate)) return false;
        if (!validateController.vector(vector)) return false;

        int[] cordXY = parserController.parseCoordinate(coordinate);
        int x = cordXY[0], y = cordXY[1];
        boolean isVertical = parserController.isVerticalVector(vector);

        Ship ship = new Ship(size, x, y, isVertical);

        if (!isAvailable(field, ship)) return false;
        for (int i = 0; i < ship.getSize(); i++) {
            if (ship.isVertical()) {
                field.setCell(ship.starX, ship.startY + i, CellStatus.SHIP);
            } else {
                field.setCell(ship.starX + i, ship.startY, CellStatus.SHIP);
            }
        }
        return true;
    }

    @Override
    public boolean isAnyShipAlive(Field field) {
        if (field == null) return false;
        return Arrays.stream(field.getCells())
                .flatMap(Arrays::stream)
                .anyMatch(x -> x == CellStatus.SHIP);
    }

    private boolean isAvailable(Field field, Ship ship) {
        if (field.getCell(ship.starX, ship.startY) == CellStatus.SHIP) return false;
        if(cellCheckCross(field, ship.starX, ship.startY)) return false;

        if (ship.isVertical()){
            if (ship.startY + ship.getSize() > Field.FIELD_SIZE) return false;
            if (cellCheckCross(field, ship.starX, ship.startY + ship.getSize() - 1)) return false;
        } else {
            if (ship.starX + ship.getSize() > Field.FIELD_SIZE) return false;
            if (cellCheckCross(field, ship.starX + ship.getSize() - 1, ship.startY)) return false;
        }
        for (int i = 0; i < ship.getSize(); i++) {
            int dx = 0;
            int dy = 0;

            if (ship.isVertical()) dy = i;
            else dx = i;

            if (cellCheckPlus(field, ship.starX + dx, ship.startY + dy)) return false;
        }

        return true;
    }

    private boolean cellCheckCross(Field field, int x, int y) {
        if (y - 1 >= 0 && x - 1 >= 0) {
            if (field.getCell(x - 1, y - 1) == CellStatus.SHIP) return true;
        }
        if (y - 1 >= 0 && x + 1 < Field.FIELD_SIZE){
            if (field.getCell(x + 1, y - 1) == CellStatus.SHIP) return true;
        }
        if (y + 1 < Field.FIELD_SIZE && x - 1 >= 0) {
            if (field.getCell(x - 1, y + 1) == CellStatus.SHIP) return true;
        }
        if (y + 1 < Field.FIELD_SIZE && x + 1 < Field.FIELD_SIZE) {
            if (field.getCell(x + 1, y + 1) == CellStatus.SHIP) return true;
        }

        return false;
    }

    private boolean cellCheckPlus(Field field, int x, int y) {
        if (x + 1 < Field.FIELD_SIZE) {
            if (field.getCell(x + 1, y) == CellStatus.SHIP) return true;
        }

        if (x - 1 >= 0) {
            if (field.getCell(x - 1, y) == CellStatus.SHIP) return true;
        }

        if (y + 1 < Field.FIELD_SIZE) {
            if (field.getCell(x, y + 1) == CellStatus.SHIP) return true;
        }
        if (y - 1 >= 0) {
            if (field.getCell(x, y - 1) == CellStatus.SHIP) return true;
        }
        return false;
    }

    public static ShipControllerImpl getInstance() {
        return ShipControllerImpl.Holder.INSTANCE;
    }

    private static class Holder {
        static final ShipControllerImpl INSTANCE = new ShipControllerImpl();
    }

    private static class Ship {
        private final int size;
        private final boolean isVertical;
        private final int starX;
        private final int startY;

        public Ship(int size, int x, int y, boolean isVertical) {
            this.size = size;

            this.starX = x;
            this.startY = y;
            this.isVertical = isVertical;
        }

        public int getSize() {
            return size;
        }

        public boolean isVertical() {
            return isVertical;
        }
    }
}
