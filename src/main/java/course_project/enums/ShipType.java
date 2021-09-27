package course_project.enums;

public enum ShipType {
    AIR_CARRIER(1, "Huge air-carrier", 4),
    CRUISER(2, "Cruiser, big one", 3),
    DESTROYER(3, "Destroyer, not a big one", 2),
    TORPEDO0_BOAT(4, "Nothing but a small bot", 1);

    private final int count;
    private final String type;
    private final int size;

    ShipType(int count, String type, int size) {
        this.count = count;
        this.type = type;
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public int getCount() {
        return count;
    }

    public String getType() {
        return type;
    }

}
