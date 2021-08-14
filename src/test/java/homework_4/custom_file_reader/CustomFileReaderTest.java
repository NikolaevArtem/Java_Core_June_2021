package homework_4.custom_file_reader;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomFileReaderTest extends UnitBase {
    CustomFileReader reader = new CustomFileReader();
    String expectedString = "Hello World!";

    @Test
    void testInputStreamReader() {
        reader.run1();
        assertTrue(getOutput().contains(expectedString));
    }

    @Test
    void testFileReader() {
        reader.run2();
        assertTrue(getOutput().contains(expectedString));
    }

    @Test
    void testScanner() {
        reader.run3();
        assertTrue(getOutput().contains(expectedString));
    }

    @Test
    void testNIO() {
        reader.run4();
        assertTrue(getOutput().contains(expectedString));
    }


}