package homework_3;
/*
* Immutable class Cat
*
* Requirements for class to be immutable:
*
* The class must be declared as final (So that child classes can’t be created)
* Data members in the class must be declared as private (So that direct access is not allowed)
* Data members in the class must be declared as final (So that we can’t change the value of it after object creation)
* A parameterized constructor should initialize all the fields performing a deep copy (So that data members can’t be modified with object reference)
* Deep Copy of objects should be performed in the getter methods (To return a copy rather than returning the actual object reference)
* No setters (To not have the option to change the value of the instance variable)
*
* */

import java.util.HashMap;
import java.util.Map;

public final class ImmutableCat {
    private final String name;
    private final int passportCode;
    private final Map<Integer, String> toyStorage;

    public ImmutableCat(String name, int passportCode, Map<Integer, String> toyStorage) {
        this.name = name;
        this.passportCode = passportCode;
        this.toyStorage = new HashMap<>(toyStorage);
    }

    public ImmutableCat(String name, int passportCode) {
        this.name = name;
        this.passportCode = passportCode;
        this.toyStorage = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public int getPassportCode() {
        return passportCode;
    }

    public Map<Integer, String> getToyStorage() {
        return new HashMap<>(toyStorage);
    }

    public ImmutableCat getModifiedCat(ImmutableCat oldImmutableCat, String name) {
        return new ImmutableCat(name, oldImmutableCat.getPassportCode(), oldImmutableCat.getToyStorage());
    }

    public ImmutableCat getModifiedBrokeCat(ImmutableCat oldImmutableCat) {
        return new ImmutableCat(oldImmutableCat.getName(), oldImmutableCat.getPassportCode());
    }
}
