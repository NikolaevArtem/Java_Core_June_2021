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
    void givenNegative_whenRun_thenArraySizeError() {
        setInput("-1 5 even");

        run();

        assertEquals("Passed parameters should match the format [positive integer] [positive integer] [even|odd]", getOutput());
    }

    @Test
    void givenWrongArgument_whenRun_thenInputError() {
        setInput("error 5 even");

        run();

        assertEquals("Passed parameters should match the format [positive integer] [positive integer] [even|odd]", getOutput());
    }

    @Test
    void givenWrongStrategyName_whenRun_thenInputError() {
        setInput("4 5 error");

        run();

        assertEquals("Passed parameters should match the format [positive integer] [positive integer] [even|odd]", getOutput());
    }

}