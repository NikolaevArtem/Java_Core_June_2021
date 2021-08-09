package homework_3;


/*
The class must be declared as final
Data members in the class must be declared as private
Data members in the class must be declared as final
A parameterized constructor should initialize all the fields performing a deep copy
Deep Copy of objects should be performed in the getter methods
No setters
 */


import java.util.Objects;

public final class ImmutableClass {

    private final int age;

    private final int high;

    private final int weight;

    private final String name;

    public ImmutableClass(int age, int high, int weight, String name) {
        this.age = age;
        this.high = high;
        this.weight = weight;
        this.name = name;
    }

    public ImmutableClass(int weight, int high) {
        this.high = high;
        this.weight = weight;
        this.age = 10;
        this.name = "Some person";
    }

    public int getAge() {
        return age;
    }

    public int getHigh() {
        return high;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public ImmutableClass changeWeightAndHigh(int weight, int high) {
        return new ImmutableClass(weight, high);
    }

    public ImmutableClass changeName(String name) {
        return new ImmutableClass(this.age, this.high, this.weight, name);
    }

    public ImmutableClass changeAge(int age) {
        return new ImmutableClass(age, this.high, this.weight, this.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ImmutableClass)) return false;
        ImmutableClass that = (ImmutableClass) o;
        return age == that.age && high == that.high && weight == that.weight && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, high, weight, name);
    }
}
