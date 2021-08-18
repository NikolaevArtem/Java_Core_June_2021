package homework_4.custom_file_reader;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomFileReaderTest extends UnitBase {

    CustomFileReader reader = new CustomFileReader();
    private final String stringTest = "Test  file";

    @Test
    void testNIO2() {
        reader.run1();
        assertTrue(getOutput().contains(stringTest));
    }

    @Test
    void testBufferedReaderFileReader() {
        reader.run2();
        assertTrue(getOutput().contains(stringTest));
    }

    @Test
    void testScannerFileReader() {
        reader.run3();
        assertTrue(getOutput().contains(stringTest));
    }

}