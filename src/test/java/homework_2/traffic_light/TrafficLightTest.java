package homework_2.traffic_light;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.Constants.ERROR_MESSAGE_EXCEED_LIMIT_TRAFFIC_LIGHT;
import static utils.Constants.ERROR_MESSAGE_TRAFFIC_LIGHT;
import static utils.Constants.GREEN_MESSAGE_TRAFFIC_LIGHT;
import static utils.Constants.INFO_MESSAGE_TO_EXTRA_MODE_TRAFFIC_LIGHT;
import static utils.Constants.INFO_MESSAGE_TRAFFIC_LIGHT;
import static utils.Constants.RED_MESSAGE_TRAFFIC_LIGHT;
import static utils.Constants.YELLOW_MESSAGE_TRAFFIC_LIGHT;

public class TrafficLightTest extends UnitBase {

    void run() {
        new TrafficLight().run();
        removeFromOutput(INFO_MESSAGE_TRAFFIC_LIGHT);
        printOut();
    }

    void runExtraMode() {
        new TrafficLightExtraMode().run();
        removeFromOutput(INFO_MESSAGE_TO_EXTRA_MODE_TRAFFIC_LIGHT);
        printOut();
    }

    @Test
    void givenSecondsRemainderFrom0To34_whenRun_thenPrintGreenLight() {
        setInput("315");
        run();
        assertEquals(GREEN_MESSAGE_TRAFFIC_LIGHT, getOutput());
    }

    @Test
    void givenSecondsRemainderFrom35To39Or55To59_whenRun_thenPrintYellowLight() {
        setInput("37");
        run();
        assertEquals(YELLOW_MESSAGE_TRAFFIC_LIGHT, getOutput());
    }

    @Test
    void givenSecondsRemainderFrom40To54_whenRun_thenPrintRedLight() {
        setInput("174");
        run();
        assertEquals(RED_MESSAGE_TRAFFIC_LIGHT, getOutput());
    }

    @Test
    void givenNaN_whenRun_thenPrintIncorrectFormatMessage() {
        setInput("word");
        run();
        assertEquals(ERROR_MESSAGE_TRAFFIC_LIGHT, getOutput());
    }

    @Test
    void givenNegativeNumber_whenRun_thenPrintNegativeNumberMessage() {
        setInput("-600");
        run();
        assertEquals(ERROR_MESSAGE_TRAFFIC_LIGHT, getOutput());
    }

    @Test
    void givenExceedLimitSeconds_whenRun_thenPrintExceedLimitMessage() {
        setInput("87000");
        run();
        assertEquals(ERROR_MESSAGE_EXCEED_LIMIT_TRAFFIC_LIGHT, getOutput());
    }

    @Test
    void givenExceedLimitTimeString_whenRun_thenPrintExceedLimitMessage() {
        setInput("28:15:18");
        runExtraMode();
        assertEquals(ERROR_MESSAGE_EXCEED_LIMIT_TRAFFIC_LIGHT, getOutput());
    }

    @Test
    void givenNegativeNumberTimeString_whenRun_thenPrintNegativeNumberMessage() {
        setInput("-18:25:31");
        runExtraMode();
        assertEquals(ERROR_MESSAGE_TRAFFIC_LIGHT, getOutput());
    }

    @Test
    void givenWrongFormatTimeString_whenRun_thenPrintIncorrectFormatMessage() {
        setInput("29-17-16");
        runExtraMode();
        assertEquals(ERROR_MESSAGE_TRAFFIC_LIGHT, getOutput());
    }

    @Test
    void givenTimeStringForGreen_whenRun_thenPrintGreenLight() {
        setInput("13:24:12");
        runExtraMode();
        assertEquals(GREEN_MESSAGE_TRAFFIC_LIGHT, getOutput());
    }

    @Test
    void givenTimeStringForYellow_whenRun_thenPrintYellowLight() {
        setInput("18:37:39");
        runExtraMode();
        assertEquals(YELLOW_MESSAGE_TRAFFIC_LIGHT, getOutput());
    }

    @Test
    void givenTimeStringForRed_whenRun_thenPrintRedLight() {
        setInput("08:13:52");
        runExtraMode();
        assertEquals(RED_MESSAGE_TRAFFIC_LIGHT, getOutput());
    }
}
