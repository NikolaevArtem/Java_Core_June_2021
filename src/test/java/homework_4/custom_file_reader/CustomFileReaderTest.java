package homework_4.custom_file_reader;

import base.UnitBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CustomFileReaderTest extends UnitBase {

    @Test()
    public void givenWrongFile_whenRun1_thenException() {
        String file = "src/main/resources/custom_file_reader/djfhghdjfg.txt";
        Assertions.assertThrows(IOException.class, () -> {
            new CustomFileReader(file).run1();
        });
    }

    @Test
    public void givenEmptyFile_whenRun1_thenEmpty() throws IOException {
        String file = "src/main/resources/custom_file_reader/emptyFileForTests.txt";
        new CustomFileReader(file).run1();
        assertEquals("", getOutput());
    }

    @Test
    public void givenFileDotsCommasOnly_whenRun1_thenEmpty() throws IOException {
        String file = "src/main/resources/custom_file_reader/fileDotsCommasOnly.txt";
        new CustomFileReader(file).run1();
        assertEquals("", getOutput());
    }

    @Test
    public void givenTextFile_whenRun1_thenNewText() throws IOException {
        String file = "src/main/resources/custom_file_reader/fileTest.txt";
        new CustomFileReader(file).run1();
        assertEquals("dfgdfgdgdgdfggdfgdfgfdgdfgfgfdgdfgdfgdfgdfg", getOutput());
    }

    @Test()
    public void givenWrongFile_whenRun2_thenException() {
        String file = "src/main/resources/custom_file_reader/djfhghdjfg.txt";
        Assertions.assertThrows(FileNotFoundException.class, () -> {
            new CustomFileReader(file).run2();
        });
    }

    @Test
    public void givenEmptyFile_whenRun2_thenEmpty() throws FileNotFoundException {
        String file = "src/main/resources/custom_file_reader/emptyFileForTests.txt";
        new CustomFileReader(file).run2();
        assertEquals("", getOutput());
    }

    @Test
    public void givenFileDotsCommasOnly_whenRun2_thenEmpty() throws FileNotFoundException {
        String file = "src/main/resources/custom_file_reader/fileDotsCommasOnly.txt";
        new CustomFileReader(file).run2();
        assertEquals("", getOutput());
    }

    @Test
    public void givenTextFile_whenRun2_thenNewText() throws FileNotFoundException {
        String file = "src/main/resources/custom_file_reader/fileTest.txt";
        new CustomFileReader(file).run2();
        assertEquals("dfgdfgdgdgdfggdfgdfgfdgdfgfgfdgdfgdfgdfgdfg", getOutput());
    }

    @Test()
    public void givenWrongFile_whenRun3_thenException() {
        Path path = Paths.get("src/main/resources/custom_file_reader/fhfghfghfgh.txt");
        ;
        Assertions.assertThrows(IOException.class, () -> {
            new CustomFileReader(path).run3();
        });
    }

    @Test
    public void givenEmptyFile_whenRun3_thenEmpty() throws IOException {
        Path path = Paths.get("src/main/resources/custom_file_reader/emptyFileForTests.txt");
        ;
        new CustomFileReader(path).run3();
        assertEquals("", getOutput());
    }

    @Test
    public void givenFileDotsCommasOnly_whenRun3_thenEmpty() throws IOException {
        Path path = Paths.get("src/main/resources/custom_file_reader/fileDotsCommasOnly.txt");
        ;
        new CustomFileReader(path).run3();
        assertEquals("", getOutput());
    }

    @Test
    public void givenTextFile_whenRun3_thenNewText() throws IOException {
        Path path = Paths.get("src/main/resources/custom_file_reader/fileTest.txt");
        ;
        new CustomFileReader(path).run3();
        assertEquals("dfgdfgdgdgdfggdfgdfgfdgdfgfgfdgdfgdfgdfgdfg", getOutput());
    }

    @Test()
    public void givenWrongFile_whenRun4_thenException() {
        Path path = Paths.get("src/main/resources/custom_file_reader/fhfghfghfgh.txt");
        ;
        Assertions.assertThrows(IOException.class, () -> {
            new CustomFileReader(path).run4();
        });
    }

    @Test
    public void givenEmptyFile_whenRun4_thenEmpty() throws IOException {
        Path path = Paths.get("src/main/resources/custom_file_reader/emptyFileForTests.txt");
        ;
        new CustomFileReader(path).run4();
        assertEquals("", getOutput());
    }

    @Test
    public void givenFileDotsCommasOnly_whenRun4_thenEmpty() throws IOException {
        Path path = Paths.get("src/main/resources/custom_file_reader/fileDotsCommasOnly.txt");
        ;
        new CustomFileReader(path).run4();
        assertEquals("", getOutput());
    }

    @Test
    public void givenTextFile_whenRun4_thenNewText() throws IOException {
        Path path = Paths.get("src/main/resources/custom_file_reader/fileTest.txt");
        ;
        new CustomFileReader(path).run4();
        assertEquals("dfgdfgdgdgdfggdfgdfgfdgdfgfgfdgdfgdfgdfgdfg", getOutput());
    }

    @Test()
    public void givenWrongFile_whenRun5_thenException() {
        String file = "src/main/resources/custom_file_reader/djfhghdjfg.txt";
        Assertions.assertThrows(IOException.class, () -> {
            new CustomFileReader(file).run5();
        });
    }

    @Test
    public void givenEmptyFile_whenRun5_thenEmpty() throws IOException {
        String file = "src/main/resources/custom_file_reader/emptyFileForTests.txt";
        new CustomFileReader(file).run5();
        assertEquals("", getOutput());
    }

    @Test
    public void givenFileDotsCommasOnly_whenRun5_thenEmpty() throws IOException {
        String file = "src/main/resources/custom_file_reader/fileDotsCommasOnly.txt";
        new CustomFileReader(file).run5();
        assertEquals("", getOutput());
    }

    @Test
    public void givenTextFile_whenRun5_thenNewText() throws IOException {
        String file = "src/main/resources/custom_file_reader/fileTest.txt";
        new CustomFileReader(file).run5();
        assertEquals("dfgdfgdgdgdfggdfgdfgfdgdfgfgfdgdfgdfgdfgdfg", getOutput());
    }

}
