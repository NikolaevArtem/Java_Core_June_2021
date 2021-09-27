package homework_4.custom_file_reader;

import base.UnitBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class CustomFileReaderTest extends UnitBase {
    private static final String FILE_PATH = "src/main/resources/custom_file_reader/File_for_CustomFileReader_Test.txt";
    Path path = Paths.get(FILE_PATH);
    CustomFileReader customFileReader = new CustomFileReader();


    @Test
    public void run1Test() {
        customFileReader.run1();
        try {
            Assertions.assertEquals(Files.readAllLines(path), Arrays.asList(getOutputLines()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void run2Test() {
        customFileReader.run2();
        try {
            Assertions.assertEquals(Files.readAllLines(path), Arrays.asList(getOutputLines()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void run3Test() {
        customFileReader.run3();
        try {
            Assertions.assertEquals(Files.readAllLines(path), Arrays.asList(getOutputLines()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
