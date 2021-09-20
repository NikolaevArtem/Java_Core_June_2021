package SeaBattle;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static SeaBattle.GenerateShips.FIELD_SIZE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputValidatorTest {

    static char[][] arr = new char[FIELD_SIZE][FIELD_SIZE];

    @Test
    void testGiven1() {
        System.out.println(Arrays.deepToString(arr));
        assertEquals(true, InputValidator.isInvalidInputData(-1, 2, arr));
    }

    public static Stream<Arguments> ints() {
        return Stream.of(
                Arguments.of(false, 1, 1, arr),
                Arguments.of(true, 1, -1, arr),
                Arguments.of(true, -1, 1, arr),
                Arguments.of(true, 1, 10, arr),
                Arguments.of(true, 5, 5, arr),
                Arguments.of(true, 6, 6, arr),
                Arguments.of(false, 9, 1, arr)
        );
    }

    @ParameterizedTest
    @MethodSource("ints")
    void boardGeneratorTestInt(boolean ex, int x, int y, char[][] arr) {
        arr[5][5] = 'x';
        arr[6][6] = 'X';
        assertEquals(ex, InputValidator.isInvalidInputData(x, y, arr));
    }
}
