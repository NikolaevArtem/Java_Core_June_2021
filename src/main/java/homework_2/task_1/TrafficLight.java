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

    public int getNumberOfSeconds() {
        return numberOfSeconds;
    }

    public void setNumberOfSeconds(int numberOfSeconds) {
        this.numberOfSeconds = numberOfSeconds;
    }

    public boolean checkEnter() {
        if (numberOfSeconds < 0) {
            System.out.println(ANSI_RED + "Number must be positive" + ANSI_RESET);
            return false;
        }
        if (numberOfSeconds > 86399) {
            System.out.println(ANSI_RED + "Day is over" + ANSI_RESET);
            return false;
        }
        return true;
    }

    public void getTrafficLight() {
        numberOfSeconds -= 60 * (numberOfSeconds / 60);
        if (numberOfSeconds >= 0 && numberOfSeconds < 35) {
            System.out.println(ANSI_GREEN_BACKGROUND + "Green light" + ANSI_RESET);
        }
        if ((numberOfSeconds >= 35 && numberOfSeconds < 40) || (numberOfSeconds >= 55 && numberOfSeconds < 60)) {
            System.out.println(ANSI_YELLOW_BACKGROUND + "Yellow light" + ANSI_RESET);
        }
        if (numberOfSeconds >= 40 && numberOfSeconds < 55) {
            System.out.println(ANSI_RED_BACKGROUND + "Red light" + ANSI_RESET);
        }
    }
}

