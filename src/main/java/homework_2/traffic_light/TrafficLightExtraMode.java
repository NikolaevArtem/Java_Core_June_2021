package homework_2.traffic_light;

import homework_2.traffic_light.exception.TrafficLightException;

import static homework_2.traffic_light.utils.TrafficLightConstants.ERROR_MESSAGE;
import static homework_2.traffic_light.utils.TrafficLightConstants.ERROR_MESSAGE_EXCEED_LIMIT;
import static homework_2.traffic_light.utils.TrafficLightConstants.INFO_MESSAGE_TO_EXTRA_MODE;
import static homework_2.traffic_light.utils.TrafficLightConstants.SECONDS_IN_HOUR;
import static homework_2.traffic_light.utils.TrafficLightConstants.SECONDS_IN_MINUTE;
import static homework_2.traffic_light.utils.TrafficLightUtils.getData;
import static homework_2.traffic_light.utils.TrafficLightUtils.printMessage;

public class TrafficLightExtraMode extends TrafficLight {

    @Override
    public void run() {
        printMessage(INFO_MESSAGE_TO_EXTRA_MODE);
        try {
            String data = getData();
            printLight(getSeconds(data));
        } catch (TrafficLightException e) {
            printMessage(e.getMessage());
        }
    }

    @Override
    protected int getSeconds(String time) {
        String[] timeArray = time.trim().split(":");
        if (timeArray.length != 3 || time.contains("-")) {
            throw new TrafficLightException(ERROR_MESSAGE);
        }
        int hours = Integer.parseInt(timeArray[0]);
        int minutes = Integer.parseInt(timeArray[1]);
        int seconds = Integer.parseInt(timeArray[2]);
        if (hours > 23 || minutes > 59 || seconds > 59) {
            throw new TrafficLightException(ERROR_MESSAGE_EXCEED_LIMIT);
        }
        return hours * SECONDS_IN_HOUR + minutes * SECONDS_IN_MINUTE + seconds;
    }
}
