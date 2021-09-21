package course_project.battleship_game.model;

public enum ShipType {
    BATTLESHIP(4, 1),
    CRUISER(3, 2),
    DESTROYER(2, 3),
    TORPEDO_BOAT(1, 4);

    private final int length;
    private final int amount;

    ShipType(int length, int amount) {
        this.length = length;
        this.amount = amount;
    }

    public int getLength() {
        return length;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return this.name() +
                " with length of " + length + " cells." +
                " The amount of " + this.name().replace("_", " ").toLowerCase() + "s should be " + amount + ".";
    }
}
