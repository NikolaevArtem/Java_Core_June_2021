package homework_3;

/**
 * A Strategy for Defining Immutable Objects (from the official Oracle documentation)
 * <p>
 * 1. Don't provide "setter" methods — methods that modify fields or objects referred to by fields.
 * <p>
 * 2. Make all fields final and private.
 * <p>
 * 3. Don't allow subclasses to override methods. The simplest way to do this is to declare the class as final.
 * A more sophisticated approach is to make the constructor private and construct instances in factory methods.
 * <p>
 * 4. If the instance fields include references to mutable objects, don't allow those objects to be changed:
 * - Don't provide methods that modify the mutable objects.
 * - Don't share references to the mutable objects.
 * Never store references to external, mutable objects passed to the constructor;
 * if necessary, create copies, and store references to the copies.
 * Similarly, create copies of your internal mutable objects when necessary to avoid returning the originals in your methods.
 */

final public class ImmutableClass {

    // Values must be between 0 and 255 (RGB)
    final private Integer red;
    final private Integer green;
    final private Integer blue;
    final private String name;

    private void check(Integer red,
                       Integer green,
                       Integer blue) {
        if (red < 0 || red > 255
                || green < 0 || green > 255
                || blue < 0 || blue > 255) {
            throw new IllegalArgumentException();
        }
    }

    public ImmutableClass(Integer red,
                          Integer green,
                          Integer blue,
                          String name) {
        check(red, green, blue);
        this.red = new Integer(red);
        this.green = new Integer(green);
        this.blue = new Integer(blue);
        this.name = new String(name);
    }

    public ImmutableClass() {
        this.red = 0;
        this.green = 0;
        this.blue = 0;
        this.name = "black";
    }

    public Integer getRed() {
        return new Integer(red);
    }

    public Integer getGreen() {
        return new Integer(green);
    }

    public Integer getBlue() {
        return new Integer(blue);
    }

    public String getName() {
        return new String(name);
    }

    public ImmutableClass invert() {
        return new ImmutableClass(
                255 - red,
                255 - green,
                255 - blue,
                "Inverse of " + name);
    }

    public ImmutableClass getInstance() {
        return new ImmutableClass(
                getRed(),
                getGreen(),
                getBlue(),
                getName()
        );
    }
}
