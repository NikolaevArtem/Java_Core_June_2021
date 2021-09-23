package homework_6;

import java.util.Objects;

public class MapProblemsCollisionGenerator {

    private final String name;
    private final int id;
    public MapProblemsCollisionGenerator(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("Calling equals() for key: " + o);
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        MapProblemsCollisionGenerator that = (MapProblemsCollisionGenerator) o;
        return id == that.id && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public String toString() {
        return "MapProblemsMutableGenerator{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
