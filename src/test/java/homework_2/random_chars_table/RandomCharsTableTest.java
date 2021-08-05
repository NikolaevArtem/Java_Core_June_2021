package homework_2.random_chars_table;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomCharsTableTest extends UnitBase {

    @Test
    public void given3and3andOdd_whenRun_thenOddChars() {
        setInput("3 3 odd");
        String regexOddChars = "Odd chars: ([ACEGIKMOQSUWY] ?)+";
        new RandomCharsTable().run();
        removeFromOutput("Enter number of rows, number of columns and strategy:");
        String[] output = getOutputLines();
        assertTrue(output[output.length - 1].matches(regexOddChars));
    }

    @Test
    public void given3and3andEven_whenRun_thenEvenChars() {
        setInput("3 3 even");
        String regexEvenChars = "Even chars: ([BDFHJLNPRTVXZ] ?)+";
        new RandomCharsTable().run();
        removeFromOutput("Enter number of rows, number of columns and strategy:");
        String[] output = getOutputLines();
        assertTrue(output[output.length - 1].matches(regexEvenChars));
    }

    @Test
    public void given4and5andEven_whenRun_thenTable4and5() {
        setInput("4 5 even");
        new RandomCharsTable().run();
        removeFromOutput("Enter number of rows, number of columns and strategy:");
        String[] output = getOutputLines();
        assertEquals(5, countOfVerticalLines(output[1]) / 2);
        assertEquals(4, output.length - 1);
    }

    @Test
    public void givenNegativeNumber_whenRun_thenErrorMsg() {
        setInput("-4 5 even");
        new RandomCharsTable().run();
        removeFromOutput("Enter number of rows, number of columns and strategy:");
        assertEquals("Passed parameters should match the format [positive integer] [positive integer] [even|odd]", getOutputLines()[0]);
    }

    @Test
    public void givenWrongStrategy_whenRun_thenErrorMsg() {
        setInput("4 5 buka");
        new RandomCharsTable().run();
        removeFromOutput("Enter number of rows, number of columns and strategy:");
        String[] output = getOutputLines();
        assertEquals("Passed parameters should match the format [positive integer] [positive integer] [even|odd]", output[output.length - 1]);
    }

    @Test
    public void givenStringInsteadOfInt_whenRun_thenErrorMsg() {
        setInput("4 aaa even");
        new RandomCharsTable().run();
        removeFromOutput("Enter number of rows, number of columns and strategy:");
        assertEquals("Passed parameters should match the format [positive integer] [positive integer] [even|odd]", getOutputLines()[0]);
    }

    private int countOfVerticalLines(String str) {
        int i = 0;
        for (char a : str.toCharArray()) {
            if (a == '|') {
                i++;
            }
        }
        return i;
    }
}
