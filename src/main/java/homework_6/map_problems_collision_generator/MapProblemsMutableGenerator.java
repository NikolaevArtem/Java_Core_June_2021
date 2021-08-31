package homework_6.map_problems_collision_generator;

import java.util.Objects;
import java.util.Random;

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
        return new Random().nextInt(Integer.MAX_VALUE - 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapProblemsMutableGenerator that = (MapProblemsMutableGenerator) o;
        return Objects.equals(val, that.val);
    }

}
