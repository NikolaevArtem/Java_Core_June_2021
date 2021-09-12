package course_project;

public enum ShipKind {
    ONE_DECK_SHIP(4, "One deck ship", 1),
    TWO_DECK_SHIP(3, "Two deck ship", 2),
    THREE_DECK_SHIP(2, "Three deck ship", 3),
    FOUR_DECK_SHIP(1, "Four deck ship", 4);

    private final int count;
    private final String type;
    private final int length;

    ShipKind(int count, String title, int length) {
        this.count = count;
        this.type = title;
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public int getCount() {
        return count;
    }

    public String getType() {
        return type;
    }
}
