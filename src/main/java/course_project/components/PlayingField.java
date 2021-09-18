package course_project.components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayingField {

    private final int[][] fleet = new int[10][10];
    private final boolean[][] cellsShot = new boolean[10][10];
    private final Map<Coordinate, Ship> coordinateToShip = new HashMap<>(32); // size for 10 ships and no rehashing
    private final List<Ship> playersShips = new ArrayList<>();

    public Map<Coordinate, Ship> getCoordinateMapping() {
        return coordinateToShip;
    }

    public List<Ship> getPlayersShips() {
        return playersShips;
    }

    public int[][] getFleet() {
        return fleet;
    }

    public boolean[][] getCellsShot() {
        return cellsShot;
    }

    public boolean isCellShot(Coordinate cell) {
        return cellsShot[cell.getX()][cell.getY()];
    }

    public void placeShip(Ship ship) {
        int size = ship.getSize();
        for (Coordinate cell : ship.getCoordinates()) {
            fleet[cell.getX()][cell.getY()] = size;
            coordinateToShip.put(cell, ship);
        }
        playersShips.add(ship);
    }

    public boolean placeShot(Coordinate cell) {
        if (!cellsShot[cell.getX()][cell.getY()]) {
            cellsShot[cell.getX()][cell.getY()] = true;
            if (coordinateToShip.containsKey(cell)) {
                System.out.println("Hit");
                shootAtShip(coordinateToShip.get(cell));
                return true;
            }
        }
        System.out.println("Miss");
        return false;
    }

    private void shootAtShip(Ship hitShip) {
        hitShip.gotShot();
        if (hitShip.isSunk()) {
            sinkShip(hitShip);
        }
    }

    private void sinkShip(Ship hitShip) {
        playersShips.remove(hitShip);
        markAdjacentCells(hitShip);
        System.out.println(hitShip.getSize() + "-deck ship is sunk");
    }

    private void markAdjacentCells(Ship hitShip) {
        for (Coordinate c : hitShip.getCoordinates()) {
            if (c.getX() > 0) {
                cellsShot[c.getX() - 1][c.getY()] = true;
            }
            if (c.getX() < 9) {
                cellsShot[c.getX() + 1][c.getY()] = true;
            }
            if (c.getY() > 0) {
                cellsShot[c.getX()][c.getY() - 1] = true;
            }
            if (c.getY() < 9) {
                cellsShot[c.getX()][c.getY() + 1] = true;
            }
        }
    }

}
