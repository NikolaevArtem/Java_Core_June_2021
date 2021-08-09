package homework_4.custom_file_reader;

import base.UnitBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomFileReaderTest extends UnitBase {

    static final String EXPECTED_VALUE = "The text in a way consists of a number of sentences One sentence even a very widespread complex one cannot be called a text since the text can be divided into independent sentences and parts of the sentence are combined according to the laws of the syntax of a complex sentence but not the text";

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
