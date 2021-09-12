package homework_7.kitten_to_cat;

import java.security.SecureRandom;
import java.util.Random;

public class Cat {

    private final int age;
    private final String name;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
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
        Cat that = (Cat) o;
        return this.getAge() == that.getAge() && this.getName().equals(that.getName());
    }

    @Override
    public String toString() {
        return "Cat's name: " + this.getName() +
                "\nCat's age: " + this.getAge();
    }

}
