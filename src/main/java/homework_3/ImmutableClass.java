package homework_3;

import java.util.ArrayList;
import java.util.List;

/*
The class must be declared as final.
Data members in the class must be declared as private & final.
A parameterized constructor should initialize all the fields.
Deep Copy of objects should be performed in the getter methods.
No setters.
 */

final class ImmutableClass {

    private final int firstInt;

    private final String firstString;

    private final int[] firstIntArray;

    private final String[] firstStringArray;

    private final List<Integer> firstCollection;


    ImmutableClass(int firstInt, String firstString, int[] firstIntArray, String[] firstStringArray, List<Integer> firstCollection) {
        this.firstInt = firstInt;
        this.firstString = firstString;
        this.firstIntArray = firstIntArray;
        this.firstStringArray = firstStringArray;
        this.firstCollection = firstCollection;
    }

    public ImmutableClass() {
        this.firstInt = 1;
        this.firstString = "Default";
        this.firstIntArray = new int[1];
        this.firstStringArray = new String[1];
        this.firstCollection = new ArrayList<>();
    }

    public ImmutableClass(int firstInt, String firstString) {
        this.firstInt = firstInt;
        this.firstString = firstString;
        this.firstIntArray = new int[1];
        this.firstStringArray = new String[1];
        this.firstCollection = new ArrayList<>();
    }

    public int getFirstInt() {
        return firstInt;
    }

    public String getFirstString() {
        return firstString;
    }

    public int[] getFirstIntArray() {
        return firstIntArray;
    }

    public String[] getFirstStringArray() {
        return firstStringArray;
    }

    public List<Integer> getFirstCollection() {
        return firstCollection;
    }

    public ImmutableClass getNewImmutableClass(int x, String y, int[] xy, String[] yx, List<Integer> list) {
        return new ImmutableClass(x,y,xy,yx,list);
    }
}
