package homework_2;

import base.UnitBase;
import homework_2.random_chars_table.RandomCharsTable;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomCharsTableTest extends UnitBase {

    private static final String ERROR = "Passed parameters should match the format [positive integer] [positive integer] [even|odd]";

    @Test
    void given22odd_whenRun_thenRandomOutput() {
        setInput("2 2 odd");
        runPrintRemoveFromOutput();

        boolean tableLine1 = getOutputLines()[0].matches("^[A-Z| ]{9}");
        boolean tableLine2 = getOutputLines()[1].matches("^[A-Z| ]{9}");
        boolean strategy = getOutputLines()[2].startsWith("Odd letters ");
        String afterStrategy = getOutputLines()[2].substring(12);
        boolean tableLine3 = afterStrategy.matches("^[ACEGIKMOQSUWY, -]*");

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
        boolean tableLine3 = afterStrategy.matches("^[BDFHJLNPRTVXZ, -]*");

        assertTrue(tableLine1);
        assertTrue(strategy);
        assertTrue(tableLine3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 a odd", "2 -3 even", "2 3 odd 2", "2 3 ods", "2 3"})
    void givenERROR_whenRun_thenERROR(String input) {
        setInput(input);
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
