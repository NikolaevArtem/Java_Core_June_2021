package homework_2;

import org.junit.jupiter.api.Test;

import static homework_2.traffic_light.TrafficLight.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrafficLightTest {

    @Test
    void given0(){
        final String expected = GREEN;
        final String actual = showLight(0);

        assertEquals(expected, actual);
    }

    @Test
    void given119(){
        final String expected = YELLOW;
        final String actual = showLight(119);

        assertEquals(expected, actual);
    }
}
