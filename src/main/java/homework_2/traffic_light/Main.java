package homework_2.traffic_light;

public class Main {
    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();
        TrafficLightExtraMod trafficLightExtraMod = new TrafficLightExtraMod();
        if(args[0].equals("seconds")){
            trafficLight.run();
        } else {
            trafficLightExtraMod.run();
        }
    }
}
