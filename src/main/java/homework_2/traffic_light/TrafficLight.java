package homework_2.traffic_light;

public class TrafficLight {

    private static final String ANSI_RED = "\u001b[31m";
    private static final String ANSI_YELLOW = "\u001b[33m";
    private static final String ANSI_GREEN = "\u001b[32m";
    private static final String ANSI_RESET = "\u001b[0m";

    public void showLight(int tmp) {
        if (0 <= tmp && tmp < 35) {
            System.out.println(ANSI_GREEN + "GREEN" + ANSI_RESET);
        } else if ((35 <= tmp && tmp < 40) || (55 <= tmp && tmp < 60)) {
            System.out.println(ANSI_YELLOW + "YELLOW" + ANSI_RESET);
        } else if (40 <= tmp && tmp < 55) {
            System.out.println(ANSI_RED + "RED" + ANSI_RESET);
        }
    }

    public void run() {
       System.out.println("Traffic Light App.");
       System.out.println("Enter the number of seconds between 0 and 86399 inclusive:");

       showLight(new InputValidator().input());

    }
}


