package homework_7.kitten_to_cat_function;

import java.awt.*;

public class Cat {
    private int age;
    private String name;
    private Color color;

    public Cat(int age, String name, Color color) {
        if (age <= 3)
            System.out.println("It's a kitten, isn't a cat");
        else
            this.age = age;
        this.name = name;
        this.color = color;
    }

    public Cat(int age, String name) {
        if (age <= 3)
            System.out.println("It's a kitten, isn't a cat");
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
        return "Cat{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", color=" + color +
                '}';
    }
}
