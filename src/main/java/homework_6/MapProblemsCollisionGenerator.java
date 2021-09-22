package homework_6;


public class MapProblemsCollisionGenerator {

    private final int id;
    private final String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapProblemsCollisionGenerator that = (MapProblemsCollisionGenerator) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return 1;
    }


    public String getName() {
        return name;
    }

    public MapProblemsCollisionGenerator(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
