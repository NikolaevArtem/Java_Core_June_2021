package homework_4.сustom_annotation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleClassWithNameFieldTest {
    @Test
    void testEmptyNameString() {
        SimpleClassWithNameField obj = new SimpleClassWithNameField("");
        assertEquals("test name string", obj.getName());
    }

    @Test
    void testNotEmptyNameString() {
        SimpleClassWithNameField obj = new SimpleClassWithNameField("test");
        assertEquals("test", obj.getName());
    }
}