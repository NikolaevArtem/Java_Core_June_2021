package homework_2;

import base.UnitBase;
import homework_2.randomCharsTable.RandomCharsTable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RandomCharsTableTest extends UnitBase {

    @Test
    void givenTwoTwoEven_whenRun_thenMatrixAndLettersPrinted(){
        setInput("2 2 even");

        new RandomCharsTable().run();
        printOut();
        removeFromOutput("Enter data in format: width, length of matrix and strategy (even/odd)");

        Assertions.assertTrue(getOutput().contains("|"));
        Assertions.assertTrue(getOutput().contains(" |"));
        Assertions.assertTrue(getOutput().contains("Even letters - "));
    }

    @Test
    void givenTwoThreeOdd_whenRun_thenMatrixAndLettersPrinted(){
        setInput("2 3 odd");

        new RandomCharsTable().run();
        printOut();
        removeFromOutput("Enter data in format: width, length of matrix and strategy (even/odd)");

        Assertions.assertTrue(getOutput().contains("|"));
        Assertions.assertTrue(getOutput().contains(" |"));
        Assertions.assertTrue(getOutput().contains("Odd letters - "));
    }

    @Test
    void givenNotFullParameters_whenRun_thenError(){
        setInput("2 even");

        new RandomCharsTable().run();
        printOut();
        removeFromOutput("Enter data in format: width, length of matrix and strategy (even/odd)");

        Assertions.assertEquals("Passed parameters should match the format [positive integer] " +
                "[positive integer] [even|odd]",getOutput());
    }
}
