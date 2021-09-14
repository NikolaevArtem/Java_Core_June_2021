package homework_7;

public class Cat {
    private String name;
    private int age;
    private double tail_length;

    public Cat(String name, int age, double tail_length) {
        this.name = name;
        this.age = age;
        this.tail_length = tail_length;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", tail_length=" + tail_length +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getTail_length() {
        return tail_length;
    }
}
