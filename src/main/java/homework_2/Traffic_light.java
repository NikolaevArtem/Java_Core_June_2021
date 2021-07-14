package homework_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;

import static homework_2.BufferReader.bufferReaderConsole;

public class Traffic_light {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_STRIKEOUT_RED = "\u001B[31;9m";
    public static final String ANSI_STRIKEOUT_GREEN = "\u001B[32;9m";
    public static final String ANSI_STRIKEOUT_YELLOW = "\u001B[33;9m";

    public static void main(String[] args) throws IOException {

        int time = bufferReaderConsole();
        checkColor(time);
    }

    private static void checkColor(int time) {
        int sec = time % 60;
        if (sec < 35) {
            System.out.println (ANSI_STRIKEOUT_GREEN + "Green" + ANSI_RESET);
        } else if (sec < 40) {
            System.out.println (ANSI_STRIKEOUT_YELLOW + "Yellow" + ANSI_RESET);
        } else {
            System.out.println (ANSI_STRIKEOUT_RED + "Red" + ANSI_RESET);
        }
    }
}
