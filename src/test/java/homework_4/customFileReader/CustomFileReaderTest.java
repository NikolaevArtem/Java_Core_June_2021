package homework_4.customFileReader;

import base.UnitBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.*;
import java.nio.file.Path;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class CustomFileReaderTest extends UnitBase {

    File file;

    @BeforeEach
    public void setUp(@TempDir Path tempDir) {
        this.file = new File ((tempDir.resolve ("textFile.txt")).toString ());
    }

    public void writeToFile(String text) {
        try (BufferedWriter bw1 = new BufferedWriter (new FileWriter (file))) {
            bw1.write (text);
        } catch (IOException e) {
            System.err.println ("Error message ");
        }
    }

    public static Stream<Arguments> testCasesInOneRow() {
        return Stream.of (
                Arguments.of ("test,.test", "testtest"),
                Arguments.of (",", ""),
                Arguments.of (".", ""),
                Arguments.of ("", ""),
                Arguments.of (",....asd,. asd", "asd asd")
        );
    }


    @ParameterizedTest
    @MethodSource("testCasesInOneRow")
    void testRun1InputInOneRow(String in, String expected) {
        writeToFile (in);
        CustomFileReader fileReader = new CustomFileReader (file.getPath ());
        fileReader.run1 ();
        printOut ();

        assertEquals (expected, getOutputLines ()[0]);
    }

    @ParameterizedTest
    @MethodSource("testCasesInOneRow")
    void testRun2InputInOneRow(String in, String expected) {
        writeToFile (in);
        CustomFileReader fileReader = new CustomFileReader (file.getPath ());
        fileReader.run2 ();
        printOut ();

        assertEquals (expected, getOutputLines ()[0]);
    }

    @ParameterizedTest
    @MethodSource("testCasesInOneRow")
    void testRun3InputInOneRow(String in, String expected) {
        writeToFile (in);
        CustomFileReader fileReader = new CustomFileReader (file.getPath ());
        fileReader.run3 ();
        printOut ();

        assertEquals (expected, getOutputLines ()[0]);
    }

    //getOutPut using trim(), so it's remove "\n" too
    public static Stream<Arguments> testCasesInTwoRows() {
        return Stream.of (
                Arguments.of ("te\nst,.test", "te\nsttest"),
                Arguments.of ("\n,", ""),
                Arguments.of ("\n.\n..", ""),
                Arguments.of ("\n\n", ""),
                Arguments.of (",\n...\n.asd,. \nasd", "asd \nasd")
        );
    }

    @ParameterizedTest
    @MethodSource("testCasesInTwoRows")
    void testRun1InputInTwoRow(String in, String expected) {
        writeToFile (in);
        CustomFileReader fileReader = new CustomFileReader (file.getPath ());
        fileReader.run1 ();
        printOut ();

        assertEquals (expected, getOutput ());
    }

    @ParameterizedTest
    @MethodSource("testCasesInTwoRows")
    void testRun2InputInTwoRow(String in, String expected) {
        writeToFile (in);
        CustomFileReader fileReader = new CustomFileReader (file.getPath ());
        fileReader.run2 ();
        printOut ();

        assertEquals (expected, getOutput ());
    }

    @ParameterizedTest
    @MethodSource("testCasesInTwoRows")
    void testRun3InputInTwoRow(String in, String expected) {
        writeToFile (in);
        CustomFileReader fileReader = new CustomFileReader (file.getPath ());
        fileReader.run3 ();
        printOut ();

        assertEquals (expected, getOutput ());
    }

    @Test
    void testRun1FileNotFound() {

        CustomFileReader fileReader = new CustomFileReader ("");
        fileReader.run1 ();
        String expectedMessage = "(No such file or directory)";
        assertTrue(getOutput ().contains(expectedMessage));
    }

    @Test
    void testRun2FileNotFound() {
        CustomFileReader fileReader = new CustomFileReader ("");
        fileReader.run2 ();
        String expectedMessage = "(No such file or directory)";
        assertTrue(getOutput ().contains(expectedMessage));
    }

    @Test
    void testRun3FileNotFound() {
        CustomFileReader fileReader = new CustomFileReader ("");
        fileReader.run3 ();
        String expectedMessage = "Internal Error";
        assertTrue(getOutput ().contains (expectedMessage));
    }
}
