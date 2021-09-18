package homework_7.util;

public class Kitten {

    private int age;
    private final String mood;
    private final String color;

    public Kitten(int age, String mood, String color) {
        this.age = age;
        this.mood = mood;
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public String getMood() {
        return mood;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Kitten{" +
                "age=" + age +
                ", mood='" + mood + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
