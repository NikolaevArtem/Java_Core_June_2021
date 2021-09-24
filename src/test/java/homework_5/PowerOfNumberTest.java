package homework_5;


import base.UnitBase;
import homework_5.powerOfNumber.PowerOfNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PowerOfNumberTest extends UnitBase {
    @Test
    public void testRecMethodWithNegativeNumber() {
        setInput("-2");
        new PowerOfNumber().run();
        assertEquals("Only 2 non-negative integers are allowed", getOutputLines()[0]);
    }
    @Test
    public void testRecMethondWithString() {
        setInput("String");
        new PowerOfNumber().run();
        assertEquals("Only 2 non-negative integers are allowed", getOutputLines()[0]);
    }
    @Test
    public void powerOfNumberTest() {
        assertEquals(4,new PowerOfNumber().rec(2,2));
    }
    @Test
    public void powerOfNumberTest2() {
        assertEquals(2,new PowerOfNumber().rec(2,1));
    }
    @Test
    public void powerOfNumberTest3() {
        assertEquals(1,new PowerOfNumber().rec(2,0));
    }
    @Test
    public void powerOfNumberTest4() {
        assertEquals(0,new PowerOfNumber().rec(0,2));
    }
}