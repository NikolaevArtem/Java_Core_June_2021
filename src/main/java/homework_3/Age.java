package homework_3;

public class Age {
    private int day;
    private int month;
    private int year;

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

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
