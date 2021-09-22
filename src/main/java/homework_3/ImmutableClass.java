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

import java.util.LinkedList;
import java.util.List;

public final class ImmutableClass {

    private final List<Number> allDataList; // mutable type
    private final int age; // primitive type
    private final double weight; // primitive type

    public ImmutableClass() {
        this.age = 0;
        this.weight = 0.0;
        this.allDataList = new LinkedList<>();
        initAllDataList();
    }

    public ImmutableClass(int age, double weight) {
        this.age = age;
        this.weight = weight;
        this.allDataList = new LinkedList<>();
        initAllDataList();
    }

    public ImmutableClass(List<Number> allData, int age, double weight) {
        this.age = age;
        this.weight = weight;
        this.allDataList = new LinkedList<>(allData);
        initAllDataList();
    }

    private void initAllDataList() {
        this.allDataList.add(age);
        this.allDataList.add(weight);
    }

    public List<Number> getAllDataList() {
        return new LinkedList<>(this.allDataList);
    }

    public ImmutableClass getNewObjectWithChanges(List<Number> changes) {
        List<Number> list = getAllDataList();
        list.addAll(changes);
        return new ImmutableClass(list, this.age, this.weight);
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

}
