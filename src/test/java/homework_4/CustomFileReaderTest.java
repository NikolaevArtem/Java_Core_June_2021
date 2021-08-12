package homework_4;

import homework_4.custom_file_reader.CustomFileReader;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class CustomFileReaderTest extends base.UnitBase {

    private final String fileName = "src/main/resources/custom_file_reader";
    CustomFileReader cfr = new CustomFileReader();

    public static Stream<Arguments> testCases() {
        return Stream.of(
                arguments("First test.\nHello, World...\n...last,, line.", "First test\nHello World\nlast line"),
                arguments("..2 test,\n:)/|,:;.", "2 test\n:)/|:;"),
                arguments("...", ""),
                arguments(",,,", ""),
                arguments("", "")
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void run1Test(String fileContent, String expected) throws IOException {
        try (PrintWriter pw = new PrintWriter(fileName)) {
            pw.print(fileContent);
        }

        cfr.run1();
        printOut();

        assertEquals(expected, getOutput());
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void run2Test(String fileContent, String expected) throws IOException {
        try (PrintWriter pw = new PrintWriter(fileName)) {
            pw.print(fileContent);
        }

        cfr.run2();
        printOut();

        assertEquals(expected, getOutput());
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void run3Test(String fileContent, String expected) throws IOException {
        try (PrintWriter pw = new PrintWriter(fileName)) {
            pw.print(fileContent);
        }

        cfr.run2();
        printOut();

        assertEquals(expected, getOutput());
    }

}
