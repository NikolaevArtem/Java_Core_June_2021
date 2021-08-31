package homework_4.custom_annotation;

import base.UnitBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GuitarTest extends UnitBase {
    private static final String GUITAR_WITH_ANNOTATION = "Model of guitar: Sophia; Manufacturer: A&M guitars; year: 2015; S/N: 101";
    private static final String GUITAR_FOR_TEST = "Model of guitar: Mh-250; Manufacturer: ESP-LTD; year: 2004; S/N: 719";

    @Test
    public void AnnotationTest () {
        Guitar annotationGuitar = new Guitar();
        Assertions.assertEquals(GUITAR_WITH_ANNOTATION, annotationGuitar.toString());
    }

    @Test
    public void CorrectGuitarTest () {
        Guitar correctGuitar = new Guitar("Mh-250", "ESP-LTD", 2004, 719);
        Assertions.assertEquals(GUITAR_FOR_TEST, correctGuitar.toString());
    }
}
