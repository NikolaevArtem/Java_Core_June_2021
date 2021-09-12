package homework_7;

public class Cat {
    private final String name;
    private final double age;
    private final String color;
    private final double tailLength;
    private final SEX sex;

    public Cat(String name,SEX sex, double age, String color, double tailLength) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.tailLength = tailLength;
        this.sex = sex;
    }

    public enum SEX {
        FEMALE,
        MALE
    }

    @Override
    public String toString() {
        return "Cat " +
                "name = '" + name + '\'' +
                ", sex = " + sex +
                ", age = " + String.format("%.2f",age) +
                ", color = '" + color + '\'' +
                ", tailLength = " + tailLength +
                '\t';
    }
}
