package homework_7.kitten_to_cat_function;

public class Cat {

    private int age;
    private String name;
    private String favoriteSleepingPlace;
    private Kitten[] children;

    public Cat(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Cat: name %s age %d", name, age);
    }
}
