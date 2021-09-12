package homework_7.kitten_to_cat_function;

import java.util.stream.Stream;

public class Cat {

    private int age;
    private String name;
    private String favoriteSleepingPlace;
    private Kitten[] children;

    public Cat(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public String getFavoriteSleepingPlace() {
        return favoriteSleepingPlace;
    }

    public void setFavoriteSleepingPlace(String favoriteSleepingPlace) {
        this.favoriteSleepingPlace = favoriteSleepingPlace;
    }

    public Kitten[] getChildren() {
        return children;
    }

    public void setChildren(Kitten[] children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return String.format("Cat: name %s age %d", name, age);
    }
}
