package homework_2.traffic_light;

public class TrafficLightExtraMod extends TrafficLight{

    public void run() {
        System.out.println("Enter necessary time in HH:MM:SS format.");
        String parsedTime = consoleReader();
        seconds = Integer.parseInt(parsedTime.substring(parsedTime.length() - 2));
        if (seconds < 0) {
            System.out.println(ERROR);
            return;
        }
        trafficLightColorDetection(seconds);
    }
}
