package homework_6.map_problems_generator;

public class GenerateCollisions implements MapKeyable {

    private final String val;

    public GenerateCollisions(String s) {
        this.val = s;
    }

    public String getVal() {
        return val;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        GenerateCollisions that = (GenerateCollisions) obj;
        return this.getVal().equals(that.getVal());
    }


}
