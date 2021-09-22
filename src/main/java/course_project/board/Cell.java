package course_project.board;
//done
import course_project.ships.Ship;

public class Cell {

    private final int x;
    private final int y;
    private boolean hit;
    private Ship reference;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        this.reference = null;
        this.hit = false;
    }

    public boolean isHit() {
        return this.hit;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }

    public Ship getShipReference() {
        if (this.reference == null) return null;
        else return reference;
    }

    public void setShipAtCell(Ship ship) {
        this.reference = ship;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Ship getReference() {
        return this.reference;
    }

}
