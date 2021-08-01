package homework_2.random_chars_table;

import base.UnitBaseMode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RandomCharsTableTest extends UnitBaseMode {

    private final RandomCharsTable randomCharsTable = new RandomCharsTable();
    private final String METHOD_NAME = "run";
    private final String STRING_TO_DEL = "Enter width, height and parity";
    private List<Character> evenLettersArrayList;
    private List<Character> oddLettersArrayList;

    @BeforeEach
    void setUp() {
        evenLettersArrayList = Arrays.asList(new Character[]{66, 68, 70, 72, 74, 76, 78, 80, 82, 84, 86, 88, 90});
        oddLettersArrayList = Arrays.asList(new Character[]{65, 67, 69, 71, 73, 75, 77, 79, 81, 83, 85, 87, 89});
    }

    @Test
    void runTestValidArg() {
        setInput("2 1 even");

        run(randomCharsTable, METHOD_NAME, STRING_TO_DEL);
        printOut();

        assertTrue(isValidLetters(Arrays.copyOf(getOutputLines(), getOutputLines().length - 1), 1));
        assertTrue(isEvenLetters(getOutputLines()[getOutputLines().length - 1]));
        assertEquals(2 + 1, getOutputLines().length);
        assertTrue(getOutput().contains("even letters -"));
    }

    @Test
    void runTestValidArg2() {
        setInput("1 2 even");

        run(randomCharsTable, METHOD_NAME, STRING_TO_DEL);
        printOut();

        assertTrue(isValidLetters(Arrays.copyOf(getOutputLines(), getOutputLines().length - 1), 2));
        assertTrue(isEvenLetters(getOutputLines()[getOutputLines().length - 1]));
        assertEquals(2, getOutputLines().length);
        assertTrue(getOutput().contains("even letters -"));
    }

    @Test
    void runTestValidArg3() {
        setInput("2 3 even");

        run(randomCharsTable, METHOD_NAME, STRING_TO_DEL);
        printOut();

        assertTrue(isValidLetters(Arrays.copyOf(getOutputLines(), getOutputLines().length - 1), 3));
        assertTrue(isEvenLetters(getOutputLines()[getOutputLines().length - 1]));
        assertEquals(3, getOutputLines().length);
        assertTrue(getOutput().contains("even letters - "));
    }

    @Test
    void runTestValidArg4() {
        setInput("2 1 odd");

        run(randomCharsTable, METHOD_NAME, STRING_TO_DEL);
        printOut();

        assertTrue(isValidLetters(Arrays.copyOf(getOutputLines(), getOutputLines().length - 1), 1));
        assertTrue(isOddLetters(getOutputLines()[getOutputLines().length - 1]));
        assertEquals(3, getOutputLines().length);
        assertTrue(getOutput().contains("odd letters -"));
    }

    @Test
    void runTestValidArg5() {
        setInput("1 2 odd");

        run(randomCharsTable, METHOD_NAME, STRING_TO_DEL);
        printOut();

        assertTrue(isValidLetters(Arrays.copyOf(getOutputLines(), getOutputLines().length - 1), 2));
        assertTrue(isOddLetters(getOutputLines()[getOutputLines().length - 1]));
        assertEquals(2, getOutputLines().length);
        assertTrue(getOutput().contains("odd letters -"));
    }

    @Test
    void runTestValidArg6() {
        setInput("2 3 odd");

        run(randomCharsTable, METHOD_NAME, STRING_TO_DEL);
        printOut();

        assertTrue(isValidLetters(Arrays.copyOf(getOutputLines(), getOutputLines().length - 1), 3));
        assertTrue(isOddLetters(getOutputLines()[getOutputLines().length - 1]));
        assertEquals(3, getOutputLines().length);
        assertTrue(getOutput().contains("odd letters -"));
    }

    @Test
    void runTestValidArg7() {
        setInput("10 20 odd");

        run(randomCharsTable, METHOD_NAME, STRING_TO_DEL);
        printOut();

        assertTrue(isValidLetters(Arrays.copyOf(getOutputLines(), getOutputLines().length - 1), 20));
        assertTrue(isOddLetters(getOutputLines()[getOutputLines().length - 1]));
        assertEquals(11, getOutputLines().length);
        assertTrue(getOutput().contains("odd letters -"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0 1 odd", "1 0 odd", "0 1 even", "1 0 even", "1 1 od", "0 odd", "odd", "-1 3 odd", "3 -1 even"})
    void runTestInvalidArg(String input) {
        setInput(input);

        run(randomCharsTable, METHOD_NAME, STRING_TO_DEL);

        assertTrue(getOutput().contains("Passed parameters should match the format [positive integer] [positive integer] [even|odd]"));
    }

    private boolean isValidLetters(String[] outputLines, int width) {
        for (String s : outputLines) {
            s = s.replaceAll("\\|+", "");
            if (s.length() != width) {
                return false;
            }
            for (int i = 0; i < s.length(); i++) {
                if (!evenLettersArrayList.contains(s.charAt(i)) && !oddLettersArrayList.contains(s.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isEvenLetters(String lastString) {
        lastString = lastString.replaceAll("(even letters -)|(\\s+)|(,+)", "");
        for (int i = 0; i < lastString.length(); i++) {
            if (oddLettersArrayList.contains(lastString.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean isOddLetters(String lastString) {
        lastString = lastString.replaceAll("(odd letters -)|(\\s+)|(,+)", "");
        for (int i = 0; i < lastString.length(); i++) {
            if (evenLettersArrayList.contains(lastString.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}