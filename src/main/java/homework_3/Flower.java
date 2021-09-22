package homework_3;

import java.util.ArrayList;
import java.util.List;
/*
no setters methods
make variables private and final
make class final
A parameterized constructor should initialize all the fields performing a deep copy
Deep Copy of objects should be performed in the getter methods
*/public final class Flower {
    private final String name;
    private final List<Integer> counts;
    public Flower(String name, List<Integer> counts) {
        this.name = name;
        this.counts = new ArrayList<>(counts);
    }
    public final String getName() {
        return name;
    }
    public final List<Integer> getCounts() {
        return new ArrayList<>(counts);
    }
}