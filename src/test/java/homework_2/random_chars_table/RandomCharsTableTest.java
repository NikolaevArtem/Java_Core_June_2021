package homework_2.random_chars_table;

import base.UnitBase;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.StringJoiner;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomCharsTableTest extends UnitBase {

    private static final String welcomeMessage = "Enter value in format [positive integer] [positive integer] [even|odd]: ";
    private static final String errorMessage = "Passed parameters should match the format [positive integer] [positive integer] [even|odd]";

    @ParameterizedTest
    @MethodSource("testCases")
    void test_MainCases(final String input, final int length, final int width, final String strategy) {

        setInput(input);
        new RandomCharsTable().run();
        printOut();
        removeFromOutput(welcomeMessage);
        String actual = getOutput();

        //check width
        String widthCheckResult = checkWidth(actual, width);
        assertTrue(widthCheckResult.isEmpty(), widthCheckResult);

        String[][] outputTable = parseOutput(actual, length, width);

        //check chars
        String charsCheckResult = checkCharsInTable(outputTable);
        assertTrue(charsCheckResult.isEmpty(), charsCheckResult);

        //check strategy
        String strategyCheckResult = checkStrategy(actual, outputTable, strategy);
        assertTrue(strategyCheckResult.isEmpty(), strategyCheckResult);

        //check length
        String lengthNotCheckedMessage = String.format("Length of the table is not correct, expected %s.", length);
        assertEquals(length, actual.split("\n\r").length - 1, lengthNotCheckedMessage);

    }

    static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("2 5 odd", 2, 5, "odd"),
                Arguments.of("3 5 even", 3, 5, "even")
        );
    }

    @ParameterizedTest
    @MethodSource("garbageInput")
    void test_garbageInput(final String input, final String expected) {
        setInput(input);
        new RandomCharsTable().run();
        printOut();
        removeFromOutput(welcomeMessage);
        String actual = getOutput();
        assertTrue(actual.contains(expected));
    }

    static Stream<Arguments> garbageInput() {
        return Stream.of(
                Arguments.of("test", errorMessage),
                Arguments.of("5 6 odd ", errorMessage),
                Arguments.of("0 0 odd", errorMessage),
                Arguments.of("0 0 even", errorMessage),
                Arguments.of("5 6 Even", errorMessage),
                Arguments.of("2 2 oddeven", errorMessage),
                Arguments.of("0", errorMessage),
                Arguments.of("-5", errorMessage),
                Arguments.of("-100000000", errorMessage),
                Arguments.of("", errorMessage),
                Arguments.of(" ", errorMessage)
        );
    }

    private String checkStrategy(String actual, String[][] outputTable, String strategy) {
        String result = "";
        StringJoiner joiner = new StringJoiner(",");
        for (String[] strings : outputTable) {
            for (String string : strings) {
                char letter = string.charAt(0);
                if (strategyMatch(letter, strategy)) {
                    joiner.add("" + letter);
                }
            }
        }
        String strategyString = String.format("%s%s letters - %s", strategy.substring(0, 1).toUpperCase(), strategy.substring(1), joiner);
        String[] rows = actual.split("\n\r");
        String lastRow = rows[rows.length - 1];
        if (!lastRow.matches(strategyString)) {
            result = result + String.format("The last row in output is incorrect. Expected: %s.", strategyString);
        }
        return result;
    }

    private String[][] parseOutput(String actual, int length, int width) {
        String[][] result = new String[length][width];
        String[] rows = actual.split("\n\r");
        for (int i = 0; i < length; i++) {
            String[] charSeqInRow = rows[i].replace("|", "").split("");
            for (int j = 0; j < width; j++) {
                result[i][j] = charSeqInRow[j];
            }
        }
        return result;
    }

    private String checkCharsInTable(String[][] outputTable) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < outputTable.length; i++) {
            for (int j = 0; j < outputTable[i].length; j++) {
                if (!outputTable[i][j].matches("[A-Z]")) {
                    result.append(String.format("In row %s char is not in [A-Z] sequence\n\r", i + 1));
                }
            }
        }
        return result.toString();
    }

    private String checkWidth(String actual, int width) {
        StringBuilder result = new StringBuilder();
        String[] rows = actual.split("\n\r");
        for (int i = 0; i < rows.length - 1; i++) {
            int actualWidth = rows[i].replace("|", "").split("").length;
            if (actualWidth != width) {
                result.append(String.format("In row %s width is %s, but %s is expected\n\r",
                        i + 1,
                        actualWidth,
                        width));
            }
        }
        return result.toString();
    }

    private static boolean strategyMatch(char charItem, String strategy) {
        return (strategy.equals("even") && charItem % 2 == 0) || (strategy.equals("odd") && charItem % 2 != 0);
    }
}