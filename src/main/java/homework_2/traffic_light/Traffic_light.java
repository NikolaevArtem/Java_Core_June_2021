package homework_2.traffic_light;

import homework_2.bufferReaders.BufferReader;
import java.io.IOException;

public class Traffic_light {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_STRIKEOUT_RED = "\u001B[31;9m";
    private static final String ANSI_STRIKEOUT_GREEN = "\u001B[32;9m";
    private static final String ANSI_STRIKEOUT_YELLOW = "\u001B[33;9m";

    public void run() throws IOException {
        BufferReader bufferReader = new BufferReader();
        checkColor(bufferReader.bufferReaderConsole());
    }

    private void checkColor(int time) {
        if(time < 0 || time >= 86400) return;

        int sec = time % 60;
        if (sec < 35) {
            System.out.println(ANSI_STRIKEOUT_GREEN + "Green" + ANSI_RESET);
        } else if (sec < 40) {
            System.out.println(ANSI_STRIKEOUT_YELLOW + "Yellow" + ANSI_RESET);
        } else {
            System.out.println(ANSI_STRIKEOUT_RED + "Red" + ANSI_RESET);
        }
    }
}
