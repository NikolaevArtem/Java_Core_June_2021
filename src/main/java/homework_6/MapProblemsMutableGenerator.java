package homework_6;

public class MapProblemsMutableGenerator {

    private int generatorID;

    public MapProblemsMutableGenerator(int generatorID) {
        this.generatorID = generatorID;
    }

    public void setGeneratorID(int generatorID) {
        this.generatorID = generatorID;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(generatorID);
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
        return this.generatorID == ((MapProblemsMutableGenerator) obj).generatorID;
    }

}
