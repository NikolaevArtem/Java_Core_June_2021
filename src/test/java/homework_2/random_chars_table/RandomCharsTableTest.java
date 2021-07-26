package homework_2.random_chars_table;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomCharsTableTest extends UnitBase {

    @Test
    void givenEmpty_whenRun_thenError() {
        setInput("");

        new RandomCharsTable().run();
        printOut();

        assertEquals("Error: args is null", getOutputLines()[0]);
    }


    @Test
    void given_1_whenRun_thenError() {
        setInput("1");

        new RandomCharsTable().run();
        printOut();

        assertEquals("Error: less when 3 args", getOutputLines()[0]);
    }

    @Test
    void given_1_1_whenRun_thenError() {
        setInput("1 1");

        new RandomCharsTable().run();
        printOut();

        assertEquals("Error: less when 3 args", getOutputLines()[0]);
    }

    @Test
    void given_0_1_ven_whenRun_thenError() {
        setInput("0 1 ven");

        new RandomCharsTable().run();
        printOut();

        assertEquals("Error: third arg must be even or odd now <ven>", getOutputLines()[0]);
    }


    @Test
    void givenString_whenRun_thenError() {
        setInput("s s s");

        new RandomCharsTable().run();
        printOut();

        assertEquals("Error: first and second args must be integer", getOutputLines()[0]);
    }

    @Test
    void given_0_1_even_whenRun_thenEmpty() {
        setInput("0 1 even");

        new RandomCharsTable().run();
        printOut();

        assertEquals("No even letters", getOutputLines()[0]);
    }


    @Test
    void given_1_0_whenRun_thenEmpty() {
        setInput("1 0 even");

        new RandomCharsTable().run();
        printOut();

        assertEquals("No even letters", getOutputLines()[0]);
    }

    @Test
    void given_2_2_even_whenRun_thenResult() {
        givenlengthAndWidthAndIsEven_whenRun_thenResult(2,2, true);
    }

    @Test
    void given_2_2_odd_whenRun_thenResult() {
        givenlengthAndWidthAndIsEven_whenRun_thenResult(2,2, false);
    }

    @Test
    void given_4_5_odd_whenRun_thenResult() {
        givenlengthAndWidthAndIsEven_whenRun_thenResult(4,5, false);
    }

    @Test
    void given_4_5_even_whenRun_thenResult() {
        givenlengthAndWidthAndIsEven_whenRun_thenResult(4,5, true);
    }


    void givenlengthAndWidthAndIsEven_whenRun_thenResult (int width, int length, boolean isEven) {

        setInput(width + " " + length + (isEven ? " even" : " odd"));

        new RandomCharsTable().run();
        printOut();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < length; i++) {
            for (int j  = 0; j < getOutputLines()[i].length();j++) {
                char c = getOutputLines()[i].charAt(j);
                int num = (int) c;
                if (num >= 65 && num <= 91) {
                    if (num % 2 == (isEven ? 0 : 1)) {
                        result.append(c + ", ");
                    }
                }
            }
        }

        String strRes = result.toString();
        strRes = (isEven ? "Even" : "Odd") + " letters - " + strRes.substring(0,strRes.length()-2);
        if (length < 3) {
            assertEquals(strRes, getOutputLines()[length+1]);
        } else {
            assertEquals(strRes, getOutputLines()[length]);
        }
    }
}
