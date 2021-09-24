package homework_4;

import base.UnitBase;
import homework_4.custom_file_reader.CustomFileReader;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class CustomFileReaderTest extends UnitBase {

    private boolean checkResult(String res) {
        return !(res.contains(".") && res.contains(","));
    }
    @Test
    public void givenTextWhenRun1ThenExpected() {
        new CustomFileReader().run1();
        String text = getOutput();
        assertTrue(checkResult(text));
    }
    @Test
    public void givenTextWhenRun2ThenExpected() {
        new CustomFileReader().run2();
        String text = getOutput();
        assertTrue(checkResult(text));
    }
    @Test
    public void givenTextWhenRun3ThenExpected() {
        new CustomFileReader().run3();
        String text = getOutput();
        assertTrue(checkResult(text));
    }

}
