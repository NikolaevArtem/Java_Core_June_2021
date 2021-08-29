package homework_6.mapProblemsGenerator;

import lombok.Data;

/**
 * Class Cat with incorrect hashCode() method that creates collisions every time.
 */

@Data
public final class Cat {
    final int age;

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return age == cat.age;
    }

}
