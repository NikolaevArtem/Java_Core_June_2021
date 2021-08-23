package homework_5.powerOfNumber;

import base.UnitBase;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PowerOfNumberTest extends UnitBase {

    static String expectedError = "Only 2 non-negative integers are allowed";

    public static Stream<Arguments> recursionTests() {
        return Stream.of (
                Arguments.of ("2 2", "4"),
                Arguments.of ("2 1", "2"),
                Arguments.of ("2 0", "1"),
                Arguments.of ("0 2", "0"),
                Arguments.of ("3 3", "27"),
                Arguments.of ("asd,. asd", expectedError),
                Arguments.of ("1", expectedError),
                Arguments.of ("-1 2", expectedError),
                Arguments.of ("", expectedError),
                Arguments.of ("  ", expectedError),
                Arguments.of ("5. 2", expectedError)
        );
    }

    @ParameterizedTest
    @MethodSource("recursionTests")
    void testRun1InputInOneRow(String in, String expected) {
        setInput (in);
        PowerOfNumber powerOfNumber = new PowerOfNumber ();
        powerOfNumber.run ();

        assertEquals (expected, getOutputLines ()[0]);
    }
}
