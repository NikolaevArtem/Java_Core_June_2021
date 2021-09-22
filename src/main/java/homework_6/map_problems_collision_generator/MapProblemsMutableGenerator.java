package homework_6.map_problems_collision_generator;

import java.util.Objects;

public class MapProblemsMutableGenerator {

    private String val;

    public MapProblemsMutableGenerator() {
        setVal("кладем?");
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(val);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapProblemsMutableGenerator that = (MapProblemsMutableGenerator) o;
        return Objects.equals(val, that.val);
    }

}
