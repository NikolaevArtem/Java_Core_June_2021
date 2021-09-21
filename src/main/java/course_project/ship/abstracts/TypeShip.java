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

    public static TypeShip getType(int n) {
        switch (n) {
            case 1: return TypeShip.SINGLE_DECK;
            case 2: return TypeShip.DOUBLE_DECK;
            case 3: return TypeShip.THREE_DECK;
            case 4: return TypeShip.FOUR_DECK;
        }
        return null;
    }

    public int getCount() {
        return count;
    }
}
