package homework_2.traffic_light.exception;

import homework_2.traffic_light.utils.MessageType;

public class TrafficLightException extends RuntimeException {
    public TrafficLightException(MessageType e) {
        super(e.getMessage());
    }
}
