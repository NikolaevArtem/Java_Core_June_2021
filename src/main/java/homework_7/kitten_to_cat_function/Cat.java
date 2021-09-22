package homework_7.kitten_to_cat_function;

public class Cat {
    private String name;
    private Integer age;
    private String favoriteMeal;

    public Cat(String name, Integer age) {
        this.name = name;
        this.age = age;
        this.favoriteMeal = "Fish";
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
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", favoriteMeal='" + favoriteMeal + '\'' +
                '}';
    }
}
