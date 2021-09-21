package course_project.gamestuff.ships;

import course_project.gamestuff.field.Cell;

public abstract class Ship {

    private final int size;
    private final String name;
    private int hitCount;
    private Cell startCell;
    private boolean direction = true; // true - vertical, false - horizontal

    protected Ship(int size, String shipName) {
        this.size = size;
        this.name = shipName;
        this.hitCount = 0;
        this.startCell = null;
    }

    public boolean isVertical() {
        return this.direction;
    }

    public void setVertical() {
        this.direction = false;
    }

    public Cell getStartCell() {
        return this.startCell;
    }

    public void setStartCell(Cell cell) {
        this.startCell = cell;
    }

    public int getSize() {
        return this.size;
    }

    public String getName() {
        return this.name;
    }

    public boolean isShipDestroyed() {
        return this.hitCount == this.size;
    }

    public void hitCountIncrease() {
        this.hitCount++;
    }

}
