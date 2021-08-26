package homework_5.custom_regex_matcher;

import base.UnitBase;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomRegexMatcherTest extends UnitBase {
    private final CustomRegexMatcher customRegexMatcher = new CustomRegexMatcher();

    @ParameterizedTest
    @MethodSource("testCases")
    void test(final String[] input, final String expected) {
        customRegexMatcher.run(input);
        assertEquals(expected, getOutput());
    }

    static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new String[]{}, "false"),
                Arguments.of(new String[]{"2021-02-09T18:18:24:424Z – [username9] - wanna scoop 182l"}, "true"),
                Arguments.of(new String[]{"2021-02-09T18:18:24:424Z – [username9] - wanna scoop 182l",
                        "2021-02-09T18:18:23:081Z – [username10] - wanna top up 66l",
                        "2021-02-09T18:18:27:941Z – [username7] - wanna top up 148l"}, "true\ntrue\ntrue"),
                Arguments.of(new String[]{"2021-02-09T18:18:30:557Z – [username7] - wanna top up 173l",
                        "202102-09T18:18:31:117Z – [username9] - wanna top up 96l",
                        "2021-02-09T18:20:27:448Z – [username6] - wanna scoop 21l"}, "true\nfalse\ntrue"),
                Arguments.of(new String[]{"2021-0209T18:18:30:557Z – [username7] - wanna top up 173l",
                        "202102-09T18:18:31:117Z – [username9] - wanna top up 96l",
                        "Just a string"}, "false\nfalse\nfalse")
        );
    }

}
