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
            return i;
        } catch (NumberFormatException e) {
            System.out.println(ANSI_YELLOW + "WARNING: " + ANSI_RESET +
                    "ONLY INTEGER NUMBER AS VALUE AVAILABLE.");
            throw new IOException(e);
        }
    }

    static String bufferedReaderStringReader() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String s = reader.readLine();
            return s;
        } catch (IOException e) {
            System.out.println("Something is wrong: " + e);
        }
        return "";
    }

}
