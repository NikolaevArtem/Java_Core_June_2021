package course_project;

public enum ShipKind {
    ONE_DECK_SHIP(4),
    TWO_DECK_SHIP(3),
    THREE_DECK_SHIP(2),
    FOUR_DECK_SHIP(1);

    private final int count;

    ShipKind(int count) {
         this.count = count;
    }

    public int getCount() {
        return count;
    }
}
