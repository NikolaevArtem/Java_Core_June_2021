package homework_6.map_problems_collision_generator;

public class MapProblemsCollisionGenerator {

    private final String val;

    public MapProblemsCollisionGenerator() {
        this.val = "кладем?";
    }

    public MapProblemsCollisionGenerator(String s) {
        this.val = s;
    }

    public String getVal() {
        return val;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        MapProblemsCollisionGenerator that = (MapProblemsCollisionGenerator) obj;
        return this.getVal().equals(that.getVal());
    }

}
