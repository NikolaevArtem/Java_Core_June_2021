package homework_2.traffic_light;

import static homework_2.traffic_light.utils.Constants.LIGHT_GREEN_MESSAGE;
import static homework_2.traffic_light.utils.Constants.LIGHT_RED_MESSAGE;
import static homework_2.traffic_light.utils.Constants.LIGHT_YELLOW_MESSAGE;
import static homework_2.traffic_light.utils.Constants.SECONDS_IN_MINUTE;
import static homework_2.traffic_light.utils.Utils.printMessage;

public abstract class TrafficLight {
    public abstract void run();

    protected abstract int getSeconds(String time);

    protected void printLight(int seconds) {
        int remainder = seconds % SECONDS_IN_MINUTE;
        if (remainder >= 0 && remainder < 35) {
            printMessage(LIGHT_GREEN_MESSAGE);
        } else if (remainder >= 40 && remainder < 55) {
            printMessage(LIGHT_RED_MESSAGE);
        } else {
            printMessage(LIGHT_YELLOW_MESSAGE);
        }
    }
}
