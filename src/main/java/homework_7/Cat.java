package homework_7;

import java.awt.*;

public class Cat {
    String name;
    int age;
    Color color;
    String grownsOnlyCollar;

    public Cat(String name, int age, Color color, String grownsOnlyCollar) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.grownsOnlyCollar = grownsOnlyCollar;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color=" + color +
                ", grownsOnlyCollar='" + grownsOnlyCollar + '\'' +
                '}';
    }
}



