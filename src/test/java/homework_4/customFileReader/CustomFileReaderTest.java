package homework_4.customFileReader;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomFileReaderTest {

    private final String expected = "Я вас любил: любовь еще быть может\n" +
            "В душе моей угасла не совсем;\n" +
            "Но пусть она вас больше не тревожит;\n" +
            "Я не хочу печалить вас ничем\n";

    @Test
    void run1() {
        assertEquals(expected.trim(), new CustomFileReader().run1().replaceAll("\r", ""));
    }

    @Test
    void run2() {
        assertEquals(expected, new CustomFileReader().run2());
    }

    @Test
    void run3() {
        assertEquals(expected, new CustomFileReader().run3());
    }

    @Test
    void run4() {
        assertEquals(expected.trim(), new CustomFileReader().run4().replaceAll("\r", ""));
    }
}