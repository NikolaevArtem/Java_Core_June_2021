package homework_7.kitten_to_cat_function;

public class Cat {
    private final String name;
    private final int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Cat's name: " + this.getName() +
                ", Cat's age: " + this.getAge();
    }
}