package homework_2.traffic_light;

import homework_2.utils.AppWithIntInput;

public class TrafficLight extends AppWithIntInput {

    protected final static String ERR_MAX_MSG = "Error: день закончен)";
    private final static int MAX_VALUE = 86399;

    @Override
    protected String calculate() {
        if (error != null) return error;
        if (data > MAX_VALUE) return (ERR_MAX_MSG);

        int sec = data % 60;
        return Color.check(sec).name();
    }
}
