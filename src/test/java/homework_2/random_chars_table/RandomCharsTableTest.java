package homework_2.random_chars_table;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RandomCharsTableTest extends UnitBase {

    private void run() {
        new RandomCharsTable().run();
        removeFromOutput("Enter valid table length, width and strategy(even or odd) in format \"length width strategy\"");
        printOut();
    }

    @Test
    void runWithNegativeArgument() {
        setInput("-1 5 even");

        run();

        assertEquals("Array size cannot be negative.", getOutput());
    }

    @Test
    void runWithMismatchArguments() {
        setInput("error 5 even");

        run();

        assertEquals("Input parameters must be in the format [positive integer(>0)] [positive integer(>0)] [even|odd]", getOutput());
    }

    @Test
    void runWithMismatchStrategy() {
        setInput("4 5 error");

        run();

        assertEquals("Input parameters must be in the format [positive integer(>0)] [positive integer(>0)] [even|odd]", getOutput());
    }

}