package homework_2.task_1;

public class TrafficLight {

    public static final String ANSI_RESET = "\033[0m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_RED = "\u001B[31m";

    private int numberOfSeconds;

    public TrafficLight() {
    }

    public TrafficLight(int numberOfSeconds) {
    }

    public void setNumberOfSeconds(int numberOfSeconds) {
        this.numberOfSeconds = numberOfSeconds;
    }

    public boolean go() {
        return checkEnter();
    }

    private boolean checkEnter() {
        if (numberOfSeconds == -1) {
            return false;
        }
        if (numberOfSeconds < 0) {
            System.out.println(ANSI_RED + "Number must be positive" + ANSI_RESET);
            return true;
        }
        if (numberOfSeconds > 86399) {
            System.out.println(ANSI_RED + "Day is over" + ANSI_RESET);
            return true;
        }
        getTrafficLight(numberOfSeconds);
        return true;
    }

    private void getTrafficLight(int light) {
        light -= 60 * (light / 60);
        if (light >= 0 && light < 35) {
            System.out.println(ANSI_GREEN_BACKGROUND + "Green light" + ANSI_RESET);
        }
        if ((light >= 35 && light < 40) || (light >= 55 && light < 60)) {
            System.out.println(ANSI_YELLOW_BACKGROUND + "Yellow light" + ANSI_RESET);
        }
        if (light >= 40 && light < 55) {
            System.out.println(ANSI_RED_BACKGROUND + "Red light" + ANSI_RESET);
        }
    }
}

