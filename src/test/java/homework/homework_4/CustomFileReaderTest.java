package homework.homework_4;

import homework.homework_1.UnitBase;
import homework_4.custom_file_reader.CustomFileReader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomFileReaderTest extends UnitBase {

    @Test
    public void givenRunAllThree_whenRun_thenResultsAreTheSame() {
        new CustomFileReader().run1();
        new CustomFileReader().run2();
        new CustomFileReader().run3();

        String[] resultStrings = getOutputLines();
        String resultAfterRun1 = resultStrings[0];
        String resultAfterRun2 = resultStrings[1];
        String resultAfterRun3 = resultStrings[2];

        assertEquals(resultAfterRun1, resultAfterRun2);
        assertEquals(resultAfterRun1, resultAfterRun3);
    }

    @Test
    public void givenRun1_whenRun_thenOutputDoesntContainsComasAndDots() {
        new CustomFileReader().run1();

        String[] resultStrings = getOutputLines();
        String result = resultStrings[0];

        assertFalse(result.contains("(\\.)|(,)"));
    }

    @Test
    public void givenRun2_whenRun_thenOutputDoesntContainsComasAndDots() {
        new CustomFileReader().run2();

        String[] resultStrings = getOutputLines();
        String result = resultStrings[0];

        assertFalse(result.contains("(\\.)|(,)"));
    }

    @Test
    public void givenRun3_whenRun_thenOutputDoesntContainsComasAndDots() {
        new CustomFileReader().run3();

        String[] resultStrings = getOutputLines();
        String result = resultStrings[0];

        assertFalse(result.contains("(\\.)|(,)"));
    }

}
