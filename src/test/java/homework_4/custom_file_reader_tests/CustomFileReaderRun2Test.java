package homework_4.custom_file_reader_tests;

import base.UnitBase;
import homework_4.custom_file_reader.CustomFileReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomFileReaderRun2Test extends UnitBase {
    private final String pathToResources = "src/test/resources/";
    private CustomFileReader customFileReader;

    @BeforeEach
    void setCustomFileReader() {
        customFileReader = new CustomFileReader();
        customFileReader.setPathToResources(pathToResources);
    }

    @Test
    void givenOKFile_whenRunBufferedReader_thenPrintCorrectly() {
        customFileReader.setFileName("custom_file_reader/custom_file_reader_OK.txt");
        customFileReader.run2();

        String[] actual1 = getOutputLines();

        assertEquals("string with commas and dots", actual1[0]);
        assertEquals("another string with commas and dots", actual1[1]);
    }

    @Test
    void givenFileWithoutCommasAndDots_whenRunBufferedReader_thenPrintCorrectly() {
        customFileReader.setFileName("custom_file_reader/custom_file_reader_without_commas_and_dots.txt");
        customFileReader.run2();

        String[] actual = getOutputLines();

        assertEquals("file without commas and dots", actual[0]);
        assertEquals("another line of file without commas and dots", actual[1]);
    }

    @Test
    void givenFileWithOnlyCommasAndDots_whenRunBufferedReader_thenPrintCorrectly() {
        customFileReader.setFileName("custom_file_reader/custom_file_commas_and_dots_only.txt");
        customFileReader.run2();

        String[] actual = getOutputLines();

        assertEquals("", actual[0]);
    }

    @Test
    void givenEmptyFile_whenRunBufferedReader_thenPrintCorrectly() {
        customFileReader.setFileName("custom_file_reader/custom_file_reader_empty.txt");
        customFileReader.run2();

        String[] actual = getOutputLines();

        assertEquals("", actual[0]);
    }

    @Test
    void givenNonExistentFile_whenRunBufferedReader_thenPrintCorrectly() {
        customFileReader.setFileName("custom_file_reader/custom_file_reader_not_exist.txt");
        customFileReader.run2();

        String[] actual = getOutputLines();

        assertEquals("File not found", actual[0]);
    }
}
