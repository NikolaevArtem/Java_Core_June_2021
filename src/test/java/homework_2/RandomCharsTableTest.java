package homework_2;

import base.UnitBase;
import homework_2.random_chars_table.RandomCharsTable;
import org.junit.jupiter.api.Test;

import static homework_2.random_chars_table.RandomCharsTable.ERROR;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomCharsTableTest extends UnitBase {

    @Test
    void given22odd_whenRun_thenRandomOutput() {
        setInput("2 2 odd");
        runPrintRemoveFromOutput();

        boolean tableLine1 = getOutputLines()[0].matches("^[A-Z| ]{9}");
        boolean tableLine2 = getOutputLines()[1].matches("^[A-Z| ]{9}");
        boolean strategy = getOutputLines()[2].startsWith("Odd letters ");
        String afterStrategy = getOutputLines()[2].substring(12);
        boolean tableLine3 = afterStrategy.matches("^[A-Z, -]*");

        assertTrue(tableLine1);
        assertTrue(tableLine2);
        assertTrue(strategy);
        assertTrue(tableLine3);
    }

    @Test
    void given13even_whenRun_thenRandomOutput() {
        setInput("1 3 even");
        runPrintRemoveFromOutput();

        boolean tableLine1 = getOutputLines()[0].matches("^[A-Z| ]{13}");
        boolean strategy = getOutputLines()[1].startsWith("Even letters ");
        String afterStrategy = getOutputLines()[1].substring(13);
        boolean tableLine3 = afterStrategy.matches("^[A-Z, -]*");

        assertTrue(tableLine1);
        assertTrue(strategy);
        assertTrue(tableLine3);
    }

    @Test
    void given2args_whenRun_thenERROR() {
        setInput("2 3");
        runPrintRemoveFromOutput();
        assertEquals(ERROR, getOutput());
    }

    @Test
    void givenMistakeLetter_whenRun_thenERROR() {
        setInput("2 3 ods");
        runPrintRemoveFromOutput();
        assertEquals(ERROR, getOutput());
    }

    @Test
    void given4args_whenRun_thenERROR() {
        setInput("2 3 odd 2");
        runPrintRemoveFromOutput();
        assertEquals(ERROR, getOutput());
    }

    @Test
    void givenNegNumber_whenRun_thenERROR() {
        setInput("2 -3 even");
        runPrintRemoveFromOutput();
        assertEquals(ERROR, getOutput());
    }

    @Test
    void givenOnly1number_whenRun_thenERROR() {
        setInput("2 a odd");
        runPrintRemoveFromOutput();
        assertEquals(ERROR, getOutput());
    }

    private void runPrintRemoveFromOutput() {
        new RandomCharsTable().run();
        printOut();
        removeFromOutput("[Input example: 2 3 odd]");
        removeFromOutput("Please, input 2 positive numbers and a strategy (even/odd)");
    }
}
