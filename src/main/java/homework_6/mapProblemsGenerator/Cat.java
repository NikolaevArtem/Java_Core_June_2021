package homework_6.mapProblemsGenerator;

/**
 * Class Cat with incorrect hashCode() method that creates collisions every time.
 */

public final class Cat {
    private final int age;

    public Cat(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

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
