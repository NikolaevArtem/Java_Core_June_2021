package homework_4.custom_file_reader;

import base.UnitBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomFileReaderTest extends UnitBase {

    static final String EXPECTED_VALUE = "awdwadawdaawdawawdawdawdawdawdawdawdawdawdawdawdawdawdawdawda";

    @Test
    public void utilReaderTest() {
        CustomFileReader customFileReader = new CustomFileReader();
        customFileReader.run1();
        printOut();
        Assertions.assertEquals(EXPECTED_VALUE, getOutputLines()[0]);
    }

    @Test
    public void nioReaderTest() {
        CustomFileReader customFileReader = new CustomFileReader();
        customFileReader.run2();
        printOut();
        Assertions.assertEquals(EXPECTED_VALUE, getOutputLines()[0]);
    }

    @Test
    public void ioReaderTest() {
        CustomFileReader customFileReader = new CustomFileReader();
        customFileReader.run3();
        printOut();
        Assertions.assertEquals(EXPECTED_VALUE, getOutputLines()[0]);
    }
}
