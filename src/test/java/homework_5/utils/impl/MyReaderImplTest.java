package homework_5.utils.impl;

import base.UnitBase;
import homework_5.customRegexMatcher.CustomRegexMatcher;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MyReaderImplTest extends UnitBase {


    @Test
    void readValidTest() {
        String input_value = "text";
        setInput(input_value);

        MyReaderImpl reader = new MyReaderImpl();

        assertEquals(input_value,  reader.readData());
        assertEquals("Введите данные:", getOutput());
    }

    @Test
    void EmptyInputTest() {
        final String input_value = "";
        setInput(input_value);

        assertThrows(NoSuchElementException.class, () -> new MyReaderImpl().readData());
    }

    @Test
    void closeAndReadTest() {
        final String input_value = "test";
        setInput(input_value);

        MyReaderImpl reader = new MyReaderImpl();
        reader.readData();
        reader.close();

        assertThrows(IllegalStateException.class, reader::readData);
    }
}