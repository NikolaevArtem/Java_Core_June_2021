package course_project.SeaBattle.utility;

public enum ShipType {
    BOAT(1),
    DESTROYER(2),
    CRUISER(3),
    BATTLESHIP(4);

    private final Integer size;

    ShipType(int size) {
        this.size = size;
    }

    public Integer getSize() {
        return size;
    }
}
