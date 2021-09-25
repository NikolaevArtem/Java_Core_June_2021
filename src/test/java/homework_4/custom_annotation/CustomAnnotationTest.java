package homework_4.custom_annotation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomAnnotationTest {
    Main main = new Main();

    @Test
    void testCustomAnnotation() {
        CustomAnnotation annotation = Main.class.getAnnotation(CustomAnnotation.class);

        Assertions.assertEquals(annotation.DEFAULT_AUTHOR.getName(), "Rog Elena");
        Assertions.assertEquals(annotation.DEFAULT_COUNTRY, "Russia");
        Assertions.assertEquals(annotation.v(), 1.2f);
    }
}