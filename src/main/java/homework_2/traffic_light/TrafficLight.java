package homework_2.traffic_light;

import homework_2.traffic_light.exception.TrafficLightException;

import static homework_2.traffic_light.utils.Constants.ERROR_MESSAGE;
import static homework_2.traffic_light.utils.Constants.ERROR_MESSAGE_EXCEED_LIMIT;
import static homework_2.traffic_light.utils.Constants.INFO_MESSAGE;
import static homework_2.traffic_light.utils.Constants.LIGHT_GREEN_MESSAGE;
import static homework_2.traffic_light.utils.Constants.LIGHT_RED_MESSAGE;
import static homework_2.traffic_light.utils.Constants.LIGHT_YELLOW_MESSAGE;
import static homework_2.traffic_light.utils.Constants.SECONDS_IN_DAY;
import static homework_2.traffic_light.utils.Constants.SECONDS_IN_MINUTE;
import static homework_2.traffic_light.utils.Utils.getData;
import static homework_2.traffic_light.utils.Utils.printMessage;

public class TrafficLight {

    public void run() {
        printMessage(INFO_MESSAGE);
        try {
            String data = getData();
            printLight(getSeconds(data));
        } catch (TrafficLightException e) {
            printMessage(e.getMessage());
        }
    }

    protected int getSeconds(String time) {
        try {
            int seconds = Integer.parseInt(time);
            if (seconds < 0) {
                throw new TrafficLightException(ERROR_MESSAGE);
            } else if (seconds > SECONDS_IN_DAY) {
                throw new TrafficLightException(ERROR_MESSAGE_EXCEED_LIMIT);
            }
            return seconds;
        } catch (NumberFormatException e) {
            throw new TrafficLightException(ERROR_MESSAGE);
        }
    }

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

