package homework_2.random_chars_table;

import org.junit.jupiter.api.Test;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RandomCharsTableTest extends UnitBase{

    private void run(){
        new RandomCharsTable().run();
        printOut();
        removeFromOutput("Please input your string: ");
    }

    @Test
    void given23odd_whenRun_thenPrintTable(){
        setInput("2 3 odd");

        run();

        assertTrue(getOutputLines()[0].matches("[|A-Z|]{9}"));
        assertTrue(getOutputLines()[1].matches("[|A-Z|]{9}"));
        assertTrue(getOutputLines()[2].contains("Odd letters - "));

    }

    @Test
    void given23even_whenRun_thenPrintTable(){
        setInput("3 4 even");

        run();

        assertTrue(getOutputLines()[0].matches("[|A-Z|]{12}"));
        assertTrue(getOutputLines()[1].matches("[|A-Z|]{12}"));
        assertTrue(getOutputLines()[2].matches("[|A-Z|]{12}"));
        assertTrue(getOutputLines()[3].contains("Even letters - "));

    }

    @Test
    void givenSmth_whenRun_thenPrintErrorMessage(){
        setInput("3 4odd even");

        run();

        assertEquals("Passed parameters should match the format [positive integer] [positive integer] [even|odd]", getOutputLines()[0]);

    }
}
