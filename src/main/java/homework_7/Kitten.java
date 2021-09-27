package homework_7;

public class Kitten {
    private String name;
    private int age = 0;
    private double tailLength;

    public Kitten(String name, int age, double tailLength) {
        this.name = name;
        this.age = 0;  // kittens are small
        this.tailLength = tailLength;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return 0;
    }

    public double getTailLength() {
        return tailLength;
    }

    @Override
    public String toString() {
        return "Kitten{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", tailLength=" + tailLength +
                '}';
    }
}
