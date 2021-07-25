package homework_3;

/*

The class is immutable because:

The instance variable of the class is final i.e. we cannot change the value of it after creating an object.
The class is final so we cannot create the subclass.
There is no setter methods i.e. we have no option to change the value of the instance variable.

These points makes this class as immutable.


 */


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public final class ImmutableClass {
    private final String s;
    private final Collection<String> col;

    public ImmutableClass(String s) {
        this.s = s;
        this.col = new ArrayList<>();
    }

    public ImmutableClass(String s, Collection<String> col) {
        this.s = s;
        this.col = col;
    }

    public String getS() {
        return s;
    }

    public Collection<String> getCol() {
        return Collections.unmodifiableCollection(this.col);
    }
}

