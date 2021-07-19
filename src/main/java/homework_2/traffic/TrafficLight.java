package homework_2.traffic;

import homework_2.utils.AppWithIntInput;
import homework_2.utils.Executable;

import java.util.Scanner;

public class TrafficLight extends AppWithIntInput {

    protected final static String ERR_MAX_MSG = "Error: день закончен)";

    private final static int MAX_VALUE = 86399;

    public static void main(String[] args) {
        Executable trafficLight = new TrafficLight();
        trafficLight.execute();
    }

    @Override
    protected String calculate() {

        if(error != null) {
            return error;
        }
        if (data > MAX_VALUE) {
            return (ERR_MAX_MSG);
        } else {
            int sec = data % 60;
            return Color.check(sec).name();
        }
    }
}
