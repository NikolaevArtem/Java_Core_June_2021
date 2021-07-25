package homework_3;

import java.util.List;

final class ImmutableClass {

    private final int firstInt;

    private final String firstString;

    private final int[] firstIntArray;

    private final String[] firstStringArray;

    private final List<Integer> firstCollection;


    ImmutableClass(int firstInt, String firstString, int[] firstIntArray, String[] firstStringArray, List<Integer> firstCollection) {
        this.firstInt = firstInt;
        this.firstString = firstString;
        this.firstIntArray = firstIntArray;
        this.firstStringArray = firstStringArray;
        this.firstCollection = firstCollection;
    }

    public int getFirstInt() {
        return firstInt;
    }

    public String getFirstString() {
        return firstString;
    }

    public int[] getFirstIntArray() {
        return firstIntArray;
    }

    public String[] getFirstStringArray() {
        return firstStringArray;
    }

    public List<Integer> getFirstCollection() {
        return firstCollection;
    }

    public ImmutableClass getNewImmutableClass(int x, String y, int[] xy, String[] yx, List<Integer> list) {
        return new ImmutableClass(x,y,xy,yx,list);
    }
}
