package homework_1;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest extends UnitBase {

    @Test
    void test1() {
        String[] args = {
          "abcdefg",
          "hello",
          "zero",
          "",
          "абвгдеёжзийклмнопрст",
          "quit",
          "eRrOr",
          "ошибка"
        };

        Main.main(args);
        printOut();
        assertEquals("abcdefg: 7 letters", getOutputLines()[0]);
        assertEquals("hello: 5 letters", getOutputLines()[1]);
        assertEquals("zero: 4 letters", getOutputLines()[2]);
        assertEquals(": 0 letters", getOutputLines()[3]);
        assertEquals("абвгдеёжзийклмнопрст: 20 letters", getOutputLines()[4]);
        assertEquals("quit: 4 letters", getOutputLines()[5]);
        assertEquals("\u001b[31mAlarm!\u001b[0m", getOutputLines()[6]);
    }

    @Test
    void test2() {
        String[] args = {
                "строка",
                "0шибка",
                "ошибкА",
        };

        Main.main(args);
        printOut();
        assertEquals("строка: 6 letters", getOutputLines()[0]);
        assertEquals("0шибка: 6 letters", getOutputLines()[1]);
        assertEquals("\u001b[31mAlarm!\u001b[0m", getOutputLines()[2]);
    }

}