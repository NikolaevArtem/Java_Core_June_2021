package homework_2;

import homework_2.traffic_light.TrafficLightExtraMode;
import org.junit.jupiter.api.Test;

import static homework_2.traffic_light.TrafficLightExtraMode.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrafficLightExtraModeTest extends TrafficLightTest {

    @Override
    @Test
    void getGreenTest() {
        setInput("11:08:5");

        new TrafficLightExtraMode().run();
        printOut();
        removeFromOutput(START_MESSAGE);

        assertEquals(GREEN_VALUE + "GREEN" + RESET, getOutput());
    }

    @Override
    @Test
    void getYellowTest() {
        setInput("09:18:36");

        new TrafficLightExtraMode().run();
        printOut();
        removeFromOutput(START_MESSAGE);

        assertEquals(YELLOW_VALUE + "YELLOW" + RESET, getOutput());
    }

    @Override
    @Test
    void getRedTest() {
        setInput("01:59:49");

        new TrafficLightExtraMode().run();
        printOut();
        removeFromOutput(START_MESSAGE);

        assertEquals(RED_VALUE + "RED" + RESET, getOutput());
    }

    @Override
    @Test
    void nullInputTest() {
        setInput("00:00:00");

        new TrafficLightExtraMode().run();
        printOut();
        removeFromOutput(START_MESSAGE);

        assertEquals(GREEN_VALUE + "GREEN" + RESET, getOutput());
    }

    @Override
    @Test
    void charInputTest() {
        setInput("14:08:t");

        new TrafficLightExtraMode().run();
        printOut();
        removeFromOutput(START_MESSAGE);

        assertEquals(ERROR_MESSAGE, getOutput());
    }

    @Override
    @Test
    void stringInputTest() {
        setInput("string");

        new TrafficLightExtraMode().run();
        printOut();
        removeFromOutput(START_MESSAGE);

        assertEquals(ERROR_MESSAGE, getOutput());
    }

    @Override
    @Test
    void tooBigInputTest() {
        setInput("24:01:00");

        new TrafficLightExtraMode().run();
        printOut();
        removeFromOutput(START_MESSAGE);

        assertEquals(ERROR_MESSAGE, getOutput());
    }

    @Test
    void wrongTimeParametersNumberTest() {
        setInput("04:58");

        new TrafficLightExtraMode().run();
        printOut();
        removeFromOutput(START_MESSAGE);

        assertEquals(ERROR_MESSAGE, getOutput());
    }

    @Test
    void wrongTimeFormatTest() {
        setInput("04:61:89");

        new TrafficLightExtraMode().run();
        printOut();
        removeFromOutput(START_MESSAGE);

        assertEquals(ERROR_MESSAGE, getOutput());
    }

}
