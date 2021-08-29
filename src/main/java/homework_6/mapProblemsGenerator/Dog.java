package homework_6.mapProblemsGenerator;

import lombok.Data;

import java.util.Objects;

/**
 * Class Dog with mutable field age.
 */

@Data
public final class Dog {
    int age;

    public Dog(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return age == dog.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age);
    }

}
