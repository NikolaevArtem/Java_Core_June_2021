package homework_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
The class must be declared as final
Data members in the class must be declared as private
Data members in the class must be declared as final
A parameterized constructor should initialize all the fields performing a deep copy
Deep Copy of objects should be performed in the getter methods
No setters
 */
public final class ImmutableClass {
    private final String aString;
    private final int anInt;
    private final List<String> aList;

    public ImmutableClass(List<String> aList) {
        this("default", 0, new ArrayList<>(aList));
    }

    public ImmutableClass(String aString, int anInt, List<String> aList) {
        List<String> tempList = new ArrayList<>(aList);
        this.aString = aString;
        this.anInt = anInt;
        this.aList = tempList;
    }

    public String getString() {
        return aString;
    }

    public int getAnInt() {
        return anInt;
    }

    public List<String> getaList() {
        return Collections.unmodifiableList(aList);
    }

    public ImmutableClass getNew(List<String> aList) {
        return new ImmutableClass(aList);
    }
}
