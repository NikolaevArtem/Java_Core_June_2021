package homework_6.map_problem_generator;

public class MapProblemsMutableGenerator {

    private  int weight;

    public MapProblemsMutableGenerator(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int hashCode() {
        return (int)(Math.random() * 50 + 1);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MapProblemsMutableGenerator newObj = (MapProblemsMutableGenerator) obj;
        return weight == newObj.weight;
    }
}
