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
        this(age.getDay(), age.getMonth(), age.getYear());
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
}
