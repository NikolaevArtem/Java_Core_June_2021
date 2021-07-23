package homework_2.traffic_light;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrafficLightTest extends UnitBase {

    final String RED_COLOUR = "\u001B[31m";
    final String GREEN_COLOUR = "\u001B[32m";
    final String YELLOW_COLOUR = "\u001B[33m";
    final String RESET_COLOUR = "\u001B[0m";

    @Test
    public void givenSeconds_whenrun_thenPrintTheLight() {
        setInput("10");
        new TrafficLight().run();
        getOutputLines();
        removeFromOutput(TrafficLight.greeting);
        assertEquals(GREEN_COLOUR + "GREEN" + RESET_COLOUR, getOutputLines()[0]);
    }
}
