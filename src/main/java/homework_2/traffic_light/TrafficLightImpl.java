package homework_2.traffic_light;

import homework_2.traffic_light.exception.TrafficLightException;

import static homework_2.traffic_light.utils.Constants.ERROR_MESSAGE;
import static homework_2.traffic_light.utils.Constants.ERROR_MESSAGE_EXCEED_LIMIT;
import static homework_2.traffic_light.utils.Constants.INFO_MESSAGE;
import static homework_2.traffic_light.utils.Constants.SECONDS_IN_DAY;
import static homework_2.traffic_light.utils.Utils.getData;
import static homework_2.traffic_light.utils.Utils.printMessage;

public class TrafficLightImpl extends TrafficLight {

    @Override
    public void run() {
        printMessage(INFO_MESSAGE);
        try {
            String data = getData();
            printLight(getSeconds(data));
        } catch (TrafficLightException e) {
            printMessage(e.getMessage());
        }
    }

    @Override
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
}

