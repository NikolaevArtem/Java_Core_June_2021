package homework_4.custom_file_reader;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CustomFileReaderTest extends UnitBase {
    CustomFileReader customFileReader = new CustomFileReader();

    @Test
    void testRun1() {
        customFileReader.run1();
        String expected = getOutput();
        if (expected.contains(",") || expected.contains(".")) {
            throw new IllegalArgumentException("Text contains symbol ',' or symbol '.'");
        }
        assertEquals(expected, getOutput());
    }

    @Test
    void testRun2() {
        customFileReader.run2();
        String expected = getOutput();
        if (expected.contains(",") || expected.contains(".")) {
            throw new IllegalArgumentException("Text contains symbol ',' or symbol '.'");
        }
        assertEquals(expected, getOutput());
    }

    @Test
    void testRun3() {
        customFileReader.run3();
        String expected = getOutput();
        if (expected.contains(",") || expected.contains(".")) {
            throw new IllegalArgumentException("Text contains symbol ',' or symbol '.'");
        }
        assertEquals(expected, getOutput());
    }
}