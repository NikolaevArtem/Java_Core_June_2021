package homework_2.trafficLight;

public class Main {
    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();
        if(args[0].equals("seconds")){
            trafficLight.runSecondsFormat();
        } else {
            trafficLight.runTimeFormat();
        }
    }
}
