package homework_2.traffic_light;

import base.UnitBase;
import org.junit.jupiter.api.Test;


import static homework_2.traffic_light.MessageType.ERROR_MESSAGE_EXCEED_LIMIT;
import static homework_2.traffic_light.MessageType.ERROR_MESSAGE_INCORRECT_FORMAT;
import static homework_2.traffic_light.MessageType.ERROR_MESSAGE_NEGATIVE_NUMBERS;
import static homework_2.traffic_light.MessageType.INFO_MESSAGE;
import static homework_2.traffic_light.MessageType.INFO_MESSAGE_TO_MODE_0;
import static homework_2.traffic_light.MessageType.INFO_MESSAGE_TO_MODE_1;
import static homework_2.traffic_light.MessageType.LIGHT_GREEN_MESSAGE;
import static homework_2.traffic_light.MessageType.LIGHT_RED_MESSAGE;
import static homework_2.traffic_light.MessageType.LIGHT_YELLOW_MESSAGE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrafficLightTest extends UnitBase {

    void run() {
        new TrafficLight(0).start();
        removeFromOutput(INFO_MESSAGE.getMessage());
        removeFromOutput(INFO_MESSAGE_TO_MODE_0.getMessage());
        printOut();
    }

    void runExtraMode() {
        new TrafficLight(1).start();
        removeFromOutput(INFO_MESSAGE.getMessage());
        removeFromOutput(INFO_MESSAGE_TO_MODE_1.getMessage());
        printOut();
    }

    @Test
    void givenSecondsRemainderFrom0To34_whenRun_thenPrintGreenLight() {
        setInput("315");
        run();
        assertEquals(LIGHT_GREEN_MESSAGE.getMessage(), getOutput());
    }

    @Test
    void givenSecondsRemainderFrom35To39_whenRun_thenPrintYellowLight() {
        setInput("217");
        run();
        assertEquals(LIGHT_YELLOW_MESSAGE.getMessage(), getOutput());
    }

    @Test
    void givenSecondsRemainderFrom40To59_whenRun_thenPrintRedLight() {
        setInput("538");
        run();
        assertEquals(LIGHT_RED_MESSAGE.getMessage(), getOutput());
    }

    @Test
    void givenNaN_whenRun_thenPrintIncorrectFormatMessage() {
        setInput("word");
        run();
        assertEquals(ERROR_MESSAGE_INCORRECT_FORMAT.getMessage(), getOutput());
    }

    @Test
    void givenNegativeNumber_whenRun_thenPrintNegativeNumberMessage() {
        setInput("-600");
        run();
        assertEquals(ERROR_MESSAGE_NEGATIVE_NUMBERS.getMessage(), getOutput());
    }

    @Test
    void givenExceedLimitSeconds_whenRun_thenPrintExceedLimitMessage() {
        setInput("87000");
        run();
        assertEquals(ERROR_MESSAGE_EXCEED_LIMIT.getMessage(), getOutput());
    }

    @Test
    void givenExceedLimitTimeString_whenRun_thenPrintExceedLimitMessage() {
        setInput("28:15:18");
        runExtraMode();
        assertEquals(ERROR_MESSAGE_EXCEED_LIMIT.getMessage(), getOutput());
    }

    @Test
    void givenNegativeNumberTimeString_whenRun_thenPrintNegativeNumberMessage() {
        setInput("-18:25:31");
        runExtraMode();
        assertEquals(ERROR_MESSAGE_NEGATIVE_NUMBERS.getMessage(), getOutput());
    }

    @Test
    void givenWrongFormatTimeString_whenRun_thenPrintIncorrectFormatMessage() {
        setInput("29-17-16");
        runExtraMode();
        assertEquals(ERROR_MESSAGE_INCORRECT_FORMAT.getMessage(), getOutput());
    }

    @Test
    void givenTimeStringForGreen_whenRun_thenPrintGreenLight() {
        setInput("13:24:12");
        runExtraMode();
        assertEquals(LIGHT_GREEN_MESSAGE.getMessage(), getOutput());
    }

    @Test
    void givenTimeStringForYellow_whenRun_thenPrintYellowLight() {
        setInput("18:37:39");
        runExtraMode();
        assertEquals(LIGHT_YELLOW_MESSAGE.getMessage(), getOutput());
    }

    @Test
    void givenTimeStringForRed_whenRun_thenPrintRedLight() {
        setInput("08:13:52");
        runExtraMode();
        assertEquals(LIGHT_RED_MESSAGE.getMessage(), getOutput());
    }
}
