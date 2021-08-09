package homework_3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ImmutableClassTest {

    @Test
    public void immutableClassTest() {
        ImmutableClass immutableClass = new ImmutableClass(21, 25, 6, "Vasya");
        ImmutableClass immutableClassAge = immutableClass.changeAge(2);
        ImmutableClass immutableClassName = immutableClass.changeName("neVasya");
        ImmutableClass immutableClassHigh = immutableClass.changeWeightAndHigh(2, 22);

        Assertions.assertNotSame(immutableClass, immutableClassAge);
        Assertions.assertNotSame(immutableClass, immutableClassHigh);
        Assertions.assertNotSame(immutableClass, immutableClassName);

        Assertions.assertNotEquals(immutableClass, immutableClassAge);
        Assertions.assertNotEquals(immutableClass, immutableClassName);
        Assertions.assertNotEquals(immutableClass, immutableClassHigh);
    }
}
