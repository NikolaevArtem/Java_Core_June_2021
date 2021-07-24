package homework_2.random_chars_table;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomCharsTableTest extends UnitBase {

    @Test
    void given_correct_option_even() {
        setInput("3 3 even");

        new RandomCharsTable().run();
        String str = getOutputLines()[getOutputLines().length-1];
        for (Character character: str.toCharArray()){
            if(character % 2 == 1){
                fail();
                return;
            }
        }
        assertTrue(true);
    }
    @Test
    void given_correct_option_odd() {
        setInput("2 2 odd");

        new RandomCharsTable().run();
        String str = getOutputLines()[getOutputLines().length-1];
        for (Character character: str.toCharArray()){
            if(character % 2 == 0){
                fail();
                return;
            }
        }
        assertTrue(true);
    }
    @Test
    void given_first_bad() {
        setInput("-1 1 even");

        new RandomCharsTable().run();

        assertEquals("Passed parameters should match the format [positive integer] [positive integer] [even|odd]", getOutputLines()[0]);
    }
    @Test
    void given_second_bad() {
        setInput("1 -31 odd");

        new RandomCharsTable().run();

        assertEquals("Passed parameters should match the format [positive integer] [positive integer] [even|odd]", getOutputLines()[0]);
    }

    @Test
    void given_last_bad() {
        setInput("1 -3 dfsdf");

        new RandomCharsTable().run();

        assertEquals("Passed parameters should match the format [positive integer] [positive integer] [even|odd]", getOutputLines()[0]);
    }

}