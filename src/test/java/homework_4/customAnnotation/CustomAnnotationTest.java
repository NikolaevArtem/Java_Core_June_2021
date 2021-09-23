package homework_4.customAnnotation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomAnnotationTest {

    @Test
    void testAnnotationDefaultConstructorValue() {
        Cat cat = new Cat ();
        assertEquals ("defValue",  cat.testValue);
    }
}
