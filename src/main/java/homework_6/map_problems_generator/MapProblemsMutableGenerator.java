package homework_6.map_problems_generator;

import java.util.Random;

public class MapProblemsMutableGenerator {

    private String name;
    private int age;

    MapProblemsMutableGenerator(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int hashCode() {
        Random random = new Random();
        return random.nextInt();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if ((object == null) || (object.getClass() != this.getClass()))
            return false;

        MapProblemsMutableGenerator mutableGenerator = (MapProblemsMutableGenerator) object;

        return name.equals(mutableGenerator.name) && age == mutableGenerator.age;
    }

    @Override
    public String toString() {
        return "MapProblemsCollisionGenerator{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
