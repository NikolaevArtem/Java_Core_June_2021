package homework_4.custom_file_reader;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CustomFileReaderTest extends UnitBase {
    private static final String FILE_NAME = "src/main/resources/custom_file_reader/Shakespeare.txt";

    @Test
    void run1() {
        new CustomFileReader().run1();
        assertFalse(getOutput().contains("."));
        assertFalse(getOutput().contains(","));
        try {
            assertNotEquals(Files.readAllBytes(Paths.get(FILE_NAME)), getOutput().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void run2() {
        new CustomFileReader().run2();
        assertFalse(getOutput().contains("."));
        assertFalse(getOutput().contains(","));
        try {
            assertNotEquals(Files.readAllBytes(Paths.get(FILE_NAME)), getOutput().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void run3() {
        new CustomFileReader().run3();
        assertFalse(getOutput().contains("."));
        assertFalse(getOutput().contains(","));
        try {
            assertNotEquals(Files.readAllBytes(Paths.get(FILE_NAME)), getOutput().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
