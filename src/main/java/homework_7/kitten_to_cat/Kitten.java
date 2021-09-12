package homework_7.kitten_to_cat;

import java.security.SecureRandom;
import java.util.Random;

public class Kitten {

    private final int age;
    private final String name;
    private final String breed;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public Kitten(String name, int age, String breed) {
        this.name = name;
        this.age = age;
        this.breed = breed;
    }

    public Cat grow(CatToKittenFunction<Kitten, Cat> function) {
        return function.grow(this);
    }

    private boolean isNameValid() {
        return this.name.length() > 2;
    }

    @Override
    public int hashCode() {
        if (isNameValid()) {
            return (this.age + this.name.charAt(0)) * 2 << 5;
        } else {
            try {
                Random r = SecureRandom.getInstanceStrong();
                return r.nextInt();
            } catch (Exception e) {
                throw new NumberFormatException("ERROR: SecureRandom @hashCode works incorrect for " + this.getClass());
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != this.getClass()) return false;
        if (this == o) return true;
        Kitten that = (Kitten) o;
        return this.age == that.age && this.name.equals(that.name);
    }

    @Override
    public String toString() {
        return "Kitten's name: " + this.getName() +
                "\nKitten's age: " + this.getAge() +
                "\nKitten's breed: " + this.getBreed();
    }

}
