package homework_2.traffic_light;

import base.UnitBaseMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class TrafficLightExtraModeTest extends UnitBaseMode {

    private final TrafficLightExtraMode trafficLightExtraMode = new TrafficLightExtraMode();
    private final String METHOD_NAME = "run";
    private final String STRING_TO_DEL = "Enter the number";

    @ParameterizedTest
    @ValueSource(strings = {
        "23:01:00", "15:00:08", "07:00:16", "00:00:24",
        "21:02:02", "13:01:10", "05:01:18", "01:50:26",
        "19:03:04", "11:02:12", "03:10:20", "10:59:28",
        "17:04:06", "09:03:14", "23:00:22", "23:12:32"
    })
    void runTestGreenLight(String input) {
        setInput(input);

        run(trafficLightExtraMode, METHOD_NAME, STRING_TO_DEL);

        printOut();

        assertTrue(getOutput().contains("Green light"));
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "23:59:35", "15:59:39", "07:59:58", "00:59:37",
        "21:12:36", "13:59:55", "05:59:59", "01:59:38",
        "19:34:37", "11:59:56", "03:59:35", "10:59:39",
        "17:25:38", "09:59:57", "23:59:36", "12:59:35"
    })
    void runTestYellowLight(String input) {
        setInput(input);

        run(trafficLightExtraMode, METHOD_NAME, STRING_TO_DEL);

        printOut();

        assertTrue(getOutput().contains("Yellow light"));
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "23:59:40", "15:59:44", "07:59:48", "00:59:52",
        "21:12:41", "13:59:45", "05:59:49", "01:59:53",
        "19:34:42", "11:59:46", "03:59:50", "10:59:54",
        "17:25:43", "09:59:47", "23:59:51", "12:59:40"
    })
    void runTestRedLight(String input) {
        setInput(input);

        run(trafficLightExtraMode, METHOD_NAME, STRING_TO_DEL);

        printOut();

        assertTrue(getOutput().contains("Red light"));
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "24:00:00", "00:60:01", "00:01:60", "01:0:00", "3:59:59",
        "3:59:9", "359:59", "35959", "asd", ":59:59"
    })
    void runTestInvalidArg(String input) {
        setInput(input);

        run(trafficLightExtraMode, METHOD_NAME, STRING_TO_DEL);

        assertTrue(getOutput().contains("Only hh:mm:ss input format (hh < 24, mm < 60, ss < 60)"));
    }
}