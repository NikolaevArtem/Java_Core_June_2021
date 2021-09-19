package homework_7;

public class Kitten {
    private final String breed;
    private final int age;
    private final int colour;
    private final String favoriteMeal;

    public Kitten(String breed, int age, int colour, String favoriteMeal) {
        this.breed = breed;
        this.age = age;
        this.colour = colour;
        this.favoriteMeal = favoriteMeal;
    }

    public String getBreed() {
        return breed;
    }

    public int getAge() {
        return age;
    }

    public int getColour() {
        return colour;
    }

    public String getFavoriteMeal() {
        return favoriteMeal;
    }

    @Override
    public String toString() {
        return "Kitten{" +
                "breed='" + breed + '\'' +
                ", age=" + age +
                ", colour=" + colour +
                ", favoriteMeal='" + favoriteMeal + '\'' +
                '}';
    }
}
