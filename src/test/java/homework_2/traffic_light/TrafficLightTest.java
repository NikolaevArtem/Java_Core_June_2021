package homework_2.traffic_light;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class TrafficLightTest {

    @Test
    void test1() {
        TrafficLight trl = new TrafficLight();

        try {
            trl.setTrafficLightColour(11);
        } catch (TrafficLight.WrongSecondsException e) {
        }
        final String actual = trl.getTrafficLightColour().toString();
        final String expected = "GREEN";
        assertEquals(actual, expected);
    }

    @Test
    void test2() {
        TrafficLight trl = new TrafficLight();

        try {
            trl.setTrafficLightColour(37);
        } catch (TrafficLight.WrongSecondsException e) {
        }
        final String actual = trl.getTrafficLightColour().toString();
        final String expected = "YELLOW";
        assertEquals(actual, expected);
    }

    @Test
    void test3() {
        TrafficLight trl = new TrafficLight();

        try {
            trl.setTrafficLightColour(53);
        } catch (TrafficLight.WrongSecondsException e) {
        }
        final String actual = trl.getTrafficLightColour().toString();
        final String expected = "RED";
        assertEquals(actual, expected);
    }

    @Test
    void test4() {
        TrafficLight trl = new TrafficLight();
        Assertions.assertThrows(TrafficLight.WrongSecondsException.class, () -> {
            trl.setTrafficLightColour(-37);
        });
    }

    @Test
    void test5() {
        TrafficLight trl = new TrafficLight();
        Assertions.assertThrows(TrafficLight.WrongSecondsException.class, () -> {
            trl.setTrafficLightColour(86401);
        });
    }
}