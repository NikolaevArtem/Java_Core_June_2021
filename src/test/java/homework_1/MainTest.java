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
            "a: 1 букв",
            "aa: 2 букв",
            "aaa: 3 букв",
            "aaaa: 4 букв",
            "aaaaa: 5 букв"};
        Main.main(inputArg);

        assertArrayEquals(expectedArray, getOutputLines());
    }

    @Test
    void mainTestValidArg2() {
        String[] inputArg = {"1"};

        String[] expectedArray = {"1: 1 букв"};
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
        String[] inputArg = {"a", "aa", "aaa", "ошибка", "ааааа"};

        String[] expectedArray = {
            "a: 1 букв",
            "aa: 2 букв",
            "aaa: 3 букв",
            "\033[0;31mТревога!\033[0m"};
        Main.main(inputArg);

        assertArrayEquals(expectedArray, getOutputLines());
    }
}