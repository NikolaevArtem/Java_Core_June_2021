package homework_2.traffic_light;

public class TrafficLight {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_STRIKEOUT_RED = "\u001B[31;9m";
    private static final String ANSI_STRIKEOUT_GREEN = "\u001B[32;9m";
    private static final String ANSI_STRIKEOUT_YELLOW = "\u001B[33;9m";

    public void run() {
        InputTrafficLightReader IOHelper = new InputTrafficLightReader();
        checkColor(IOHelper.bufferReaderConsole());
    }

    private void checkColor(int time) {
        if(time < 0 || time >= 86400) return;

        int sec = time % 60;
        if(sec < 35) {
            System.out.println(ANSI_STRIKEOUT_GREEN + "Green" + ANSI_RESET);
        } else if(sec < 40 || sec >= 55) {
            System.out.println(ANSI_STRIKEOUT_YELLOW + "Yellow" + ANSI_RESET);
        } else {
            System.out.println(ANSI_STRIKEOUT_RED + "Red" + ANSI_RESET);
        }
    }
}
