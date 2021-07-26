package homework_3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImmutableClassManTest {
    ImmutableClassMan immutableClassMan = new ImmutableClassMan(34, "String", 143);
    ImmutableClassMan immutableClassMan1 = immutableClassMan.returnModifyMan(143);

    @Test
    void testNotEquals() {
        assertNotEquals(immutableClassMan, immutableClassMan1);
    }

    @Test
    void testMutableField() {
        assertEquals(143, immutableClassMan1.getIq());
    }

    @Test
    void testBothMutableField() {
        assertEquals(immutableClassMan1.getIq(), immutableClassMan.getIq());
    }
}