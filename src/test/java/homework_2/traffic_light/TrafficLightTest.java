package homework_2.traffic_light;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrafficLightTest extends UnitBase {

    @Test
    void Empty_Input_Error() {
        setInput("");

        new TrafficLight().run();
        printOut();

        assertEquals("Error: integer only", getOutputLines()[0]);
    }

    @Test
    void Negative_Input_Error() {
        setInput("-1");

        new TrafficLight().run();
        printOut();

        assertEquals("Error: positive only", getOutputLines()[0]);
    }

    @Test
    void String_Input_Error() {
        setInput("s");

        new TrafficLight().run();
        printOut();

        assertEquals("Error: integer only", getOutputLines()[0]);
    }


    @Test
    void Int20_Input_Green() {
        setInput("20");

        new TrafficLight().run();
        printOut();

        assertEquals("Green", getOutputLines()[0]);
    }

    @Test
    void Int36_Input_Yellow() {
        setInput("36");

        new TrafficLight().run();
        printOut();

        assertEquals("Yellow", getOutputLines()[0]);
    }

    @Test
    void Int45_Input_Red() {
        setInput("45");

        new TrafficLight().run();
        printOut();

        assertEquals("Red", getOutputLines()[0]);
    }

    @Test
    void Int56_Input_Yellow() {
        setInput("56");

        new TrafficLight().run();
        printOut();

        assertEquals("Yellow", getOutputLines()[0]);
    }


    @Test
    void Int80_Input_Green() {
        setInput("80");

        new TrafficLight().run();
        printOut();

        assertEquals("Green", getOutputLines()[0]);
    }


}
