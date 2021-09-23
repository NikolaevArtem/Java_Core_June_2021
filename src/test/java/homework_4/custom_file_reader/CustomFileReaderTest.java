package homework_4.custom_file_reader;

import base.UnitBase;
import homework_4.custom_file_reader.CustomFileReader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CustomFileReaderTest extends UnitBase {

    @Test
    void givenNull_whenRun1_thenError() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new CustomFileReader(null).run1(null);
        });
    }

    @Test
    void givenNull_whenRun2_thenError() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new CustomFileReader(null).run2(null);
        });
    }

    @Test
    void givenNull_whenRun3_thenError() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new CustomFileReader(null).run3(null);
        });
    }

    @Test
    void givenEmpty_whenRun1_thenError() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new CustomFileReader("").run1("");
        });
    }

    @Test
    void givenEmpty_whenRun2_thenError() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new CustomFileReader("").run2("");
        });
    }

    @Test
    void givenEmpty_whenRun3_thenError() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new CustomFileReader("").run3("");
        });
    }

    @Test
    void givenWrongPath_whenRun1_thenError() {

        Exception exception = assertThrows(NullPointerException.class, () -> {
            new CustomFileReader("").run1("/custom_file_reader/file1.txt");
        });
    }

    @Test
    void givenWrongPath_whenRun2_thenError() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new CustomFileReader("").run2("/custom_file_reader/file1.txt");
        });
    }

    @Test
    void givenWrongPath_whenRun3_thenError() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new CustomFileReader("").run3("/custom_file_reader/file1.txt");
        });
    }

    @Test
    void givenPath_whenRun1_thenPrint() {
        new CustomFileReader("").run1("/custom_file_reader/file.txt");
        printOut();

        assertEquals("hello homework 4", getOutputLines()[0]);
    }

    @Test
    void givenPath_whenRun2_thenPrint() {
        new CustomFileReader("").run2("src/main/resources/custom_file_reader/file.txt");
        printOut();

        assertEquals("hello homework 4", getOutputLines()[0]);
    }

    @Test
    void givenPath_whenRun3_thenPrint() {
        new CustomFileReader("").run3("src/main/resources/custom_file_reader/file.txt");
        printOut();

        assertEquals("hello homework 4", getOutputLines()[0]);
    }


}
