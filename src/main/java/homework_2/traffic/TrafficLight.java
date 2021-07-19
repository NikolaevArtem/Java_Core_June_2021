package homework_2.traffic;

import homework_2.utils.AppWithIntInput;
import homework_2.utils.Executable;

import java.util.Scanner;

public class TrafficLight extends AppWithIntInput {

    protected final static String ERR_MAX_MSG = "Error: день закончен)";

    private final static int MAX_VALUE = 86399;
    private final static int GREEN_START = 0;
    private final static int GREEN_END = 35;
    private final static int RED_START = 40;
    private final static int RED_END = 55;

    public static void main(String[] args) {
        Executable trafficLight = new TrafficLight();
        trafficLight.execute();
    }

    @Override
    protected String calculate() {

        if(error != null) {
            return error;
        }
        Color color;
        if (data > MAX_VALUE) {
            return (ERR_MAX_MSG);
        } else {
            int sec = data % 60;
            if (sec >= GREEN_START && sec < GREEN_END) {
                color = Color.GREEN;
            } else if (sec >= RED_START && sec < RED_END) {
                color = Color.RED;
            } else {
                color = Color.YELLOW;
            }
            return color.name();
        }
    }
}
