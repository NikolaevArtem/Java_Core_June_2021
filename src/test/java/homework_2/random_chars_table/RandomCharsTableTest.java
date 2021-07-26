package homework_2.random_chars_table;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomCharsTableTest extends UnitBase {

    @Test
    void empty_Input_Error() {
        setInput("");

        new RandomCharsTable().run();
        printOut();

        assertEquals("Error: args is null", getOutputLines()[0]);
    }


    @Test
    void int1_Input_Error() {
        setInput("1");

        new RandomCharsTable().run();
        printOut();

        assertEquals("Error: less when 3 args", getOutputLines()[0]);
    }

    @Test
    void int1And1_Input_Error() {
        setInput("1 1");

        new RandomCharsTable().run();
        printOut();

        assertEquals("Error: less when 3 args", getOutputLines()[0]);
    }

    @Test
    void int0And1AndString_Input_Error() {
        setInput("0 1 ven");

        new RandomCharsTable().run();
        printOut();

        assertEquals("Error: third arg must be even or odd now <ven>", getOutputLines()[0]);
    }


    @Test
    void stringAndStringAndString_Input_Error() {
        setInput("s s s");

        new RandomCharsTable().run();
        printOut();

        assertEquals("Error: first and second args must be integer", getOutputLines()[0]);
    }

    @Test
    void int0And1AndEven_Input_Error() {
        setInput("0 1 even");

        new RandomCharsTable().run();
        printOut();

        assertEquals("No even letters", getOutputLines()[0]);
    }


    @Test
    void int1And0AndEven_Input_Error() {
        setInput("1 0 even");

        new RandomCharsTable().run();
        printOut();

        assertEquals("No even letters", getOutputLines()[0]);
    }


    @Test
    void int2And2AndEven_Input_Result() {
        lengthAndWidthAndIsEven_Input_Result(2,2, true);
    }

    @Test
    void int2And2AndOdd_Input_Result() {
        lengthAndWidthAndIsEven_Input_Result(2,2, false);
    }

    @Test
    void int4And5AndOdd_Input_Result() {
        lengthAndWidthAndIsEven_Input_Result(4,5, false);
    }


    @Test
    void int4And5AndEven_Input_Result() {
        lengthAndWidthAndIsEven_Input_Result(4,5, true);
    }

    void lengthAndWidthAndIsEven_Input_Result (int width, int length, boolean isEven) {

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
