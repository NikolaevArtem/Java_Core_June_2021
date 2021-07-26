package homework_2.random_chars_table;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomCharsTableTest extends UnitBase {

    @Test
    void Empty_Input_Error() {
        setInput("");

        new RandomCharsTable().run();
        printOut();

        assertEquals("Error: args is null", getOutputLines()[0]);
    }


    @Test
    void Int1_Input_Error() {
        setInput("1");

        new RandomCharsTable().run();
        printOut();

        assertEquals("Error: less when 3 args", getOutputLines()[0]);
    }

    @Test
    void Int1and1_Input_Error() {
        setInput("1 1");

        new RandomCharsTable().run();
        printOut();

        assertEquals("Error: less when 3 args", getOutputLines()[0]);
    }

    @Test
    void Int1and0andEven_Input_Error() {
        setInput("1 0 even");

        new RandomCharsTable().run();
        printOut();

        assertEquals("No even letters", getOutputLines()[0]);
    }


    @Test
    void Int2and2andEven_Input_Result() {
        setInput("2 2 even");

        new RandomCharsTable().run();
        printOut();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < 2; i++) {
            for (int j  = 0; j < getOutputLines()[i].length();j++) {
                char c = getOutputLines()[i].charAt(j);
                int num = (int) c;
                if (num >= 65 && num <= 91) {
                    if (num % 2 == 0) {
                        result.append(c + ", ");
                    }
                }
            }
        }

        String strRes = result.toString();
        strRes = "Even letters - " + strRes.substring(0,strRes.length()-2);
        assertEquals(strRes, getOutputLines()[3]);
    }

    @Test
    void Int2and2andOdd_Input_Result() {
        setInput("2 2 odd");

        new RandomCharsTable().run();
        printOut();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < 2; i++) {
            for (int j  = 0; j < getOutputLines()[i].length();j++) {
                char c = getOutputLines()[i].charAt(j);
                int num = (int) c;
                if (num >= 65 && num <= 91) {
                    if (num % 2 == 1) {
                        result.append(c + ", ");
                    }
                }
            }
        }

        String strRes = result.toString();
        strRes = "Odd letters - " + strRes.substring(0,strRes.length()-2);
        assertEquals(strRes, getOutputLines()[3]);
    }
}
