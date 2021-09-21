package course_project.gamestuff.field;

import course_project.gamestuff.ships.Ship;

public class Cell {

    private final int x;
    private final int y;
    private Ship ref;
    private boolean hit;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        this.ref = null;
        this.hit = false;
    }

    public boolean isHit() {
        return this.hit;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }

    public Ship isShipPlacedAtCell() {
        return this.ref == null ? null : ref;
    }

    public void placeShipOnCell(Ship ship) {
        this.ref = ship;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Ship getRef() {
        return this.ref;
    }

}
