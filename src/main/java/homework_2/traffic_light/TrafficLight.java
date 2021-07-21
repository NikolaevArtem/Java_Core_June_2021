package homework_2.traffic_light;

import static homework_2.traffic_light.MessageType.INFO_MESSAGE;
import static homework_2.traffic_light.MessageType.INFO_MESSAGE_TO_MODE_0;
import static homework_2.traffic_light.MessageType.INFO_MESSAGE_TO_MODE_1;
import static homework_2.traffic_light.MessageType.LIGHT_GREEN_MESSAGE;
import static homework_2.traffic_light.MessageType.LIGHT_RED_MESSAGE;
import static homework_2.traffic_light.MessageType.LIGHT_YELLOW_MESSAGE;
import static homework_2.traffic_light.MessageType.WARNING_MESSAGE_EXCEED_LIMIT;
import static homework_2.traffic_light.MessageType.WARNING_MESSAGE_INCORRECT_FORMAT;
import static homework_2.traffic_light.MessageType.WARNING_MESSAGE_POSITIVE_NUMBERS;
import static homework_2.traffic_light.Utils.getData;
import static homework_2.traffic_light.Utils.printMessage;

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
        int seconds;
        try {
            seconds = Integer.parseInt(time);
            if (seconds < 1) {
                throw new TrafficLightException(WARNING_MESSAGE_POSITIVE_NUMBERS);
            } else if (seconds > SECONDS_IN_DAY) {
                throw new TrafficLightException(WARNING_MESSAGE_EXCEED_LIMIT);
            }
        } catch (NumberFormatException e) {
            throw new TrafficLightException(WARNING_MESSAGE_INCORRECT_FORMAT);
        }
        return seconds;
    }

    private int getSeconds(int mode, String time) {
        if (mode == 0) {
            getSeconds(time);
        }
        String[] timeArray = time.trim().split(":");
        if (timeArray.length != 3) {
            throw new TrafficLightException(WARNING_MESSAGE_INCORRECT_FORMAT);
        } else if (time.contains("-")) {
            throw new TrafficLightException(WARNING_MESSAGE_POSITIVE_NUMBERS);
        }
        int hours = Integer.parseInt(timeArray[0]);
        int minutes = Integer.parseInt(timeArray[1]);
        int seconds = Integer.parseInt(timeArray[2]);
        if (hours > 23 || minutes > 59 || seconds > 59) {
            throw new TrafficLightException(WARNING_MESSAGE_EXCEED_LIMIT);
        }
        return hours * SECONDS_IN_HOUR + minutes * SECONDS_IN_MINUTE + seconds;
    }

    private void printLight(int seconds) {
        int reminder = seconds % SECONDS_IN_MINUTE;
        if (reminder >= 0 && reminder < 35) {
            printMessage(LIGHT_GREEN_MESSAGE.getMessage());
        } else if (reminder >= 35 && reminder < 40) {
            printMessage(LIGHT_YELLOW_MESSAGE.getMessage());
        } else {
            printMessage(LIGHT_RED_MESSAGE.getMessage());
        }
    }
}