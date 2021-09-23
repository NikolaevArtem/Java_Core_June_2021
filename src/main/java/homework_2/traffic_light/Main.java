package homework_2.traffic_light;

public class Main {
    public static void main(String[] args) {
        /* if you need to launch a program with Extra mode (with another format of current time) -
        add "extramode" to your Program arguments
         */
        if (args[0].equalsIgnoreCase("extramode")) {
            new ExtraTrafficLight().run();
        } else {
            new TrafficLight().run();
        }
    }
}
