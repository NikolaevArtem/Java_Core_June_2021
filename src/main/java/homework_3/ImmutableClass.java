package homework_3;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;

/*
1. Don't provide "setter" methods — methods that modify fields or objects referred to by fields.
2. Make all fields final and private.
3. Don't allow subclasses to override methods. The simplest way to do this is to declare the class as final.
    A more sophisticated approach is to make the constructor private and construct instances in factory methods.
4. If the instance fields include references to mutable objects, don't allow those objects to be changed:
    - Don't provide methods that modify the mutable objects.
    - Don't share references to the mutable objects. Never store references to external,
        mutable objects passed to the constructor; if necessary, create copies, and store references to the copies.
        Similarly, create copies of your internal mutable objects when necessary to avoid returning the originals in your methods.
 */



public final class ImmutableClass {
    final private int yearOfBirth;
    final private String className;
    final private char[] password;

    public ImmutableClass() {
        this.className = "DefaultImmutableClass";
        this.yearOfBirth = LocalDate.now().getYear();
        this.password = new char[]{'p', 'a', 's', 's', 'w', 'o', 'r', 'd'};
    }

    public ImmutableClass(String className) {
        this.className = className;
        this.yearOfBirth = LocalDate.now().getYear();
        this.password = new char[]{'p', 'a', 's', 's', 'w', 'o', 'r', 'd'};
    }

    public ImmutableClass(String className, int yearOfBirth) {
        this.className = className;
        this.yearOfBirth = yearOfBirth;
        this.password = new char[]{'p', 'a', 's', 's', 'w', 'o', 'r', 'd'};
    }

    public ImmutableClass(int yearOfBirth) {
        this.className = "DefaultImmutableClass";
        this.yearOfBirth = yearOfBirth;
        this.password = new char[]{'p', 'a', 's', 's', 'w', 'o', 'r', 'd'};
    }

    public ImmutableClass(String className, int yearOfBirth, char[] password) {
        this.className = className;
        this.yearOfBirth = yearOfBirth;
        this.password = Arrays.copyOf(password, password.length);
    }

    public final ImmutableClass getChangedInstance(String className) {
        return new ImmutableClass(className, getYearOfBirth(),getPassword());
    }

    public final ImmutableClass getChangedInstance(int yearOfBirth) {
        return new ImmutableClass(getClassName(), yearOfBirth, getPassword());
    }

    public final ImmutableClass getChangedInstance(String className, int yearOfBirth) {
        return new ImmutableClass(className, yearOfBirth, getPassword());
    }

    final String getClassName() {
        return className;
    }

    final int getYearOfBirth() {
        return yearOfBirth;
    }

    final char[] getPassword() {
        return Arrays.copyOf(password, password.length);
    }

    @Override
    public String toString() {
        return "ImmutableClass{" +
                "yearOfBirth=" + yearOfBirth +
                ", className='" + className + '\'' +
                ", password=" + Arrays.toString(password) +
                '}';
    }

    public static void main(String[] args) {
        ImmutableClass im = new ImmutableClass("class", 1996, new char[] {'a','b','c','1'});
        ImmutableClass im1 = im.getChangedInstance(2007);
        System.out.println(im);
        System.out.println(im1);
        char[] pass = im.getPassword();
        char[] pass1 = im1.getPassword();

        pass[0] = '1';
        pass1[3] = '!';
        System.out.println(im);
        System.out.println(im1);
        ImmutableClass im3 = im.getChangedInstance("changedName");
        System.out.println(im);
        System.out.println(im1);
        System.out.println(im3);
    }

}
