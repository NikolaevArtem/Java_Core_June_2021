package homework_3;

import java.util.ArrayList;
import java.util.Arrays;

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
    final private ArrayList<Integer> dataColor;
    final private StringBuilder name;

    private void check(Integer red,
                       Integer green,
                       Integer blue) {
        if (red < 0 || red > 255
                || green < 0 || green > 255
                || blue < 0 || blue > 255) {
            throw new IllegalArgumentException();
        }
    }

    public ImmutableClass(ArrayList<Integer> dataColor,
                          StringBuilder name) {
        check(dataColor.get(0), dataColor.get(1), dataColor.get(2));
        this.dataColor = new ArrayList<>(dataColor);
        this.name = new StringBuilder(name);
    }


    public ArrayList<Integer> getColorData()
    {
        return new ArrayList<>(dataColor);
    }

    public StringBuilder getName() {
        return new StringBuilder(name);
    }

    public ImmutableClass invert() {
        return new ImmutableClass(new ArrayList<>(Arrays.asList(255 - dataColor.get(0),
                                                                255 - dataColor.get(1),
                                                                255 - dataColor.get(2))
                                                  ), new StringBuilder("Inverse of " + name));
    }

    public ImmutableClass getInstance() {
        return new ImmutableClass(getColorData(), getName());
    }
}
