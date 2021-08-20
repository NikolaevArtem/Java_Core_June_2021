package homework_4.custom_file_reader;

import base.UnitBaseFileMode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CustomFileReaderTest extends UnitBaseFileMode {

    @AfterEach
    void delTempFile() {
        deleteTempFile("./src/main/resources/custom_file_reader/tempFile.txt");
    }

    @ParameterizedTest
    @MethodSource("testValidValue")
    void givenContent_whenRun1_thenExpected(String filePath, String content, String expected) {
        createAndFillTempFile(filePath, content);
        new CustomFileReader(filePath).run1();

        assertEquals(expected, getOutput());
    }

    @ParameterizedTest
    @MethodSource("testEmpty")
    void givenContent_whenRun1_thenEmpty(String filePath, String content) {
        createAndFillTempFile(filePath, content);
        new CustomFileReader(filePath).run1();

        assertEquals("", getOutput());
    }

    @ParameterizedTest
    @MethodSource("testFileNotFound")
    void givenWrongFileName_whenRun1_thenFileNotFound(String filePath, String content) {
        createAndFillTempFile("./src/main/resources/custom_file_reader/tempFile.txt", content);
        new CustomFileReader(filePath).run1();

        assertEquals("File not found in path", getOutput());
    }

    @ParameterizedTest
    @MethodSource("testValidValue")
    void givenContent_whenRun2_thenExpected(String filePath, String content, String expected) {
        createAndFillTempFile(filePath, content);
        new CustomFileReader(filePath).run2();

        assertEquals(expected, getOutput());
    }

    @ParameterizedTest
    @MethodSource("testEmpty")
    void givenContent_whenRun2_thenEmpty(String filePath, String content) {
        createAndFillTempFile(filePath, content);
        new CustomFileReader(filePath).run2();

        assertEquals("", getOutput());
    }

    @ParameterizedTest
    @MethodSource("testFileNotFound")
    void givenWrongFileName_whenRun2_thenFileNotFound(String filePath, String content) {
        createAndFillTempFile("./src/main/resources/custom_file_reader/tempFile.txt", content);
        new CustomFileReader(filePath).run2();

        assertEquals("File not found in path", getOutput());
    }


    @ParameterizedTest
    @MethodSource("testValidValue")
    void givenContent_whenRun3_thenExpected(String filePath, String content, String expected) {
        createAndFillTempFile(filePath, content);
        new CustomFileReader(filePath).run3();

        assertEquals(expected, getOutput());
    }

    @ParameterizedTest
    @MethodSource("testEmpty")
    void givenContent_whenRun3_thenEmpty(String filePath, String content) {
        createAndFillTempFile(filePath, content);
        new CustomFileReader(filePath).run3();

        assertEquals("", getOutput());
    }

    @ParameterizedTest
    @MethodSource("testFileNotFound")
    void givenWrongFileName_whenRun3_thenFileNotFound(String filePath, String content) {
        createAndFillTempFile("./src/main/resources/custom_file_reader/tempFile.txt", content);
        new CustomFileReader(filePath).run3();

        assertEquals("File not found in path", getOutput());
    }


    @ParameterizedTest
    @MethodSource("testValidValue")
    void givenContent_whenRun4_thenExpected(String filePath, String content, String expected) {
        createAndFillTempFile(filePath, content);
        new CustomFileReader(filePath).run4();

        assertEquals(expected, getOutput());
    }

    @ParameterizedTest
    @MethodSource("testEmpty")
    void givenContent_whenRun4_thenEmpty(String filePath, String content) {
        createAndFillTempFile(filePath, content);
        new CustomFileReader(filePath).run4();

        assertEquals("", getOutput());
    }

    @ParameterizedTest
    @MethodSource("testFileNotFound")
    void givenWrongFileName_whenRun4_thenFileNotFound(String filePath, String content) {
        createAndFillTempFile("./src/main/resources/custom_file_reader/tempFile.txt", content);
        new CustomFileReader(filePath).run4();

        assertEquals("File not found in path", getOutput());
    }

    @ParameterizedTest
    @MethodSource("testValidValue")
    void givenContent_whenRun5_thenExpected(String filePath, String content, String expected) {
        createAndFillTempFile(filePath, content);
        new CustomFileReader(filePath).run5();

        assertEquals(expected, getOutput());
    }

    @ParameterizedTest
    @MethodSource("testEmpty")
    void givenContent_whenRun5_thenEmpty(String filePath, String content) {
        createAndFillTempFile(filePath, content);
        new CustomFileReader(filePath).run5();

        assertEquals("", getOutput());
    }

    @ParameterizedTest
    @MethodSource("testFileNotFound")
    void givenWrongFileName_whenRun5_thenFileNotFound(String filePath, String content) {
        createAndFillTempFile("./src/main/resources/custom_file_reader/tempFile.txt", content);
        new CustomFileReader(filePath).run5();

        assertEquals("File not found in path", getOutput());
    }

    private static Stream<Arguments> testFileNotFound() {
        return Stream.of(
                Arguments.of("/src/main/resources/custom_file_reader/file.txt", "1,2,3,4,5,6,7,\n8,9."),
                Arguments.of("./sr/main/resources/custom_file_reader/file.txt", "..1,,"),
                Arguments.of("./src/mai/resources/custom_file_reader/file.txt", "zxc01"),
                Arguments.of("./src/main/resource/custom_file_reader/file.txt", "1! abcdefg"),
                Arguments.of("./src/main/resources/custom_filereader/file.txt", "1!. qwerty, abcdefg."),
                Arguments.of("./src/main/resources/custom_file_reader/testFiletxt", "1!. qwerty,\n abcdefg.")
        );
    }

    private static Stream<Arguments> testEmpty() {
        return Stream.of(
                Arguments.of("./src/main/resources/custom_file_reader/tempFile.txt", ""),
                Arguments.of("./src/main/resources/custom_file_reader/tempFile.txt", ".."),
                Arguments.of("./src/main/resources/custom_file_reader/tempFile.txt", ",,"),
                Arguments.of("./src/main/resources/custom_file_reader/tempFile.txt", "..,,"),
                Arguments.of("./src/main/resources/custom_file_reader/tempFile.txt", "..,,")
        );
    }

    private static Stream<Arguments> testValidValue() {
        return Stream.of(
                Arguments.of("./src/main/resources/custom_file_reader/tempFile.txt", "1,2,3,4,5,6,7,\n8,9.", "1234567\n89"),
                Arguments.of("./src/main/resources/custom_file_reader/tempFile.txt", "zxc01", "zxc01"),
                Arguments.of("./src/main/resources/custom_file_reader/tempFile.txt", "1! abcdefg", "1! abcdefg"),
                Arguments.of("./src/main/resources/custom_file_reader/tempFile.txt", "1!. qwerty, abcdefg.", "1! qwerty abcdefg")
        );
    }

}