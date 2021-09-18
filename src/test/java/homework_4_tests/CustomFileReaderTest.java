package homework_4_tests;

import base.UnitBase;
import homework_4.custom_file_reader.CustomFileReader;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomFileReaderTest extends UnitBase {

    private static final String INPUT_FILE = "src/main/resources/custom_file_reader/output.txt";

    @Test
    void run1Test() {
        new CustomFileReader().run1();

        try (BufferedReader buffer = new BufferedReader(new FileReader(INPUT_FILE))) {
            String expect =  buffer.lines().collect(Collectors.joining("\r\n"));
            assertEquals(expect, getOutput());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void run1TestByNio() {
        new CustomFileReader().run1();

        checkOutput();
    }

    @Test
    void run2TestByNio() {
        new CustomFileReader().run2();

        checkOutput();
    }

    @Test
    void run3TestByNio() {
        new CustomFileReader().run3();

        checkOutput();
    }

    private void checkOutput() {
        Path path = Paths.get(INPUT_FILE);
        List<String> list;
        try {
            list = Files.readAllLines(path);
            String expect = list.stream()
                    .map(s -> s.replaceAll("[,.]", ""))
                    .collect(Collectors.joining("\r\n"));

            assertEquals(expect, getOutput());
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }
}
