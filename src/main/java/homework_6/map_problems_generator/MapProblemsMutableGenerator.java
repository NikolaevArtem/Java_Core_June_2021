package homework_6.map_problems_generator;

import java.util.Objects;

public class MapProblemsMutableGenerator {

    private String someInt;

    public MapProblemsMutableGenerator(String someInt) {
        this.someInt = someInt;
    }

    public void setSomeString(String someInt) {
        this.someInt = someInt;
    }

    @Override
    public String toString() {
        return String.valueOf(someInt);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapProblemsMutableGenerator that = (MapProblemsMutableGenerator) o;
        return someInt == that.someInt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(someInt);
    }
}
