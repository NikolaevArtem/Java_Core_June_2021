package homework_7.kitten_to_cat_function;

import java.awt.*;

public class Kitten {
    private int age;
    private String name;
    private Color color;

    public Kitten(int age, String name, Color color) {
        if (age > 3)
            System.out.println("It's a cat, isn't a kitten");
        else
            this.age = age;
        this.name = name;
        this.color = color;
    }

    public Kitten(int age, String name) {
        if (age > 3)
            System.out.println("It's a cat, isn't a kitten");
        else
            this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Kitten{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", color=" + color +
                '}';
    }
}
