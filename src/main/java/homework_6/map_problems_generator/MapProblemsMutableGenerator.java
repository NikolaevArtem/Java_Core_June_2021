package homework_6.map_problems_generator;

import java.util.Objects;
import java.util.Random;

public class MapProblemsMutableGenerator {

    private int a;

    public MapProblemsMutableGenerator(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return String.valueOf(a);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapProblemsMutableGenerator that = (MapProblemsMutableGenerator) o;
        return a == that.a;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a);
    }
}
