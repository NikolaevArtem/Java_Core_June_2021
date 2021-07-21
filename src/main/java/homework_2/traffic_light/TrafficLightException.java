package homework_2.traffic_light;

public class TrafficLightException extends RuntimeException {
    public TrafficLightException(MessageType e) {
        super(e.getMessage());
    }
}
