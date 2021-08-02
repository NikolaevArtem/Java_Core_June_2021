package homework.homework_2.random_chars_table;

import base.UnitBase;
import homework_2.random_chars_table.RandomCharsTable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RandomCharsTableTest extends UnitBase {
    final String ERR_MSG = "Passed parameters should match the format [positive integer] [positive integer] [even|odd]";
    // tested cases : correct odd
    //                correct even
    //                one arg
    //                two args
    //                three args, wrong method string
    //                empty input
    //                more than 3 args
    //                three args, wrong order
    //                0 0 odd table
    // 10             0 0 even table


    @Test
    public void givenCorrectInputOddMethod_whenRun_thenAllGood() {
        setInput("4 4 odd");
        boolean isOddInOutput;
        boolean areCharsOdd = false;
        String expected = "Odd letters - ";

        new RandomCharsTable().run();
        removeFromOutput("Enter two Integers and sorting method, even or odd, e.g.  12 12 odd");
        removeFromOutput("There is an unsorted table:");
        String[] inOutput = getOutputLines();

        for (String str : inOutput
        ) {
            if (str.contains("|")) {
                removeFromOutput(str);
            }
        }

        String[] rest = getOutputLines();
        String restedString = rest[0];
        String beginning = restedString.substring(0, 14);
        isOddInOutput = expected.equals(beginning);

        String restedChars = restedString.substring(14);
        restedChars.replaceAll("\\p{P}", "");
        char[] charsRest = restedChars.toCharArray();
        for (char ch : charsRest
        ) {
            areCharsOdd = (ch / 2) != 0;
        }
        assertTrue(isOddInOutput && areCharsOdd);
    }

    @Test
    public void givenCorrectInputEvenMethod_whenRun_thenAllGood() {
        setInput("4 4 even");
        boolean isEvenInOutput;
        boolean areCharsEven = false;
        String expected = "Even letters - ";

        new RandomCharsTable().run();
        removeFromOutput("Enter two Integers and sorting method, even or odd, e.g.  12 12 odd");
        removeFromOutput("There is an unsorted table:");
        String[] inOutput = getOutputLines();

        for (String str : inOutput
        ) {
            if (str.contains("|")) {
                removeFromOutput(str);
            }
        }

        String[] rest = getOutputLines();
        String restedString = rest[0];
        String beginning = restedString.substring(0, 15);
        isEvenInOutput = expected.equals(beginning);

        String restedChars = restedString.substring(15);
        restedChars.replaceAll("\\p{P}", "");
        char[] charsRest = restedChars.toCharArray();
        for (char ch : charsRest
        ) {
            areCharsEven = (ch % 2) == 0;
        }
        assertTrue(isEvenInOutput && areCharsEven);
    }

    @Test
    void givenOneArgument_whenRun_thenErrorOccurs() {
        setInput("4");
        new RandomCharsTable().run();
        removeFromOutput("Enter two Integers and sorting method, even or odd, e.g.  12 12 odd");
        String inOutput = getOutput();

        assertEquals(ERR_MSG, inOutput);
    }

    @Test
    void givenTwoArguments_whenRun_thenErrorOccurs() {
        setInput("4 4");
        new RandomCharsTable().run();
        removeFromOutput("Enter two Integers and sorting method, even or odd, e.g.  12 12 odd");
        String inOutput = getOutput();

        assertEquals(ERR_MSG, inOutput);
    }

    @Test
    void givenThreeArgsMethodIsWrong_whenRun_thenErrorOccurs() {
        setInput("4 4 string");
        new RandomCharsTable().run();
        removeFromOutput("Enter two Integers and sorting method, even or odd, e.g.  12 12 odd");
        String inOutput = getOutput();

        assertEquals(ERR_MSG, inOutput);
    }

    @Test
    void givenEmptyInput_whenRun_thenErrorOccurs() {
        setInput("");
        removeFromOutput("Enter two Integers and sorting method, even or odd, e.g.  12 12 odd");
        String inOutput = getOutput();

        assertThrows(NullPointerException.class, () ->
                new RandomCharsTable().run());
    }

    @Test
    void givenMoreThenThreeArgs_whenRun_thenErrorOccurs() {
        setInput("4 4 odd string");
        new RandomCharsTable().run();
        removeFromOutput("Enter two Integers and sorting method, even or odd, e.g.  12 12 odd");
        String inOutput = getOutput();

        assertEquals(ERR_MSG, inOutput);
    }

    @Test
    void givenThreeArgsOrderIsWrong_whenRun_thenErrorOccurs() {
        setInput("4 odd 4");
        new RandomCharsTable().run();
        removeFromOutput("Enter two Integers and sorting method, even or odd, e.g.  12 12 odd");
        String inOutput = getOutput();

        assertEquals(ERR_MSG, inOutput);
    }

    @Test
    public void givenZeroZeroOddMethod_whenRun_thenAllGood() {
        setInput("0 0 odd");
        String expected = "Table is empty";

        new RandomCharsTable().run();
        removeFromOutput("Enter two Integers and sorting method, even or odd, e.g.  12 12 odd");

        assertEquals(expected, getOutput());
    }

    @Test
    public void givenZeroZeroEvenMethod_whenRun_thenAllGood() {
        setInput("0 0 even");
        String expected = "Table is empty";

        new RandomCharsTable().run();
        removeFromOutput("Enter two Integers and sorting method, even or odd, e.g.  12 12 odd");

        assertEquals(expected, getOutput());
    }

}