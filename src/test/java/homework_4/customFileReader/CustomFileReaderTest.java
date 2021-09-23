package homework_4.customFileReader;

import base.UnitBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomFileReaderTest extends UnitBase {

    private final String[] expected = new String[]
            {"Я вас любил: любовь еще быть может",
            "В душе моей угасла не совсем;",
            "Но пусть она вас больше не тревожит;",
            "Я не хочу печалить вас ничем"};

    private String filename = "src/main/resources/custom_file_reader/file.txt";

    @Test
    void givenTextFile_whenRun1_thenEquals() throws IOException {
        new CustomFileReader(filename).run1();
        assertEquals(Arrays.toString(expected), Arrays.toString(getOutputLines()));
    }

    @Test
    void givenTextFile_whenRun2_thenEquals() throws IOException {
        new CustomFileReader(filename).run2();
        assertEquals(Arrays.toString(expected), Arrays.toString(getOutputLines()));
    }

    @Test
    void givenTextFile_whenRun3_thenEquals() throws IOException {
        new CustomFileReader(filename).run3();
        assertEquals(Arrays.toString(expected), Arrays.toString(getOutputLines()));
    }

    @Test
    void givenTextFile_whenRun4_thenEquals() throws IOException {
        new CustomFileReader(filename).run4();
        assertEquals(Arrays.toString(expected), Arrays.toString(getOutputLines()));
    }

    @Test
    void givenNotExistingFile_whenRun_thenException() {

        filename = "src/main/resources/custom_file_reader/fileX.txt";

        Assertions.assertThrows(FileNotFoundException.class, () -> new CustomFileReader(filename).run1());
        Assertions.assertThrows(FileNotFoundException.class, () -> new CustomFileReader(filename).run2());

        Assertions.assertThrows(NoSuchFileException.class, () -> new CustomFileReader(filename).run3());
        Assertions.assertThrows(NoSuchFileException.class, () -> new CustomFileReader(filename).run4());
    }

}