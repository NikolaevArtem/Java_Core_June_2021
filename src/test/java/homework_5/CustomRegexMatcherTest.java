package homework_5;

import homework_5.custom_regex_matcher.CustomRegexMatcher;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class CustomRegexMatcherTest extends base.UnitBase {

    private final String START_MESSAGE = "Regex for a file path in java project starting in src/\n"
            + "Example: src/main/java/package_1/Class1.java";

    @ParameterizedTest
    @MethodSource("validTestCases")
    void validInputTest(String input) {
        setInput(input);

        new CustomRegexMatcher().run();
        printOut();
        removeFromOutput(START_MESSAGE);

        assertEquals("true", getOutput());
    }

    @ParameterizedTest
    @MethodSource("invalidTestCases")
    void invalidInputTest(String input) {
        setInput(input);

        new CustomRegexMatcher().run();
        printOut();
        removeFromOutput(START_MESSAGE);

        assertEquals("false", getOutput());
    }

    public static Stream<Arguments> validTestCases() {
        return Stream.of(
                arguments("src/main/java/package_1/MyClass.java"),
                arguments("src/main/java/package_1/subpackage/MyClass.java"),
                arguments("src/main/java/MyClass.java"),
                arguments("src/main/resources/my_file"),
                arguments("src/main/resources/File.txt"),
                arguments("src/main/resources/some_file.html"),
                arguments("src/test/java/package_1/MyClassTest.java"),
                arguments("src/main/java/package_1/subpackage/MyClassTest.java"),
                arguments("src/main/java/MyTest.java")
        );
    }

    public static Stream<Arguments> invalidTestCases() {
        return Stream.of(
                arguments("string"),
                arguments("src/main/java/myClass.java"),
                arguments("src/main/java/my_package.java/MyClass.java"),
                arguments("src/main/resources/file.txt.html"),
                arguments("src//main/java/package_1/subpackage/MyClass.java"),
                arguments("src/main/java/package_1/subpackage/MyClassTest"),
                arguments("src/main/java/package_1/subpackage/"),
                arguments("src/main/resources/")
        );
    }

}
