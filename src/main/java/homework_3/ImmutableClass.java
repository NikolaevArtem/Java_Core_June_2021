package homework_3;
/*
           Rules for Creating an Immutable Class in Java
1. The class must be declared as final (So that child classes can’t be created).
2. Don't provide "setter" methods — methods that modify fields or objects referred to by fields.
3. Make all fields final and private.
4. Don't allow subclasses to override methods. The simplest way to do this is to declare the class as final.
5. If the instance fields include references to mutable objects, don't allow those objects to be changed:
    * Don't provide methods that modify the mutable objects.
    * Don't share references to the mutable objects. Never store references to external, mutable objects passed to the constructor,
        !if necessary, create copies, and store references to the copies.
        !Similarly, create copies of your internal mutable objects when necessary to avoid returning the originals in your methods.
6. A parameterized constructor should initialize all the fields performing a deep copy (So that data members can’t be modified with object reference).
 */

public final class ImmutableClass {
    private final int integer;
    private final String string;
    private final Integer integer1;

    public ImmutableClass(int integer, String string, Integer integer1) {
        this.integer = integer;
        this.string = string;
        this.integer1 = new Integer(integer1);
    }

    public ImmutableClass(int integer, String string) {
        this.integer = integer;
        this.string = string;
        this.integer1 = new Integer(null);
    }

    public ImmutableClass(int integer) {
        this.integer = integer;
        this.string = "";
        this.integer1 = new Integer(null);
    }

    public ImmutableClass() {
        this.integer = 6;
        this.string = "field";
        this.integer1 = new Integer(5);
    }


    public int getInteger() {
        return integer;
    }

    public String getString() {
        return string;
    }

    public Integer getInteger1() {
        return integer1;
    }

    public ImmutableClass returnModifyObject() {
        ImmutableClass immutableClass = new ImmutableClass(6, "field", 5);
        return immutableClass;
    }
}
