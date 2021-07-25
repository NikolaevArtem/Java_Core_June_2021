package homework_2.traffic_light;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrafficLightTest extends UnitBase {

    @Test
    void input_negative_6(){
        setInput("-6");

        new Traffic_light().run();
        assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutputLines()[0]);
    }

    @Test
    void input_0(){
        setInput("0");

        new Traffic_light().run();
        assertEquals("GREEN", getOutputLines()[0]);
    }

    @Test
    void input_5(){
        setInput("5");

        new Traffic_light().run();
        assertEquals("GREEN", getOutputLines()[0]);
    }

    @Test
    void input_35(){
        setInput("35");

        new Traffic_light().run();
        assertEquals("YELLOW", getOutputLines()[0]);
    }

    @Test
    void input_55(){
        setInput("54");

        new Traffic_light().run();
        assertEquals("RED", getOutputLines()[0]);
    }

    @Test
    void input_86401(){
        setInput("86401");

        new Traffic_light().run();
        assertEquals("The day is over", getOutputLines()[0]);
    }

    @Test
    void input_86466(){
        setInput("86466");

        new Traffic_light().run();
        assertEquals("The day is over", getOutputLines()[0]);
    }
}
