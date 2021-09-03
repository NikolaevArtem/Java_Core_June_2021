package homework_6;

import java.util.Objects;

public class MapProblemsCollisionGenerator {

    private String name;
    private boolean flag;
    private int age;

    public MapProblemsCollisionGenerator(String name, boolean flag, int age) {
        this.name = name;
        this.flag = flag;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapProblemsCollisionGenerator that = (MapProblemsCollisionGenerator) o;
        return flag == that.flag && age == that.age && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return 31;
    }

}
