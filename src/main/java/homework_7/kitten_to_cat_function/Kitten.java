package homework_7.kitten_to_cat_function;

public class Kitten {
    private String name;
    private Integer age;
    private String favoriteMeal;

    public Kitten(String name, Integer age) {
        this.name = name;
        this.age = age;
        this.favoriteMeal = "Milk";
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getFavoriteMeal() {
        return favoriteMeal;
    }

    @Override
    public String toString() {
        return "Kitten{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", favoriteMeal='" + favoriteMeal + '\'' +
                '}';
    }
}
