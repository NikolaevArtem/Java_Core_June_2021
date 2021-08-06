package homework_4.custom_file_reader;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CustomFileReaderTest extends UnitBase {

    CustomFileReader customFileReader = new CustomFileReader();

    @Test
    void testRun1() throws IOException {
        customFileReader.run1();
        String result = getOutput();
        assertTrue(checkResult(result));
    }

    @Test
    void testRun2() throws IOException {
        customFileReader.run2();
        String result = getOutput();
        assertTrue(checkResult(result));
    }

    @Test
    void testRun3() throws IOException {
        customFileReader.run3();
        String result = getOutput();
        assertTrue(checkResult(result));
    }

    private boolean checkResult(String res) {
        return !(res.contains(".") && res.contains(","));
    }

}