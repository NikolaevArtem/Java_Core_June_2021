package homework_2;

import java.io.PrintStream;

public class ResultPrinter {
    /**
     *
     * @param result Result.
     * @param inputValue The value entered by the user.
     * @param outputStream Where to print the result.
     * @param isNewLine A flag indicating that a newline is required after the word 'output'.
     */
    public static void printResult(
            String result,
            String inputValue,
            PrintStream outputStream,
            boolean isNewLine
    ) {
        StringBuilder sb = new StringBuilder();
        sb
                .append("input - ")
                .append(inputValue)
                .append(", ")
                .append("output - ");
        if (isNewLine) {
            sb.append('\n');
        }
        sb.append(result);
        outputStream.println(sb);
    }
}
