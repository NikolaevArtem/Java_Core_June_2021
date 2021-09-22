package homework_6;

import java.util.Objects;

public class MapProblemsMutableGenerator {

    private int id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapProblemsMutableGenerator that = (MapProblemsMutableGenerator) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }



    public MapProblemsMutableGenerator(int id) {
        this.id = id;
    }
}
