package homework_2.random_chars_table;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import base.UnitBase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class RandomCharsTableTest extends UnitBase {

    final String WELCOME_MSG = "Enter parameters in following format: [positive integer] [positive integer] [even|odd]";
    final String ERR_MSG = "Passed parameters should match the format [positive integer] [positive integer] [even|odd]";

    @Test
    public void givenNull_whenRun_thenPrintErrMsg() {
        setInput("");

        RandomCharsTable.run();
        printOut();
        removeFromOutput(WELCOME_MSG);

        assertEquals(ERR_MSG, getOutputLines()[0]);
    }

    @Test
    public void givenString_whenRun_thenPrintErrMsg() {
        setInput("null");

        RandomCharsTable.run();
        printOut();
        removeFromOutput(WELCOME_MSG);

        assertEquals(ERR_MSG, getOutputLines()[0]);
    }

    @Test
    public void givenDoubles_whenRun_thenPrintErrMsg() {
        setInput("2.5 3 odd");

        RandomCharsTable.run();
        printOut();
        removeFromOutput(WELCOME_MSG);

        assertEquals(ERR_MSG, getOutputLines()[0]);
    }

    @Test
    public void givenNotEnoughArguments_whenRun_thenPrintErrMsg() {
        setInput("25 odd");

        RandomCharsTable.run();
        printOut();
        removeFromOutput(WELCOME_MSG);

        assertEquals(ERR_MSG, getOutputLines()[0]);
    }

    @Test
    public void givenTooManyArguments_whenRun_thenPrintErrMsg() {
        setInput("2 5 lol odd");

        RandomCharsTable.run();
        printOut();
        removeFromOutput(WELCOME_MSG);

        assertEquals(ERR_MSG, getOutputLines()[0]);
    }

    @Test
    public void givenWrongStrategy_whenRun_thenPrintErrMsg() {
        setInput("2 5 ewen");

        RandomCharsTable.run();
        printOut();
        removeFromOutput(WELCOME_MSG);

        assertEquals(ERR_MSG, getOutputLines()[0]);
    }

    @Test
    public void givenCorrectInputThreeFiveOdd_whenRun_thenPrintErrMsg() {
        String input = "3 5 odd";
        String strategy = input.split(" ")[2];

        setInput(input);
        RandomCharsTable.run();
        printOut();
        removeFromOutput(WELCOME_MSG);

        final String actualResult = getOutputLines()[3];
        removeFromOutput(actualResult);
        final String table = getOutput();

        StringBuilder letters = getLettersFromTable(table);
        StringBuilder expectedResult = getExpectedResult(letters,strategy);
        assertEquals(expectedResult.toString(), actualResult);
    }

    @Test
    public void givenCorrectInputThreeFiveEven_whenRun_thenPrintErrMsg() {
        String input = "3 5 even";
        String strategy = input.split(" ")[2];

        setInput(input);
        RandomCharsTable.run();
        printOut();
        removeFromOutput(WELCOME_MSG);

        final String actualResult = getOutputLines()[3];
        removeFromOutput(actualResult);
        final String table = getOutput();

        StringBuilder letters = getLettersFromTable(table);
        StringBuilder expectedResult = getExpectedResult(letters,strategy);
        assertEquals(expectedResult.toString(), actualResult);
    }


    public StringBuilder getLettersFromTable(String table) {
        Pattern pattern = Pattern.compile("[A-Z]");
        Matcher matcher = pattern.matcher(table);
        StringBuilder letters = new StringBuilder();
        while (matcher.find()) {
            letters.append(matcher.group(0));
        }
        return letters;
    }

    public StringBuilder getExpectedResult(StringBuilder letters, String strategy) {
        StringBuilder expectedResult = new StringBuilder();

        if (strategy.equals("even")) {
            expectedResult.append("Even letters - ");
            for (int i = 0; i < letters.length(); i++) {
                char ch = letters.charAt(i);
                if ((int) ch % 2 == 0) {
                    expectedResult.append(ch);
                    expectedResult.append(", ");
                }
            }
        } else {
            expectedResult.append("Odd letters - ");
            for (int i = 0; i < letters.length(); i++) {
                char ch = letters.charAt(i);
                if ((int) ch % 2 != 0) {
                    expectedResult.append(ch);
                    expectedResult.append(", ");
                }
            }
        }
        expectedResult = new StringBuilder(expectedResult.substring(0, expectedResult.length() - 2));
        return expectedResult;
    }
}
