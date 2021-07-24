package homework_3;

/*
Immutable class
    The class must be declared as final (So that child classes can’t be created)
    Data members in the class must be declared as private (So that direct access is not allowed)
    Data members in the class must be declared as final (So that we can’t change the value of it after object creation)
    A parameterized constructor should initialize all the fields performing a deep copy (So that data members can’t be modified with object reference)
    Deep Copy of objects should be performed in the getter methods (To return a copy rather than returning the actual object reference)
    No setters (To not have the option to change the value of the instance variable)
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
