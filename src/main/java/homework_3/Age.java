package homework_3;

public class Age {
    private final int day;
    private final int month;
    private final int year;

    public Age(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Age(Age age) {
        this(age.day, age.month, age.year);
    }

    @Override
    public String toString() {
        return day + "." + month + "." + year;
    }
}
