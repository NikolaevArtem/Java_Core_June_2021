package homework_1;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest extends UnitBase {

    @Test
    void mainTestValidArg() {
        String[] inputArg = {"a", "aa", "aaa", "aaaa", "aaaaa"};

        String[] expectedArray = {
            "a: 1 letters",
            "aa: 2 letters",
            "aaa: 3 letters",
            "aaaa: 4 letters",
            "aaaaa: 5 letters"};
        Main.main(inputArg);

        assertArrayEquals(expectedArray, getOutputLines());
    }

    @Test
    void mainTestValidArg2() {
        String[] inputArg = {"1"};

        String[] expectedArray = {"1: 1 letters"};
        Main.main(inputArg);

        assertArrayEquals(expectedArray, getOutputLines());
    }

    @Test
    void mainTestEmptyArg() {
        String[] inputArg = {};

        Main.main(inputArg);
        printOut();

        assertEquals("", getOutput());
    }

    @Test
    void mainTestWithErr() {
        String[] inputArg = {"a", "aa", "aaa", "error", "ааааа"};

        String[] expectedArray = {
            "a: 1 letters",
            "aa: 2 letters",
            "aaa: 3 letters",
            "\033[0;31mAlarm!\033[0m"};
        Main.main(inputArg);

        assertArrayEquals(expectedArray, getOutputLines());
    }
}