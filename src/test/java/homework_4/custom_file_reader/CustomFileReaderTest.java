package homework_4.custom_file_reader;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class CustomFileReaderTest extends UnitBase {

    @Test
    void test() throws IOException {
        CustomFileReader reader = new CustomFileReader();
        String text = "t.e,,w\nr,,3,,,g\na,,,d...3";
        reader.changeFileText(text);
        reader.run();
        assertEquals("tew", getOutputLines()[0]);
        assertEquals("r3g", getOutputLines()[1]);
        assertEquals("ad3", getOutputLines()[2]);
        reader.run2();
        assertEquals("tew", getOutputLines()[0]);
        assertEquals("r3g", getOutputLines()[1]);
        assertEquals("ad3", getOutputLines()[2]);
        reader.run3();
        assertEquals("tew", getOutputLines()[0]);
        assertEquals("r3g", getOutputLines()[1]);
        assertEquals("ad3", getOutputLines()[2]);
    }

    @Test
    void text_empty () throws IOException {
        CustomFileReader reader = new CustomFileReader();
        String text = "";
        reader.changeFileText(text);
        reader.run();
        assertEquals("", getOutputLines()[0]);
        reader.run2();
        assertEquals("", getOutputLines()[0]);
        reader.run3();
        assertEquals("", getOutputLines()[0]);
    }

}