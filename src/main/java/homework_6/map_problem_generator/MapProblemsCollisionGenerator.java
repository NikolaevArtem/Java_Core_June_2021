package homework_6.map_problem_generator;

import java.util.Objects;

class MapProblemsCollisionGenerator {

    private final int age;

    MapProblemsCollisionGenerator(int age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(0);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MapProblemsCollisionGenerator newObj = (MapProblemsCollisionGenerator) obj;
        return age == newObj.age;
    }

}
