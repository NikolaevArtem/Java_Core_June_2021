package homework_3;

import java.util.ArrayList;
import java.util.List;
/*
no setters methods
make variables private and final
make class final
A parameterized constructor should initialize all the fields performing a deep copy
Deep Copy of objects should be performed in the getter methods
*/public final class ImmutableClass {

    private final int someInt;
    private final String someString;
    private final Character someChar;
    private final String[] names;

    public ImmutableClass(int someInt, String someString, Character someChar, String[] names) {
        this.someInt = someInt;
        this.someString = someString;
        this.someChar = someChar;
        this.names = names;
    }

    public int getSomeInt() {
        return someInt;
    }

    public String getSomeString() {
        return someString;
    }

    public Character getSomeChar() {
        return someChar;
    }

    public String[] getNames() {
        return names.clone();
    }

    public ImmutableClass getImmutableClass(int someInt) {
        return new ImmutableClass(getSomeInt(),getSomeString(),getSomeChar(), getNames());
    }

    public ImmutableClass getImmutableClass(Character cshar) {
        if (someChar != null) {
            return new ImmutableClass(getSomeInt(),getSomeString(), cshar, getNames());
        } else return new ImmutableClass(getSomeInt(),getSomeString(),getSomeChar(), getNames());
    }

    public ImmutableClass getImmutableClass(String[] str) {
        if (str != null) {
            return new ImmutableClass(getSomeInt(),getSomeString(),getSomeChar(), str);
        } else return new ImmutableClass(getSomeInt(),getSomeString(),getSomeChar(), getNames());
    }
}