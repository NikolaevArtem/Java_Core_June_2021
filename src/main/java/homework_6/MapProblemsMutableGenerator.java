package homework_6;

import java.util.Objects;

public class MapProblemsMutableGenerator extends MapProblemsCollisionGenerator{
    private int someNumber;

    public MapProblemsMutableGenerator(int someNumber) {
        this.someNumber = someNumber;
    }

    public int getSomeNumber() {
        return someNumber;
    }

    public void setSomeNumber(int someNumber) {
        this.someNumber = someNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MapProblemsMutableGenerator)) return false;
        MapProblemsMutableGenerator that = (MapProblemsMutableGenerator) o;
        return getSomeNumber() == that.getSomeNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSomeNumber());
    }

    @Override
    public String toString() {
        return "MapProblemsMutableGenerator{" +
                "someNumber=" + someNumber +
                '}';
    }
}
