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

    public Cat transform(KittenToCatFunction function) {
        return function.grow(this);
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavoriteToy() {
        return favoriteToy;
    }

    public void setFavoriteToy(String favoriteToy) {
        this.favoriteToy = favoriteToy;
    }

    public Cat getMother() {
        return mother;
    }

    public void setMother(Cat mother) {
        this.mother = mother;
    }

    public Cat getFather() {
        return father;
    }

    public void setFather(Cat father) {
        this.father = father;
    }

    @Override
    public String toString() {
        return String.format("Kitten: name %s age %d", name, age);
    }
}
