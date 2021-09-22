package homework_4.custom_file_reader;

import base.UnitBase;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CustomFileReaderTest extends UnitBase {

    @Test
    public void givenSingleStringText_whenRun_thenPrintString() {
        String singleStringText = "test.txt";
        new CustomFileReader(singleStringText).run1();
        new CustomFileReader(singleStringText).run2();
        new CustomFileReader(singleStringText).run3();
        new CustomFileReader(singleStringText).run4();
        new CustomFileReader(singleStringText).run5();
        new CustomFileReader(singleStringText).run6();
        getOutputLines();
        assertEquals("expected", getOutputLines()[0]);
        assertEquals("expected", getOutputLines()[1]);
        assertEquals("expected", getOutputLines()[2]);
        assertEquals("expected", getOutputLines()[3]);
        assertEquals("expected", getOutputLines()[4]);
        assertEquals("expected", getOutputLines()[5]);
    }

    @Test
    public void givenWrongFileName_whenRun_thenPrintError() {
        String wrongFileName = "tests.txt";
        new CustomFileReader(wrongFileName).run1();
        new CustomFileReader(wrongFileName).run2();
        new CustomFileReader(wrongFileName).run3();
        new CustomFileReader(wrongFileName).run4();
        new CustomFileReader(wrongFileName).run5();
        new CustomFileReader(wrongFileName).run6();
        getOutputLines();
        assertEquals("File is not found", getOutputLines()[0]);
        assertEquals("File is not found", getOutputLines()[1]);
        assertEquals("File is not found", getOutputLines()[2]);
        assertEquals("File is not found", getOutputLines()[3]);
        assertEquals("IO Error", getOutputLines()[4]); //only IOException
        assertEquals("File is not found", getOutputLines()[5]); //only FileNotFoundException
    }

    @Test
    public void givenNullAsFileName_whenRun_thenDefaultFileText() {
        //you can change the number of the run method to run2(), run3(), and so on
        new CustomFileReader(null).run1();
        getOutputLines();
        assertTrue(getOutputLines()[0].contains("There is a text for tests and it contains"));
        assertTrue(getOutputLines()[1].contains("commas and dots but you can't see them"));
        assertFalse(getOutputLines()[5].contains("[,.\\w]")); //check middle string is empty
        assertTrue(getOutputLines()[8].contains("They were removed"));
    }

    @Test
    public void givenManyStringsFile_whenRun_thenPrintStrings() {
        String manyStringsText = "testLines.txt";
        new CustomFileReader(manyStringsText).run1();
        new CustomFileReader(manyStringsText).run2();
        new CustomFileReader(manyStringsText).run3();
        new CustomFileReader(manyStringsText).run4();
        new CustomFileReader(manyStringsText).run5();
        new CustomFileReader(manyStringsText).run6();
        getOutputLines();
        String[] actual = parseOutputLines(getOutputLines());
        assertEquals("JavaCore2021", actual[0]);
        assertEquals("JavaCore2021", actual[1]);
        assertEquals("JavaCore2021", actual[2]);
        assertEquals("JavaCore2021", actual[3]);
        assertEquals("JavaCore2021", actual[4]);
        assertEquals("JavaCore2021", actual[5]);
    }

    private String[] parseOutputLines(String[] output) {
        String actualAll = Arrays.toString(getOutputLines()).replaceAll("\\s|\\[|]|,", "");
        int length = "JavaCore2021".length();
        String[] actual = new String[output.length / length];
        int offset1 = 0;
        int offset2 = 0;
        for (int i = 0; i < actual.length; i++) {
            offset2 += length;
            actual[i] = actualAll.substring(offset1, offset2);
            offset1 += length;
        }
        return Arrays.copyOf(actual, actual.length);
    }

}
