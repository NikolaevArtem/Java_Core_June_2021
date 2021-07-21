package homework_2.utils;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public abstract class App implements Executable{

    protected InputStream inputStream;
    protected PrintStream printStream;
    protected String error;
    protected String inputStr;

    {
        inputStream = System.in;
        printStream = System.out;
    }

    protected abstract void parseData();
    protected abstract String calculate();

    public void start() {
        readData();
        parseData();

        printResult(calculate(), inputStr);
    }

    /**
     *
     * @param result Result.
     * @param inputValue The value entered by the user.
     */
    protected void printResult(String result, String inputValue) {
        printResult(result, inputValue, printStream);
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
        final String STRING_MSG = "Введите данные:";
        try(Scanner sc = new Scanner(inputStream)) {
            printStream.println(STRING_MSG);
            inputStr = sc.nextLine();
        }
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public void setPrintStream(PrintStream printStream) {
        this.printStream = printStream;
    }
}
