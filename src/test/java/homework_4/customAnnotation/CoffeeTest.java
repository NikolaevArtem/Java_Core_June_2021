package homework_4.customAnnotation;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static homework_4.customAnnotation.ClassCoffeeAnnotation.Size.SMALL;
import static org.junit.jupiter.api.Assertions.*;

class CoffeeTest extends UnitBase {

    @Test
    void givenDefault_whenMainRun_thenStandartOutput() throws ClassNotFoundException, NoSuchMethodException {
        new Main().main(new String[]{});
        assertEquals("Size: MEDIUM", getOutputLines()[0]);
        assertEquals("With milk: false", getOutputLines()[1]);
        assertEquals("Price: 100₽", getOutputLines()[2]);
        assertEquals("Give me please this one!", getOutputLines()[3]);
        assertEquals("Start making coffee - true", getOutputLines()[5]);
        assertEquals("Stop making coffee - true", getOutputLines()[7]);
    }

    @Test
    void givenNoParameters_whenCreateExistingCoffee_thenFieldsAreEqual() {
        Coffee myCoffee = new Coffee();

        assertFalse(myCoffee.hasMilk);
        assertEquals(100, myCoffee.price);
        assertEquals("MEDIUM", myCoffee.size.toString());
    }

    @Test
    void givenAnnotaionParameters_whenExtendsCoffee_thenFieldsDiffer() {

        @ClassCoffeeAnnotation(price = 200, hasMilk = true, size = SMALL)
        class NextCoffee extends Coffee {};

        Coffee myCoffee = new NextCoffee();

        assertTrue(myCoffee.hasMilk);
        assertEquals(200, myCoffee.price);
        assertEquals("SMALL", myCoffee.size.toString());
    }

}