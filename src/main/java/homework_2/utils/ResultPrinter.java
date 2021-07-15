package homework_2.utils;

import java.io.PrintStream;

public class ResultPrinter {
    private final PrintStream printStream = System.out;

    public void printResult(
            Data data
    ) {
        printResult(data.getResult(), data.getInValue());
    }

    public void printResult(
            String result,
            String inputValue
    ) {
        printResult(result,
                inputValue,
                printStream);
    }
    /**
     *
     * @param result Result.
     * @param inputValue The value entered by the user.
     * @param outputStream Where to print the result.
     */
    public void printResult(
            String result,
            String inputValue,
            PrintStream outputStream
    ) {
        String str = "input - " +
                inputValue +
                ", " +
                "output - " +
                result;
        outputStream.println(str);
    }
}
