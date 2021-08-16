package homework_4.custom_annotation_tests;

import homework_4.custom_annotation.Cat;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomAnnotationTest {

    @Test
    void givenNothing_whenCreateNewCatWithoutNameNorWeight_thenCreatedCatWithNameAndWeightSetInAnnotation() {
        Cat cat = new Cat();

        assertEquals("Barsik", cat.getName());
        assertEquals(3.09, cat.getWeight());
    }

    @Test
    void givenNameAndWeight_whenCreateNewCatWithNameAndWeight_thenCreatedCatWithNameAndWeightPassedToConstructor() {
        final String name = "Murzik";
        final double weight = 4.0;
        Cat cat = new Cat(name, weight);

        assertEquals(name, cat.getName());
        assertEquals(weight, cat.getWeight());
    }
}
