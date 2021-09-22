package homework_7;

public class Kitten {
    private String name;
    private String breed;
    private String yearOfBirth;

    public Kitten(String name, String breed, String yearOfBirth) {
        this.name = name;
        this.breed = breed;
        this.yearOfBirth = yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    @Override
    public String toString() {
        return "Kitten: " + name + ", " + breed + ", was born in " + yearOfBirth;
    }
}
