package course_project.ship.abstracts;

public enum ShipType {

    SINGLE_DECK ("SingleDeckShip", 4),
    DOUBLE_DECK ("DoubleDeckShip", 3),
    THREE_DECK ("ThreeDeckShip", 2),
    FOUR_DECK ("FourDeckShip", 1);

    private String type;
    private int count;

    ShipType(String type, int count) {
        this.type = type;
        this.count = count;
    }

    public String getType() {
        return type;
    }

    public static ShipType getType(int n) {
        switch (n) {
            case 1: return ShipType.SINGLE_DECK;
            case 2: return ShipType.DOUBLE_DECK;
            case 3: return ShipType.THREE_DECK;
            case 4: return ShipType.FOUR_DECK;
        }
        return null;
    }

    public int getCount() {
        return count;
    }
}
