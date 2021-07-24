package homework_3;

/*
Immutable class
3 constuctors: (), (String, int, double), ("")
3 getMethods(): getName, getAge, getWeight
1 method returning a new obj: newObjectMethod()
 */
public final class ImmutableClass {

    private final String name; // reference type
    private final int age; // primitive type
    private final double weight; // primitive type

    public ImmutableClass() {
        this.name = "Unknown";
        this.age = 0;
        this.weight = 0.0;
    }

    public ImmutableClass(String str, int age, double weight) {
        this.name = str;
        this.age = age;
        this.weight = weight;
    }

    public ImmutableClass(String str) {
        this(str, 1, 1.0);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public final Object newObjectMethod() {
        return new ImmutableClass(name, age, weight);
    }

}
