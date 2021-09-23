package homework_7;

import org.junit.jupiter.api.Test;

import java.awt.*;
import static org.junit.jupiter.api.Assertions.*;


public class KittenToCatTest {

    @Test
    void givenKitten_whenRunKittenToCatGrow_thenCorrectCat() {
        Kitten k = new Kitten("Cutie", "Cutos", 2, Color.RED, "Tiny collar");

        KittenToCatFunction kittenToCat = kitten -> new Cat(kitten.fullName, kitten.age + 1, kitten.color, "Big collar");

        Cat cat = kittenToCat.grow(k);

        assertEquals(cat.name, "Cutos");
        assertEquals(cat.age, 3);
        assertEquals(cat.color, Color.RED);
        assertEquals(cat.grownsOnlyCollar, "Big collar");

    }

    @Test
    void givenKittenSubClass_whenRunKittenToCatGrow_thenCorrectCat() {
        BritishKitten k = new BritishKitten("Cutie", "Cutos", 2, Color.RED, "Tiny collar");

        KittenToCatFunction kittenToCat = kitten -> new Cat(kitten.fullName, kitten.age + 1, kitten.color, "Big collar");

        Cat cat = kittenToCat.grow(k);

        assertEquals(cat.name, "Cutos");
        assertEquals(cat.age, 3);
        assertEquals(cat.color, Color.RED);
        assertEquals(cat.grownsOnlyCollar, "Big collar");

    }
}
