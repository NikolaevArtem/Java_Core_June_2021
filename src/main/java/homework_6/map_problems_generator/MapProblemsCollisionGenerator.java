package homework_6.map_problems_generator;

public class MapProblemsCollisionGenerator {
    private int key;
    private String value;

    public MapProblemsCollisionGenerator(int key, String value) {
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
        return true;
    }

    @Override
    public int hashCode() {
        return key;
    }
}
