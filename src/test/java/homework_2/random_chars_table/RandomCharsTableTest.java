package homework_2.random_chars_table;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RandomCharsTableTest extends UnitBase {
    @Test
    void InputZeroAsArgument() {
        setInput("0");

        new RandomCharsTable().run();
        printOut();
        removeFromOutput("Введите данные:");
        assertEquals("Passed parameters should match the format [positive integer] [positive integer] [even|odd]", getOutputLines()[0]);
    }

    @Test
    void InputEmptyArgument() {
        setInput("");
        assertThrows(NoSuchElementException.class, () -> new RandomCharsTable().run());
    }

    @Test
    void InputValidEvenArguments() {
        setInput("3 3 even");

        new RandomCharsTable().setDebug(true).run();
        printOut();
        removeFromOutput("Введите данные:");
        assertEquals("| K | N | W |", getOutputLines()[0]);
        assertEquals("| N | E | E |", getOutputLines()[1]);
        assertEquals("| J | G | D |", getOutputLines()[2]);
        assertEquals("Even letters - N, N, J, D", getOutputLines()[3]);
    }

    /*
    for this test use new RandomCharsTable().setDebug(true).run();
    3 3 odd
    | K | N | W |
    | N | E | E |
    | J | G | D |
    odd letters - K, W, E, E, G
 */
    @Test
    void InputValidOddArguments() {
        setInput("3 3 odd");

        new RandomCharsTable().setDebug(true).run();
        printOut();
        removeFromOutput("Введите данные:");
        assertEquals("| K | N | W |", getOutputLines()[0]);
        assertEquals("| N | E | E |", getOutputLines()[1]);
        assertEquals("| J | G | D |", getOutputLines()[2]);
        assertEquals("Odd letters - K, W, E, E, G", getOutputLines()[3]);
    }
}