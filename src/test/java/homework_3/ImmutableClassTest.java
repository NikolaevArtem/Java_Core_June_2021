package homework_3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImmutableClassTest {
    ImmutableClass immutableClass = new ImmutableClass(34, "String", 45);
    ImmutableClass immutableClass1 = immutableClass.returnModifyObject(45);

    @Test
    void testNotEquals() {
        assertNotEquals(immutableClass, immutableClass1);
    }

    @Test
    void testMutableField() {
        assertEquals(45, immutableClass1.getBigInteger());
    }

    @Test
    void testBothMutableField() {
        assertEquals(immutableClass1.getBigInteger(), immutableClass.getBigInteger());
    }
}