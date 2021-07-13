package homework_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOMod {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    static int bufferedReaderIntReader() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int i = Integer.parseInt(reader.readLine());
            if (i >= 0 && i < 86400) {
                return i;
            }
            if (i < 0) {
                System.out.println(ANSI_YELLOW + "WARNING: " + ANSI_RESET +
                        "INCORRECT VALUE! ONLY POSITIVE INTEGER NUMBERS AVAILABLE AS A VALUE");
            } else {
                System.out.println(ANSI_YELLOW + "WARNING: " + ANSI_RESET +
                        "INCORRECT VALUE! SHOULD BE IN RANGE: 0 <= value < 86400");
            }
            return -1;
        } catch (NumberFormatException e) {
            // throw new RuntimeException(e);
            System.out.println(ANSI_RED + "ERROR: " + ANSI_RESET +
                    "ONLY INTEGER NUMBERS AVAILABLE AS A VALUE");
            return -1;
        }
    }

    static int bufferedReaderPyramidHeight() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int i = Integer.parseInt(reader.readLine());
            if (i > 0) {
                return i;
            }
            return -1;
        } catch (NumberFormatException e) {
            //throw new RuntimeException(e);
            return -1;
        }
    }

}
