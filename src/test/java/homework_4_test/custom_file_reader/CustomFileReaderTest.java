package homework_4_test.custom_file_reader;

import base.UnitBase;
import homework_4.custom_file_reader.CustomFileReader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomFileReaderTest extends UnitBase {

    @Test
    void givenDefaultFile_whenRun_thenModifiedTextIsOutputted() {
        String expected = "Hello there! I'm a test string\r\n" +
                          "Use me for demonstration please";

        new CustomFileReader().run1();
        String actual = getOutput();
        assertEquals(expected, actual);
        removeFromOutput(actual);

        new CustomFileReader().run2();
        actual = getOutput();
        assertEquals(expected, actual);
        removeFromOutput(actual);

        new CustomFileReader().run3();
        actual = getOutput();
        assertEquals(expected, actual);
        removeFromOutput(actual);

        new CustomFileReader().run4();
        actual = getOutput();
        assertEquals(expected, actual);
        removeFromOutput(actual);

        new CustomFileReader().run5();
        actual = getOutput();
        assertEquals(expected, actual);
        removeFromOutput(actual);

        new CustomFileReader().run6();
        actual = getOutput();
        assertEquals(expected, actual);
        removeFromOutput(actual);

        new CustomFileReader().run7();
        actual = getOutput();
        assertEquals(expected, actual);
    }

    @Test
    void givenNoFile_whenRun_thenNotFoundMessage() {
        String expected = "File not found";

        new CustomFileReader("nonExistentFile.txt").run1();
        String actual = getOutput();
        assertEquals(expected, actual);
        removeFromOutput(actual);

        new CustomFileReader("nonExistentFile.txt").run2();
        actual = getOutput();
        assertEquals(expected, actual);
        removeFromOutput(actual);

        new CustomFileReader("nonExistentFile.txt").run3();
        actual = getOutput();
        assertEquals(expected, actual);
        removeFromOutput(actual);

        new CustomFileReader("nonExistentFile.txt").run4();
        actual = getOutput();
        assertEquals(expected, actual);
        removeFromOutput(actual);

        new CustomFileReader("nonExistentFile.txt").run5();
        actual = getOutput();
        assertEquals(expected, actual);
        removeFromOutput(actual);

        new CustomFileReader("nonExistentFile.txt").run6();
        actual = getOutput();
        assertEquals(expected, actual);
        removeFromOutput(actual);

        new CustomFileReader("nonExistentFile.txt").run7();
        actual = getOutput();
        assertEquals(expected, actual);
    }
}
