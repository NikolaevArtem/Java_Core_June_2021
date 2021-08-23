package homework_5.CustomRegexMatcher;

import base.UnitBase;
import homework_5.powerOfNumber.CustomRegexMatcher;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomRegexMatcherTest  extends UnitBase {

    public static Stream<Arguments> regex() {
        return Stream.of (
                Arguments.of ("PUT /api/v1/ HTTP/1.1 200 45 https://test.lab/login", "true"),
                Arguments.of ("GET 1", "false"),
                Arguments.of (" GET /api/v1/", "false"),
                Arguments.of ("POST /api/v1/", "true"),
                Arguments.of ("POST /api/1/", "false"),
                Arguments.of ("POST/api/v1/", "false"),
                Arguments.of ("DELETE /api/v1/", "true"),
                Arguments.of ("DELET /api/v1/", "false")
        );
    }

    @ParameterizedTest
    @MethodSource("regex")
    void testRun1InputInOneRow(String in, String expected) {
        CustomRegexMatcher customRegexMatcher = new CustomRegexMatcher ();
        customRegexMatcher.run (in);

        assertEquals (expected, getOutput ());
    }
}
