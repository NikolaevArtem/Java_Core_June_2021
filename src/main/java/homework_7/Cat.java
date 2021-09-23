package homework_7;

public class Cat {

    private final String breed;
    private final int age;
    private final String colour;
    private final int weight;

    public Cat(String breed, int age, String colour, int weight) {
        this.breed = breed;
        this.age = age;
        this.colour = colour;
        this.weight = weight;
    }

    public String getBreed() {
        return breed;
    }

    public int getAge() {
        return age;
    }

    public String getColour() {
        return colour;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "breed='" + breed + '\'' +
                ", age=" + age +
                ", colour=" + colour +
                ", weight=" + weight +
                '}';
    }
}
