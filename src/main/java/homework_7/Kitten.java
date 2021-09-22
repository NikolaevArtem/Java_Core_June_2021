package homework_7;

public class Kitten {
    private final String name;
    private final int months;
    private final String color;
    private final int tailLength;
    private final Cat.SEX sex;


    public Kitten(String name, Cat.SEX sex, int  months, String color, int tailLength) {
        this.name = name;
        this.months = months;
        this.color = color;
        this.tailLength = tailLength;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public double getMonths() {
        return months;
    }

    public String getColor() {
        return color;
    }

    public int getTailLength() {
        return tailLength;
    }

    public Cat.SEX getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "Kitten " +
                "name = '" + name + '\'' +
                ", months = " + months +
                ", color = '" + color + '\'' +
                ", tailLength = " + tailLength +
                '\t';
    }
}
