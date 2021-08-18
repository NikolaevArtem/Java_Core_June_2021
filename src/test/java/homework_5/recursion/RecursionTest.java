package homework_5.recursion;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecursionTest {

    final Recursion recursion = new Recursion();


    @ParameterizedTest
    @MethodSource("testsCases")
    void givenNumbers_whenRecPow_thenCalculateResult(double n, int power, double expected) {
        assertEquals(expected, recursion.recPow(n, power), 0.000001);
    }

    static Stream<Arguments> testsCases() {
        return Stream.of(
                Arguments.of(1, 0, 1),
                Arguments.of(0, 0, 1),
                Arguments.of(100, 0, 1),
                Arguments.of(2, 7, 128),
                Arguments.of(3, 3, 27),
                Arguments.of(2, 20, 1048576),
                Arguments.of(10, -1, 0.1),
                Arguments.of(10, -3, 0.001),
                Arguments.of(2, -2, 0.25),
                Arguments.of(1.414213562373095, 2, 2),
                Arguments.of(Math.PI, 5, 306.01968478528136)
        );
    }
}
