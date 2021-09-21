package homework_4.customer_annotation;

import base.UnitBase;
import homework_4.custom_annotation.Planet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerAnnotationTest extends UnitBase {

    @Test
    void givenNothing_whenRun_thenCreatePlanetWithNameAndAge() {
        Planet planet = new Planet();

        assertEquals("Zuza", planet.getName());
        assertEquals(23, planet.getAge());
    }
}
