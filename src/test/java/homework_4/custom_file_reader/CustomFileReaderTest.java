package homework_4.custom_file_reader;

import base.UnitBase;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

class CustomFileReaderTest extends UnitBase {
    private static final String FILE_PATH = "src/main/resources/custom_file_reader/file_for_test.txt";

    @Test
    public void checkRun1() throws IOException {
        final String expectedContent = Files.readString(Path.of(FILE_PATH));

        CustomFileReader.run1();
        printOut();
        final String actualContent = getOutput();

        assertEquals(expectedContent, actualContent);
    }

    @Test
    public void checkRun2() throws IOException {
        final String expectedContent = Files.readString(Path.of(FILE_PATH));

        CustomFileReader.run2();
        printOut();
        final String actualContent = getOutput();

        assertEquals(expectedContent, actualContent);
    }

    @Test
    public void checkRun3() throws IOException {
        final String expectedContent = Files.readString(Path.of(FILE_PATH));

        CustomFileReader.run3();
        printOut();
        final String actualContent = getOutput();

        assertEquals(expectedContent, actualContent);
    }
}
