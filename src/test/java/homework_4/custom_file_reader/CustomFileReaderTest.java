package homework_4.custom_file_reader;

import base.UnitBase;
import homework_4.custom_annotation.Planet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomFileReaderTest extends UnitBase {
    private CustomFileReader customFileReader = new CustomFileReader();

    //run1
    @Test
    void givenFileWithoutCommansAndDots_whenrunRun1_thenPrintCorrectly(){
        customFileReader.myPath("src/test/java/homework_4/custom_file_reader/withoutCommasAndDots.txt");

        customFileReader.run1();

        assertEquals("Hello", getOutputLines()[0]);
        assertEquals("Hi", getOutputLines()[1]);

    }

    @Test
    void givenFileWithCommansAndDots_whenrunRun1_thenPrintCorrectly(){
        customFileReader.myPath("src/test/java/homework_4/custom_file_reader/withCommasAndDots.txt");

        customFileReader.run1();

        assertEquals("Hello", getOutputLines()[0]);
        assertEquals("Hi", getOutputLines()[1]);

    }

    @Test
    void givenFileOnlyCommansAndDots_whenrunRun1_thenPrintNothing(){
        customFileReader.myPath("src/test/java/homework_4/custom_file_reader/onlyCommasAndDots");

        customFileReader.run1();

        assertEquals("", getOutputLines()[0]);

    }

    @Test
    void givenCleanFile_whenrunRun1_thenPrintNothing(){
        customFileReader.myPath("src/test/java/homework_4/custom_file_reader/cleanFile.txt");

        customFileReader.run1();

        assertEquals("", getOutputLines()[0]);

    }

    //Run2
    @Test
    void givenFileWithoutCommansAndDots_whenrunRun2_thenPrintCorrectly(){
        customFileReader.myPath("src/test/java/homework_4/custom_file_reader/withoutCommasAndDots.txt");

        customFileReader.run1();

        assertEquals("Hello", getOutputLines()[0]);
        assertEquals("Hi", getOutputLines()[1]);

    }

    @Test
    void givenFileWithCommansAndDots_whenrunRun2_thenPrintCorrectly(){
        customFileReader.myPath("src/test/java/homework_4/custom_file_reader/withCommasAndDots.txt");

        customFileReader.run1();

        assertEquals("Hello", getOutputLines()[0]);
        assertEquals("Hi", getOutputLines()[1]);

    }

    @Test
    void givenFileOnlyCommansAndDots_whenrunRun2_thenPrintNothing(){
        customFileReader.myPath("src/test/java/homework_4/custom_file_reader/onlyCommasAndDots");

        customFileReader.run1();

        assertEquals("", getOutputLines()[0]);

    }

    @Test
    void givenCleanFile_whenrunRun2_thenPrintNothing(){
        customFileReader.myPath("src/test/java/homework_4/custom_file_reader/cleanFile.txt");

        customFileReader.run1();

        assertEquals("", getOutputLines()[0]);

    }

    //Run3
    @Test
    void givenFileWithoutCommansAndDots_whenrunRun3_thenPrintCorrectly(){
        customFileReader.myPath("src/test/java/homework_4/custom_file_reader/withoutCommasAndDots.txt");

        customFileReader.run1();

        assertEquals("Hello", getOutputLines()[0]);
        assertEquals("Hi", getOutputLines()[1]);

    }

    @Test
    void givenFileWithCommansAndDots_whenrunRun3_thenPrintCorrectly(){
        customFileReader.myPath("src/test/java/homework_4/custom_file_reader/withCommasAndDots.txt");

        customFileReader.run1();

        assertEquals("Hello", getOutputLines()[0]);
        assertEquals("Hi", getOutputLines()[1]);

    }

    @Test
    void givenFileOnlyCommansAndDots_whenrunRun3_thenPrintNothing(){
        customFileReader.myPath("src/test/java/homework_4/custom_file_reader/onlyCommasAndDots");

        customFileReader.run1();

        assertEquals("", getOutputLines()[0]);

    }

    @Test
    void givenCleanFile_whenrunRun3_thenPrintNothing(){
        customFileReader.myPath("src/test/java/homework_4/custom_file_reader/cleanFile.txt");

        customFileReader.run1();

        assertEquals("", getOutputLines()[0]);

    }
}
