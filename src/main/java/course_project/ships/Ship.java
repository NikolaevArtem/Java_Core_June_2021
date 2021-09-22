package course_project.ships;

public abstract class Ship {

    private final int size;
    private final String name;
    private int hitCount;

    protected Ship(int size, String shipName) {
        this.size = size;
        this.name = shipName;
        this.hitCount = 0;
    }

    public int getSize() {
        return this.size;
    }

    public String getName() {
        return this.name;
    }

    public boolean isDestroyed() {
        return this.hitCount == this.size;
    }

    public void hitCountIncrease() {
        this.hitCount++;
    }
}
