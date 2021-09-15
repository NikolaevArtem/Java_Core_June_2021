package homework_7.kitten_to_cat;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KittenToCatTest {

    private static final String expected = Cat.class.getSimpleName();

    @Test
    void testKittenToCat() {
        Kitten kitten = new Kitten("Joe Bezos", 3, "Amazonerre");
        KittenToCatFunction kittyFoo = kitten1 -> new Cat("Joseph Bezos", kitten.getAge() + 2);
        Cat cat = kittyFoo.grow(kitten);
        assertEquals(expected, cat.getClass().getSimpleName());
    }

    @Test
    void testKittenInheritedToCatCast() {

        class JustBornKitten extends Kitten {

            private final LocalDate bornDate;

            public JustBornKitten(String name, int age, String breed) {
                super(name, age, breed);
                bornDate = LocalDate.now();
            }

        }

        JustBornKitten justBornKitten = new JustBornKitten("Billy", 0, "Microkitty");
        KittenToCatFunction kittyFoo = kitten -> new Cat("Bill Gates", justBornKitten.getAge() + 3);
        Cat cat = kittyFoo.grow(justBornKitten);
        assertEquals(expected, cat.getClass().getSimpleName());
    }

    @Test
    void testKittenToInheritedCatCast() {

        class WildCat extends Cat {

            private final String location;

            public WildCat(String name, int age) {
                super(name, age);
                this.location = "Africa";
            }

        }

        Kitten kitty = new Kitten("Elon", 1, "Nikoleslie");
        KittenToCatFunction kittyFoo = kit -> new WildCat("Elon Mask", kitty.getAge() + 3);
        WildCat wildCat = (WildCat) kittyFoo.grow(kitty);
        assertEquals(wildCat.getClass().getSimpleName(), wildCat.getClass().getSimpleName());
    }

}
