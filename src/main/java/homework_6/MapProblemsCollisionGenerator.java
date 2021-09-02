package homework_6;

public class MapProblemsCollisionGenerator {

    private final String generatorName;

    public MapProblemsCollisionGenerator(String generatorName) {
        this.generatorName = generatorName;
    }

    @Override
    public int hashCode() {
        return 1234;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() == this.getClass()) {
            return false;
        }
        return this.generatorName.equals(((MapProblemsCollisionGenerator) obj).generatorName);
    }

    @Override
    public String toString() {
        return generatorName;
    }
}
