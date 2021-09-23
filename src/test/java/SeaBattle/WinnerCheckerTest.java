package SeaBattle;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static SeaBattle.GenerateShips.FIELD_SIZE;
import static SeaBattle.StartGame.COUNT;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WinnerCheckerTest {

    static char[][] arr = new char[FIELD_SIZE][FIELD_SIZE];

    public static Stream<Arguments> ints() {
        return Stream.of(
                Arguments.of(true, COUNT, arr),
                Arguments.of(true, 1, arr)
        );
    }

    @ParameterizedTest
    @MethodSource("ints")
    void isWinnerExistTest(boolean ex, int x, char[][] arr) {
        boolean act = WinnerChecker.isWinnerExist(arr, x);
        assertEquals(ex, act);
    }

    @Test void isWinnerExistTestWithShip() {
        arr[5][5] = '0';
        boolean act = WinnerChecker.isWinnerExist(arr, 3);
        assertEquals(false, act);
    }
}
