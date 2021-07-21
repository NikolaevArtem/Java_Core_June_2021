package homework_2.random_chars_table;

import base.UnitBase;
import homework_2.pyramid_printer.PyramidPrinter;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

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
}