package homework_4.custom_annotation;

import base.UnitBase;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CustomAnnotationTest extends UnitBase {
    private final static String DEFAULT_MESSAGE = "Hello, World!";

    @Test
    public void emptyConstructor() {
        new FirstProgram();
        printOut();
        assertEquals(DEFAULT_MESSAGE, getOutput());
    }

    @Test
    public void nonEmptyConstructor() {
        String msg = "Some message";
        new FirstProgram(msg);
        printOut();
        assertEquals(msg, getOutput());
    }

}
