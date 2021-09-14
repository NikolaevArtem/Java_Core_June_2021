package homework_7;

public class Kitten {
    private String name;
    private int age;
    private double tail_length;

    public Kitten(String name, int age, double tail_length) {
        this.name = name;
        this.age = age;
        this.tail_length = tail_length;
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

    @Override
    public String toString() {
        return "Kitten{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", tail_length=" + tail_length +
                '}';
    }

    public Cat changeKittenToCat(KittenToCat<Cat, Kitten> kittenToCat) {
        return kittenToCat.trasfom(this);
    }
}
