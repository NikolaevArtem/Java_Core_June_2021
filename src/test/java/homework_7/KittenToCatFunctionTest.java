package homework_7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KittenToCatFunctionTest {

    private KittenToCatFunction ktc = kitten -> new Cat(kitten.getName(), kitten.getWeight() + 3, 10);

    @Test
    public void interfaceTest() {
        Kitten barsik = new Kitten("Barsik", 2.5, 4);

        Cat grownUpBarsik = ktc.grow(barsik);

        assertEquals(Cat.class, grownUpBarsik.getClass());
        assertEquals(barsik.getName(), grownUpBarsik.getName());
        assertEquals(barsik.getWeight() + 3, grownUpBarsik.getWeight());
        assertEquals(10, grownUpBarsik.getWhiskersLength());
    }

}
