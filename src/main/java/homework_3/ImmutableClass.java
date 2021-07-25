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

    public ImmutableClass(int one, String two) {
        this.one = one;
        this.two = two;
        this.three = 'A';
    }

    public ImmutableClass(int one, String two, Character three) {
        this.one = one;
        this.two = two;
        this.three = three;
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

    public ImmutableClass getImmutableClass(Character a){
        return new ImmutableClass(one, two, a);
    }
}
