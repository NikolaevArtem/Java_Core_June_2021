package course_project.model;

public enum Designation {
    SHIP("◾", 0),
    FOUR_DECKER("", 4),
    THREE_DECKER("", 3),
    TWO_DECKER("", 2),
    ONE_DECKER("", 1),
    HIT("x", 0),
    EMPTY("~", 0),
    MISS("*", 0),
    GAP("o", 0);

    private String sign;
    private int length;

    Designation(String sign, int length) {
        this.sign = sign;
        this.length = length;
    }

    @Override
    public String toString() {
        return sign;
    }

    public int getLength() {
        return length;
    }
}
