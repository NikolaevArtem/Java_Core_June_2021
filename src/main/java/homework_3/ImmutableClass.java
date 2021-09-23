package homework_3;

/* Requirements for the Immutable Class:
 *  1. Class has 2 constructors with 2 required fields
 *  2. Fields cannot be changed, you only have geters;
 *  3. You can get the same one ImmutableClass with the changed field "three",
 *  using the method getImmutableClass(). He back new ImmutableClass.
 * */

public final class ImmutableClass {

    private final int one;
    private final String two;
    private final Character three;
    private final String[] names;

    public ImmutableClass(int one, String two, Character three, String[] names) {
        this.one = one;
        this.two = two;
        this.three = three;
        this.names = names;
    }

    public int getOne() {
        return one;
    }

    public String getTwo() {
        return two;
    }

    public Character getThree() {
        return three;
    }

    public String[] getNames() {
        return names.clone();
    }

    public ImmutableClass getImmutableClass(int one) {
            return new ImmutableClass(one, getTwo(), getThree(), getNames());
    }

    public ImmutableClass getImmutableClass(Character someChar) {
        if (someChar != null) {
            return new ImmutableClass(getOne(), getTwo(), someChar, getNames());
        } else return new ImmutableClass(getOne(), getTwo(), getThree(), getNames());
    }

    public ImmutableClass getImmutableClass(String[] str) {
        if (str != null) {
            return new ImmutableClass(getOne(), getTwo(), getThree(), str);
        } else return new ImmutableClass(getOne(), getTwo(), getThree(), getNames());
    }
}
