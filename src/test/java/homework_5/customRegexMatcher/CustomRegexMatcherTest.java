package homework_5.customRegexMatcher;

import base.UnitBase;
import homework_5.powerOfNumber.PowerOfNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CustomRegexMatcherTest extends UnitBase {

    @ParameterizedTest
    @ValueSource(strings = {"ashandrikov@gmail.com", "123abc@yandex.ru", "r_n-13@mail.i.ua"})
    void givenCorrectEmail_whenRun_thenTrue(String input) {
        setInput(input);
        runPrintRemoveFromOutput();
        assertTrue(Boolean.parseBoolean(getOutput()));
    }

    @ParameterizedTest
    @ValueSource(strings = {"as.ua", "a@gmail.com a@gmail.com", "", "a@.ru"})
    void givenIncorrectEmail_whenRun_thenFalse(String input) {
        setInput(input);
        runPrintRemoveFromOutput();
        assertFalse(Boolean.parseBoolean(getOutput()));
    }

    private void runPrintRemoveFromOutput() {
        new CustomRegexMatcher().run();
        printOut();
        removeFromOutput("Please, input your Email");
    }
}