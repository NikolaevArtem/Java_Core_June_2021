package homework_7.entity;

import homework_7.KittenToCatFunction;

public class Kitten {
    private final String name;
    private final int age;
    private final int weight;

    public Kitten(String name, int age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public Cat grow(KittenToCatFunction<Kitten, Cat> function) {
        return function.grow(this);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Kitten{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }
}
