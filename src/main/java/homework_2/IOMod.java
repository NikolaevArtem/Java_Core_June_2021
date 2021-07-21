package homework_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOMod {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\033[1;91m";
    public static final String ANSI_GREEN = "\033[1;92m";
    public static final String ANSI_YELLOW = "\033[1;93m";
    public static final String BLUE_BG = "\033[0;104m";
    public static final String PURPLE_BG = "\033[0;105m";
    public static final String CYAN_BG = "\033[0;106m";

    public static int bufferedReaderIntReader() throws IOException, NumberFormatException {
        int i;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            i = Integer.parseInt(reader.readLine());
        }
        return i;
    }

    public static String bufferedReaderStringReader() {
        String s = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            s = reader.readLine();
        } catch (IOException e) {
            System.out.println("Something is wrong: " + e);
        }
        return s;
    }

}
