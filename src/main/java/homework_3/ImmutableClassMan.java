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

public final class ImmutableClassMan {

    private final int age;
    private final String name;
    private final Integer iq;

    public ImmutableClassMan(int age, String name, Integer iq) {
        this.age = age;
        this.name = name;
        this.iq = new Integer(iq);
    }

    public ImmutableClassMan(int age, String name) {
        this.age = age;
        this.name = name;
        this.iq = new Integer(null);
    }

    public ImmutableClassMan(int age) {
        this.age = age;
        this.name = "";
        this.iq = null;
    }

    public ImmutableClassMan() {
        this.age = 6;
        this.name = "Ivan";
        this.iq = new Integer(128);
    }


    public int getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }

    public Integer getIq() {
        return this.iq;
    }

    public ImmutableClassMan returnModifyMan(Integer iq) {
        return new ImmutableClassMan(age, name, iq);
    }
}
