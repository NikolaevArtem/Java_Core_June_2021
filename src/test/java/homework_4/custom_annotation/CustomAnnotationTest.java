package homework_4.custom_annotation;

import base.UnitBase;
import homework_4.custom_file_reader.CustomFileReader;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

public class CustomAnnotationTest extends UnitBase {

    @Test
    void givenRun1_whenSearch_thenTrue() {

        try {
            Method m = new CustomFileReader("").getClass().getMethod("run1");
            assertTrue(m.isAnnotationPresent(CustomAnnotation.class));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Test
    void givenRun2_whenSearch_thenTrue() {

        try {
            Method m = new CustomFileReader("").getClass().getMethod("run2");
            assertTrue(m.isAnnotationPresent(CustomAnnotation.class));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Test
    void givenRun3_whenSearch_thenTrue() {

        try {
            Method m = new CustomFileReader("").getClass().getMethod("run3");
            assertTrue(m.isAnnotationPresent(CustomAnnotation.class));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Test
    void givenRun1_whenRun_thenTrue() {
        new CustomFileReader("").run1("/custom_file_reader/file.txt");
        printOut();
        String expected = getOutputLines()[0];
        new CustomFileReader("file.txt").run("run1");
        printOut();
        String actual = getOutputLines()[0];
        assertEquals(expected, actual);
    }

    @Test
    void givenRun2_whenRun_thenTrue() {
        new CustomFileReader("").run2("src/main/resources/custom_file_reader/file.txt");
        printOut();
        String expected = getOutputLines()[0];
        new CustomFileReader("file.txt").run("run2");
        printOut();
        String actual = getOutputLines()[0];
        assertEquals(expected, actual);
    }

    @Test
    void givenRun3_whenRun_thenTrue() {
        new CustomFileReader("").run3("src/main/resources/custom_file_reader/file.txt");
        printOut();
        String expected = getOutputLines()[0];
        new CustomFileReader("file.txt").run("run3");
        printOut();
        String actual = getOutputLines()[0];
        assertEquals(expected, actual);
    }
}
