package homework_6.map_problems_generator;

import java.util.Random;

public class MutableClass {

    private int a;

    public MutableClass(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return String.valueOf(a);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MutableClass that = (MutableClass) o;
        return a == that.a;
    }

    @Override
    public int hashCode() {
        return new Random().nextInt(Integer.MAX_VALUE-1);
    }
}
