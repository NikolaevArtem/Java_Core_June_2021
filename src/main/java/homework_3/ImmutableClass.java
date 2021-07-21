package homework_3;

import java.util.LinkedList;
import java.util.List;

public class ImmutableClass {
    /*
    no setters methods
    make variables private and final
    make class final
    A parameterized constructor should initialize all the fields performing a deep copy
    Deep Copy of objects should be performed in the getter methods
    */
    private final int someInt;
    private final double someDouble;
    private final String someString;
    private final List<String> list;

    public ImmutableClass(int someInt, double someDouble, String someString, List<String> list) {
        this.someInt = someInt;
        this.someDouble = someDouble;
        this.someString = someString;
        this.list = list;
    }

    public ImmutableClass(List<String> list) {
        this.list = new LinkedList<>(list);
        this.someDouble = 0.0;
        this.someInt = 0;
        this.someString = "default";
    }

    public int getSomeInt() {
        return someInt;
    }

    public double getSomeDouble() {
        return someDouble;
    }

    public String getSomeString() {
        return someString;
    }

    public List<String> getList() {
        return new LinkedList<>(list);
    }

    public ImmutableClass getNew(List<String> list) {
        return new ImmutableClass(someInt, someDouble, someString, list);
    }

}
