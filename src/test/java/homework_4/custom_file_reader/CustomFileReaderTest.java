package homework_4.custom_file_reader;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomFileReaderTest extends UnitBase {
    @Test
    public void test1() {
        try {
            new CustomFileReader().run1();
        } catch (IOException e){
            assertEquals(FileNotFoundException.class, e.getClass());
        }
       assertEquals("This car I told you about which had this nice built-in audio system was bought yesterday by some banker", getOutputLines()[0]);
    }

    @Test
    public void test2() {
        try {
            new CustomFileReader().run2();
        } catch (IOException e){
            assertEquals(FileNotFoundException.class, e.getClass());
        }
        assertEquals("This car I told you about which had this nice built-in audio system was bought yesterday by some banker", getOutputLines()[0]);
    }

    @Test
    public void test3() {
        try {
            new CustomFileReader().run3();
        } catch (IOException e){
            assertEquals(FileNotFoundException.class, e.getClass());
        }
        assertEquals("This car I told you about which had this nice built-in audio system was bought yesterday by some banker", getOutputLines()[0]);
    }
}
