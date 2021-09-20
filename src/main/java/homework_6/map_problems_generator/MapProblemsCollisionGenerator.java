package homework_6.map_problems_generator;

public class MapProblemsCollisionGenerator {

    private int id;
    private int countCallEquals;

    public MapProblemsCollisionGenerator(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCountCallEquals() {
        return countCallEquals;
    }

    @Override
    public boolean equals(Object o) {
        countCallEquals++;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapProblemsCollisionGenerator that = (MapProblemsCollisionGenerator) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return 1 << 4;
    }
}
