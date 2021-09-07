package homework_6.map_problems_generator;

import java.util.Objects;

public class MapProblemsMutableGenerator {
    private int key;
    private String value;

    public MapProblemsMutableGenerator(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null ||getClass() != o.getClass()) return false;
        MapProblemsMutableGenerator another = (MapProblemsMutableGenerator) o;
        return key == another.key && Objects.equals(value, another.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, key);
    }
}
