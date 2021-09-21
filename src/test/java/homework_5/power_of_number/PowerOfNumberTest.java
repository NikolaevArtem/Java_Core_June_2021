package homework_5.power_of_number;

import base.UnitBase;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigInteger;
import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PowerOfNumberTest extends UnitBase {

    private static String welcomeMessage = "Enter 2 positive integer numbers: ";
    private static String errorMessage = "Only 2 non-negative integers are allowed";

    @ParameterizedTest
    @MethodSource("testCases")
    void test_MainCases(final String input, final String expected) {
        setInput(input);
        new PowerOfNumber().run();
        removeFromOutput(welcomeMessage);
        printOut();
        String actual = getOutput();
        assertEquals(expected, actual);
    }

    static Stream<Arguments> testCases() {
        final Stream.Builder<Arguments> testCases = Stream.builder();

        Random randomNumber = new Random();
        Random randomPower = new Random();

        int numberDistribution = 150;
        int powerDistribution = 101;

        for (int i = 0; i < 100; i++) {
            int number = randomNumber.nextInt(numberDistribution);
            int power = randomPower.nextInt(powerDistribution);
            BigInteger powerOfNumber = BigInteger.valueOf(number).pow(power);
            String input = String.format("%s %s", number, power);
            String expectedOutput = String.format("Power %s of number %s is: %s", power, number, powerOfNumber);
            testCases.add(Arguments.of(input, expectedOutput));
        }

        String input_power0 = String.format("%s %s", 15, 0);
        String expectedOutput_power0 = String.format("Power %s of number %s is: %s", 0, 15, 1);
        testCases.add(Arguments.of(input_power0, expectedOutput_power0));

        String input_number0 = String.format("%s %s", 0, 99);
        String expectedOutput_number0 = String.format("Power %s of number %s is: %s", 99, 0, 0);
        testCases.add(Arguments.of(input_number0, expectedOutput_number0));

        return testCases.build();
    }

    @ParameterizedTest
    @MethodSource("wrongInput")
    void test_wrongInput(final String input, final String expected) {
        setInput(input);
        new PowerOfNumber().run();
        removeFromOutput(welcomeMessage);
        printOut();
        String actual = getOutput();
        assertTrue(actual.contains(expected));
    }

    static Stream<Arguments> wrongInput() {
        return Stream.of(
                Arguments.of("test", errorMessage),
                Arguments.of("-5 0", errorMessage),
                Arguments.of("5 -99", errorMessage),
                Arguments.of("", errorMessage),
                Arguments.of("0", errorMessage),
                Arguments.of(" ", errorMessage)
        );
    }

}