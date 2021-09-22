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

import java.util.ArrayList;
import java.util.List;

public final class ImmutableClassMan {

    private final int age;
    private final String name;
    private final ArrayList<String> job;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public List<String> getJob() {
        if (job != null){
            return new ArrayList<>(job);
        }
        return new ArrayList<>();
    }

    public ImmutableClassMan(int age, String name, List<String> job) {
        this.age = age;
        this.name = name;
        this.job = new ArrayList<>(job);
    }

    public ImmutableClassMan(int age, String name) {
        this.age = age;
        this.name = name;
        this.job = null;
    }

    public ImmutableClassMan addNewJob (String job){
        List<String> newList = getJob();
        newList.add(job);
        return new ImmutableClassMan(age, name, newList);
    }

    @Override
    public String toString() {
        return "ImmutableClassMan{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", job=" + job +
                '}';
    }
}