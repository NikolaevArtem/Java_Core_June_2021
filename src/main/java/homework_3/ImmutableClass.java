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



final public class ImmutableClass {
    final private int yearOfBirth;
    final private String className;
    final private static boolean isMutable = false;
    final private int[] randomInts;

    public ImmutableClass() {
        this.className = "DefaultImmutableClass";
        this.yearOfBirth = LocalDate.now().getYear();
        this.randomInts = new int[className.length()];
        generateRandomArr();
    }


    public ImmutableClass(String className) {
        this(className, className.length());
        generateRandomArr();
    }

    public ImmutableClass(String className, int lengthRandomInts) {
        this.className = className;
        this.yearOfBirth = LocalDate.now().getYear();
        this.randomInts = new int[lengthRandomInts];
        generateRandomArr();
    }

    public ImmutableClass(int lengthRandomInts) {
        this.randomInts = new int[lengthRandomInts];
        this.className = generateRandomName();
        this.yearOfBirth = LocalDate.now().getYear();
        generateRandomArr();
    }

    public ImmutableClass(String className, int yearOfBirth, int lengthRandomInts) {
        this.className = className;
        this.yearOfBirth = yearOfBirth;
        this.randomInts = new int[lengthRandomInts];
        generateRandomArr();
    }

    private void generateRandomArr() {
        Random rndm = new Random((long) className.hashCode() * yearOfBirth);
        for (int i = 0; i < randomInts.length; i++) {
            randomInts[i] = rndm.nextInt();
        }
    }

    private String generateRandomName() {
        Random rndm = new Random((long) Arrays.hashCode(randomInts) * yearOfBirth);
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < randomInts.length; i++) {
            temp.append(rndm.nextInt(26) + 65);
        }
        return temp.toString();
    }

    final int[] getRandomInts() {
        return Arrays.copyOf(randomInts, randomInts.length);
    }

    final String getClassName() {
        return className;
    }

    public static ImmutableClass getChangedInstance(String className, int lengthRandomInts) {
        return new ImmutableClass(className, lengthRandomInts);
    }


    public static ImmutableClass getChangedInstance(int lengthRandomInts) {
        return new ImmutableClass(lengthRandomInts);
    }


    public static ImmutableClass getChangedInstance(String className) {
        return new ImmutableClass(className);
    }
}
