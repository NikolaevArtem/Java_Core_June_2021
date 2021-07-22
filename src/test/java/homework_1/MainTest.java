package homework_1;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest extends UnitBase {

    @Test
    void ValidInputArgsMain() {

        String[] input = {
                "тест",
                "не тест",
                "много букв",
                "Sunday",
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday"};
        Main.main(input);
        printOut();
        assertEquals("тест: 4 буквы", getOutputLines()[0]);
        assertEquals("не тест: 7 букв", getOutputLines()[1]);
        assertEquals("много букв: 10 букв", getOutputLines()[2]);
        assertEquals("Sunday: 6 букв", getOutputLines()[3]);
        assertEquals("Monday: 6 букв", getOutputLines()[4]);
        assertEquals("Tuesday: 7 букв", getOutputLines()[5]);
        assertEquals("Wednesday: 9 букв", getOutputLines()[6]);
        assertEquals("Thursday: 8 букв", getOutputLines()[7]);
        assertEquals("Friday: 6 букв", getOutputLines()[8]);
        assertEquals("Saturday: 8 букв", getOutputLines()[9]);
    }

    @Test
    void ErrorInputArgsMain() {

        String[] input = {
                "ошибка"
        };
        Main.main(input);
        printOut();

        assertTrue(getOutputLines()[0].contains("Тревога!"));
    }

    @Test
    void MixInputArgsMain() {

        String[] input = {
                "тест",
                "не тест",
                "ошибка"
        };
        Main.main(input);
        printOut();
        assertEquals("тест: 4 буквы", getOutputLines()[0]);
        assertEquals("не тест: 7 букв", getOutputLines()[1]);
        assertTrue(getOutputLines()[2].contains("Тревога"));
    }
}