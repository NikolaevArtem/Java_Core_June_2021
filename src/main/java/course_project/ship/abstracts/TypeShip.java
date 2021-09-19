package course_project.ship.abstracts;

public enum TypeShip {

    SINGLE_DECK ("SingleDeckShip", 4),
    DOUBLE_DECK ("DoubleDeckShip", 3),
    THREE_DECK ("ThreeDeckShip", 2),
    FOUR_DECK ("FourDeckShip", 1);

    private String type;
    private int count;

    TypeShip(String type, int count) {
        this.type = type;
        this.count = count;
    }

    public String getType() {
        return type;
    }

    public int getCount() {
        return count;
    }
}
