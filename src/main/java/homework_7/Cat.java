package homework_7;

public class Cat {

    private final String name;
    private final double weight;
    private final int whiskersLength;

    public Cat(String name, double weight, int whiskersLength) {
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

    public int getWhiskersLength() {
        return whiskersLength;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", whiskers length=" + whiskersLength +
                '}';
    }
}
