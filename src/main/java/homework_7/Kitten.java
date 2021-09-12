package homework_7;

public class Kitten {

    private final String name;
    private final double weight;
    private final int whiskersLength;

    public Kitten(String name, double weight, int whiskersLength) {
        this.name = name;
        this.weight = weight;
        this.whiskersLength = whiskersLength;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Kitten{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", whiskersLength=" + whiskersLength +
                '}';
    }
}
