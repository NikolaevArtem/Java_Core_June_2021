package homework_6;

import java.util.Objects;

public class MapProblemsMutableGenerator {

    private StringBuilder name;

    public MapProblemsMutableGenerator(String name) {
        this.name = new StringBuilder(name);
    }

    public StringBuilder getName() {
        return name;
    }

    public void setName(String name) {
        this.name = new StringBuilder(name);
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        MapProblemsMutableGenerator that = (MapProblemsMutableGenerator) o;
        return name.toString().equals(that.name.toString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "MapProblemsMutableGenerator{" +
                "stringBuilder=" + name +
                '}';
    }
}
