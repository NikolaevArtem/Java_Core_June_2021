package homework_7.kitten_to_cat_function;

public class Kitten {

    private int age;
    private String name;
    private String favoriteToy;
    private Cat mother;
    private Cat father;

    public Kitten(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("Kitten: name %s age %d", name, age);
    }
}
