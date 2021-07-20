package homework_2.pyramid_printer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PyramidPrinter {

    public static final String ERROR = "Only 1 non-negative integer is allowed as passed parameter";

    public void run() {
        System.out.println("Please, input a number:");
        int countX = bufferedReaderReadConsole();
        if (countX < 0) {
            System.out.println(ERROR);
            return;
        }

        String s = "x";
        for (int i = 1; i <= countX; i++) {
            System.out.println(s);
            s = s + "x";
        }
    }

    private int bufferedReaderReadConsole() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int count = 0;
            try {
                count = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException e) {
                return -1;
            }
            return count;
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Что лучше возвращать в return?
        return -1;
    }
}
