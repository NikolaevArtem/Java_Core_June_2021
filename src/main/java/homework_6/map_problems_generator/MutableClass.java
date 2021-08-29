package homework_6.map_problems_generator;

import java.util.Objects;
import java.util.Random;

public class MutableClass implements MapKeyable {

    private String val;

    public String getVal() {
        return val;
    }

    public void setVal(String s) {
        this.val = s;
    }

    @Override
    public int hashCode() {
        return new Random().nextInt(Integer.MAX_VALUE - 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MutableClass that = (MutableClass) o;
        return Objects.equals(val, that.val);
    }


}
