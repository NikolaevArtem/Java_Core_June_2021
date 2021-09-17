package course_project.SeaBattle.Utility;

public enum ShipType {
    BOAT(1),
    DESTROYER(2),
    CRUISER(3),
    BATTLESHIP(4);

    public final Integer size;

    private ShipType(int size) {
        this.size = size;
    }

    public Integer getSize() {
        return size;
    }
}
