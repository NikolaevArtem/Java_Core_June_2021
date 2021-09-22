package homework_2.traffic_light;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExtraTrafficLightTest extends TrafficLightTest {

    @Test
    public void given00_00_10_whenRun_thenPrintTheGreenLight() {
        setInput("00:00:10");
        new ExtraTrafficLight().run();
        getOutputLines();
        removeFromOutput(ExtraTrafficLight.greeting);
        assertEquals(GREEN_COLOUR + "GREEN" + RESET_COLOUR, getOutputLines()[0]);
    }

    @Test
    public void given10_10_35_whenRun_thenPrintTheYellowLight() {
        setInput("10:10:35");
        new ExtraTrafficLight().run();
        getOutputLines();
        removeFromOutput(ExtraTrafficLight.greeting);
        assertEquals(YELLOW_COLOUR + "YELLOW" + RESET_COLOUR, getOutputLines()[0]);
    }

    @Test
    public void given23_59_54_whenRun_thenPrintTheRedLight() {
        setInput("23:59:54");
        new ExtraTrafficLight().run();
        getOutputLines();
        removeFromOutput(ExtraTrafficLight.greeting);
        assertEquals(RED_COLOUR + "RED" + RESET_COLOUR, getOutputLines()[0]);
    }
}
