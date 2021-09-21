package homework_6.map_problems_generator;

public class MapProblemsCollisionGenerator {

    private String name;
    private int age;

    MapProblemsCollisionGenerator(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int hashCode() {
        return age;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if ((object == null) || (object.getClass() != this.getClass()))
            return false;

        MapProblemsCollisionGenerator collisionGenerator = (MapProblemsCollisionGenerator) object;

        return name.equals(collisionGenerator.name) && age == collisionGenerator.age;
    }

    @Override
    public String toString() {
        return "MapProblemsCollisionGenerator{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
