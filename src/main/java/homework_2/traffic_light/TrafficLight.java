package homework_2.traffic_light;

import homework_2.traffic_light.exception.TrafficLightException;
import homework_2.traffic_light.utils.MessageType;

import static homework_2.traffic_light.utils.MessageType.INFO_MESSAGE;
import static homework_2.traffic_light.utils.MessageType.INFO_MESSAGE_TO_MODE_0;
import static homework_2.traffic_light.utils.MessageType.INFO_MESSAGE_TO_MODE_1;
import static homework_2.traffic_light.utils.MessageType.LIGHT_GREEN_MESSAGE;
import static homework_2.traffic_light.utils.MessageType.LIGHT_RED_MESSAGE;
import static homework_2.traffic_light.utils.MessageType.LIGHT_YELLOW_MESSAGE;
import static homework_2.traffic_light.utils.MessageType.ERROR_MESSAGE_EXCEED_LIMIT;
import static homework_2.traffic_light.utils.MessageType.ERROR_MESSAGE_INCORRECT_FORMAT;
import static homework_2.traffic_light.utils.MessageType.ERROR_MESSAGE_NEGATIVE_NUMBERS;
import static homework_2.traffic_light.utils.Utils.getData;
import static homework_2.traffic_light.utils.Utils.printMessage;

public class TrafficLight {
    private static final int SECONDS_IN_DAY = 86399;
    private static final int SECONDS_IN_HOUR = 3600;
    private static final int SECONDS_IN_MINUTE = 60;
    private final int mode;

    public TrafficLight(int mode) {
        this.mode = mode;
    }

    public void start() {
        printMessage(INFO_MESSAGE.getMessage());
        MessageType modeMessage = mode > 0 ? INFO_MESSAGE_TO_MODE_1 : INFO_MESSAGE_TO_MODE_0;
        printMessage(modeMessage.getMessage());
        String data = getData();
        try {
            printLight(getSeconds(mode, data));
        } catch (TrafficLightException e) {
            printMessage(e.getMessage());
        }
    }

    private int getSeconds(String time) {
        try {
            int seconds = Integer.parseInt(time);
            if (seconds < 1) {
                throw new TrafficLightException(ERROR_MESSAGE_NEGATIVE_NUMBERS);
            } else if (seconds > SECONDS_IN_DAY) {
                throw new TrafficLightException(ERROR_MESSAGE_EXCEED_LIMIT);
            }
            return seconds;
        } catch (NumberFormatException e) {
            throw new TrafficLightException(ERROR_MESSAGE_INCORRECT_FORMAT);
        }
    }

    private int getSeconds(int mode, String time) {
        if (mode == 0) {
            return getSeconds(time);
        }
        String[] timeArray = time.trim().split(":");
        if (timeArray.length != 3) {
            throw new TrafficLightException(ERROR_MESSAGE_INCORRECT_FORMAT);
        } else if (time.contains("-")) {
            throw new TrafficLightException(ERROR_MESSAGE_NEGATIVE_NUMBERS);
        }
        int hours = Integer.parseInt(timeArray[0]);
        int minutes = Integer.parseInt(timeArray[1]);
        int seconds = Integer.parseInt(timeArray[2]);
        if (hours > 23 || minutes > 59 || seconds > 59) {
            throw new TrafficLightException(ERROR_MESSAGE_EXCEED_LIMIT);
        }
        return hours * SECONDS_IN_HOUR + minutes * SECONDS_IN_MINUTE + seconds;
    }

    private void printLight(int seconds) {
        int remainder = seconds % SECONDS_IN_MINUTE;
        if (remainder >= 0 && remainder < 35) {
            printMessage(LIGHT_GREEN_MESSAGE.getMessage());
        } else if (remainder >= 35 && remainder < 40) {
            printMessage(LIGHT_YELLOW_MESSAGE.getMessage());
        } else {
            printMessage(LIGHT_RED_MESSAGE.getMessage());
        }
    }
}