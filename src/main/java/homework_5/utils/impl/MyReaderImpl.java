package homework_5.utils.impl;

import homework_5.utils.MyReader;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MyReaderImpl implements MyReader {
    private final InputStream inputStream;
    private final PrintStream printStream;
    private Scanner sc;

    public MyReaderImpl() {
        inputStream = System.in;
        printStream = System.out;
    }

    public MyReaderImpl(InputStream inputStream, PrintStream printStream) {
        this.inputStream = inputStream;
        this.printStream = printStream;
    }

    public String readData() throws NoSuchElementException, IllegalStateException {
        final String STRING_MSG = "Введите данные:";
        if (sc == null) sc = new Scanner(inputStream);
        printStream.println(STRING_MSG);

        return sc.nextLine();
    }

    public void close() {
        if (sc != null) sc.close();
    }

}
