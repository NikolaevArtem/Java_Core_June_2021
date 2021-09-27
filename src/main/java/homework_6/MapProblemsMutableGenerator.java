package homework_6;

import java.util.Objects;

public class MapProblemsMutableGenerator {
    private StringBuilder mapKey;

    public MapProblemsMutableGenerator(StringBuilder mapKey) {
        this.mapKey = mapKey;
    }

    public StringBuilder getMapKey() {
        return mapKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapProblemsMutableGenerator that = (MapProblemsMutableGenerator) o;
        return mapKey.equals(that.mapKey);                            //suspicious it is, indeed
    }

    @Override
    public int hashCode() {
        return mapKey.toString().hashCode();
    }
}
