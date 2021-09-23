package homework_4.custom_annotation;

@CustomAnnotation(name = "Barsik", weight = 3.09)
public class Cat {
    private final String name;
    private final double weight;
    private final double tailLength;

    public Cat() {
        CustomAnnotation annotation = Cat.class.getAnnotation(CustomAnnotation.class);
        name = annotation.name();
        weight = annotation.weight();
        tailLength = 0.5;
    }

    public Cat(String name, double weight) {
        this.name = name;
        this.weight = weight;
        tailLength = 0.5;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }
}
