package homework_2.random_chars_table;

import base.UnitBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RandomCharsTableTest extends UnitBase {

    public static final String ERROR_MESSAGE  = "Passed parameters should match the format [positive integer] [positive integer] [even|odd]";

    @Test
    public void notNumberParamsTest() {
        RandomCharsTable randomCharsTable = new RandomCharsTable();
        String input = "number1 number2 even";
        setInput(input);
        randomCharsTable.run();
        printOut();
        Assertions.assertEquals(ERROR_MESSAGE, getOutputLines()[0]);
    }

    @Test
    public void thirdParamIncorrectTest() {
        RandomCharsTable randomCharsTable = new RandomCharsTable();
        String input = "1 2 noEven";
        setInput(input);
        randomCharsTable.run();
        printOut();
        Assertions.assertEquals(ERROR_MESSAGE, getOutputLines()[0]);
    }

    @Test
    public void correctParams1Test() {
        RandomCharsTable randomCharsTable = new RandomCharsTable();
        String input = "1 2 even";
        setInput(input);
        randomCharsTable.run();
        printOut();
        Assertions.assertEquals(2, getOutputLines().length);
    }

    @Test
    public void correctParams2Test() {
        RandomCharsTable randomCharsTable = new RandomCharsTable();
        String input = "4 5 even";
        setInput(input);
        randomCharsTable.run();
        printOut();
        Assertions.assertEquals(5, getOutputLines().length);
    }
}
