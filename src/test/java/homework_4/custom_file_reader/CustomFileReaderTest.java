package homework_4.custom_file_reader;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static homework_4.custom_file_reader.CustomFileReader.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

class CustomFileReaderTest extends UnitBase {

    @Test
    void TestRun1() throws IOException {
        run1();
        assertFalse(getOutput().contains("."));
        assertFalse(getOutput().contains(","));
    }

    @Test
    void TestRun2() throws FileNotFoundException {
        run2();
        assertFalse(getOutput().contains("."));
        assertFalse(getOutput().contains(","));
    }

    @Test
    void TestRun3() throws IOException {
        run3();
        assertFalse(getOutput().contains("."));
        assertFalse(getOutput().contains(","));
    }

    @Test
    void TestRun4() throws IOException {
        run4();
        assertFalse(getOutput().contains("."));
        assertFalse(getOutput().contains(","));
    }
}