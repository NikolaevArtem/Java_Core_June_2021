package homework_2.random_chars_table;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.matchesPattern;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomCharsTableTest extends UnitBase {



    // Hamcrest
    @Test
    void given_lengthWidth_whenRun_then_printChars() {
        setInput("4 4 even");

        new RandomCharsTable().run();
        removeFromOutput("Enter the length, width and strategy(\"even\" or \"odd\")\n-> ");
        removeFromOutput("Even letters - ");
        removeFromOutput(",");
        removeFromOutput(" ");
        removeFromOutput("|");

        List<String> strings = new ArrayList<>(Arrays.asList(getOutputLines()));

        assertThat(strings, everyItem(matchesPattern("[A-Z]+")));
    }


    @Test
    void given_negativeIntegerFirstArgument_whenRun_then_printErrorMessage() {
        setInput("-2 2 even");

        new RandomCharsTable().run();

        assertTrue(getOutput().contains("Passed parameters should match the format " +
                "[positive integer] [positive integer] [even|odd]"));
    }

    @Test
    void given_negativeIntegerSecondArgument_whenRun_then_printErrorMessage() {
        setInput("2 -2 even");

        new RandomCharsTable().run();

        assertTrue(getOutput().contains("Passed parameters should match the format " +
                "[positive integer] [positive integer] [even|odd]"));
    }

    @Test
    void given_smthStrategy_whenRun_then_printErrorMessage() {
        setInput("2 2 abc");

        new RandomCharsTable().run();

        assertTrue(getOutput().contains("Passed parameters should match the format " +
                "[positive integer] [positive integer] [even|odd]"));
    }

    @Test
    void given_smthFirstArgument_whenRun_then_printErrorMessage() {
        setInput("b 2 even");

        new RandomCharsTable().run();

        assertTrue(getOutput().contains("Passed parameters should match the format " +
                "[positive integer] [positive integer] [even|odd]"));
    }

    @Test
    void given_smthSecondArgument_whenRun_then_printErrorMessage() {
        setInput("2 b even");

        new RandomCharsTable().run();

        assertTrue(getOutput().contains("Passed parameters should match the format " +
                "[positive integer] [positive integer] [even|odd]"));
    }

    @Test
    void given_floatingPointFirstArgument_whenRun_then_printErrorMessage() {
        setInput("0.2 2 even");

        new RandomCharsTable().run();

        assertTrue(getOutput().contains("Passed parameters should match the format " +
                "[positive integer] [positive integer] [even|odd]"));
    }

    @Test
    void given_floatingPointSecondArgument_whenRun_then_printErrorMessage() {
        setInput("2 0.2 even");

        new RandomCharsTable().run();

            assertTrue(getOutput().contains("Passed parameters should match the format " +
                    "[positive integer] [positive integer] [even|odd]"));
    }


    @Test
    void given_moreThanThreeArguments_whenRun_then_printErrorMessage() {
        setInput("4 4 4 odd");

        new RandomCharsTable().run();

        assertTrue(getOutput().contains("Passed parameters should match the format " +
                "[positive integer] [positive integer] [even|odd]"));
    }

    @Test
    void given_lengthWidthStrategy_whenRun_then_printEvenChars() {
        setInput("4 4 even");

        new RandomCharsTable().run();
        removeFromOutput("Even letters - ");
        removeFromOutput(",");
        removeFromOutput(" ");

        String str = getOutputLines()[getOutputLines().length - 1];

        for (int i = 0; i < str.length(); i++) {
            assertEquals(0, str.charAt(i) % 2);
        }
    }


    @Test
    void given_lengthWidthStrategy_whenRun_then_printOddChars() {
        setInput("4 4 odd");

        new RandomCharsTable().run();
        removeFromOutput("Even letters - ");
        removeFromOutput(",");
        removeFromOutput(" ");

        String str = getOutputLines()[getOutputLines().length - 1];

        for (int i = 0; i < str.length(); i++) {
            assertEquals(1, str.charAt(i) % 2);
        }
    }




}