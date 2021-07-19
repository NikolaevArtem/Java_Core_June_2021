package homework_2.utils;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public abstract class App implements Executable{

    protected final static String ERR_NEGATIVE_MSG = "Error: Отрицательное число недопустимо";
    protected final static String ERR_STRING_MSG = "Error: Допустимо только число(max 2^31)";
    protected final static String STRING_MSG = "Введите данные:";

    protected final InputStream INPUT_STREAM = System.in;
    protected final PrintStream PRINT_STREAM = System.out;

    protected String error;
    protected String inputStr;


    public void execute() {

        readData();
        parseData();

        printResult(calculate(), inputStr);
    }

    protected abstract void parseData();
    protected abstract String calculate();

    /**
     *
     * @param result Result.
     * @param inputValue The value entered by the user.
     */
    protected void printResult(String result, String inputValue) {
        printResult(result, inputValue, PRINT_STREAM);
    }
    /**
     *
     * @param result Result.
     * @param inputValue The value entered by the user.
     * @param outputStream Where to print the result.
     */
    protected void printResult(String result, String inputValue, PrintStream outputStream) {
        String str = "input - " +
                inputValue +
                ", " +
                "output - " +
                result;
        outputStream.println(str);
    }

    protected void readData() {
        try(Scanner sc = new Scanner(INPUT_STREAM)) {
            PRINT_STREAM.println(STRING_MSG);
            inputStr = sc.nextLine();
        }
    }
}
