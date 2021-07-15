package homework_2.utils;

import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MyReader {

    private final InputStream inputStream = System.in;
    private final PrintStream errStream = System.err;
    Scanner sc;

    {
        sc = new Scanner(inputStream);
    }

    /**
     *
     * @param data Where to store the input data.
     */
    public void read(Data data) {
        try {
            data.setInValue(sc.next());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            data.setInValue("NoSuchElementException");
            data.setError("Error: NoSuchElementException");
        }
    }

    public void close() {
        sc.close();
    }
}
