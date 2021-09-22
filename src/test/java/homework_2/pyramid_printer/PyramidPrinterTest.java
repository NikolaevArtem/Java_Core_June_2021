package homework_2.pyramid_printer;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class PyramidPrinterTest extends UnitBase {
    @Test
    void InputZeroAsArgument() {
        setInput("0");

        new PyramidPrinter().run();
        printOut();
        removeFromOutput("Введите данные:");
        assertEquals("", getOutputLines()[0]);
    }

    @Test
    void InputFiveAsArgument() {
        setInput("5");

        new PyramidPrinter().run();
        printOut();
        removeFromOutput("Введите данные:");
        assertEquals("x", getOutputLines()[0]);
        assertEquals("xx", getOutputLines()[1]);
        assertEquals("xxx", getOutputLines()[2]);
        assertEquals("xxxx", getOutputLines()[3]);
        assertEquals("xxxxx", getOutputLines()[4]);
    }

    @Test
    void InputMinusOneAsArgument() {
        setInput("-1");

        new PyramidPrinter().run();
        printOut();
        removeFromOutput("Введите данные:");
        assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutputLines()[0]);
    }

    @Test
    void InputStringValueAsArgument() {
        setInput("String");

        new PyramidPrinter().run();
        printOut();
        removeFromOutput("Введите данные:");
        assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutputLines()[0]);
    }

    @Test
    void InputTwoArguments() {
        setInput("2 2");

        new PyramidPrinter().run();
        printOut();
        removeFromOutput("Введите данные:");
        assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutputLines()[0]);
    }

    @Test
    void InputDoubleAsArgument() {
        setInput("0.1");

        new PyramidPrinter().run();
        printOut();
        removeFromOutput("Введите данные:");
        assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutputLines()[0]);
    }

    @Test
    void InputDigitalValueBiggerThenIntegerAsArgument() {
        setInput("9999999999");

        new PyramidPrinter().run();
        printOut();
        removeFromOutput("Введите данные:");
        assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutputLines()[0]);
    }

    @Test
    void InputEmptyArgument() {
        setInput("");
        assertThrows(NoSuchElementException.class, () -> new PyramidPrinter().run());
    }
}