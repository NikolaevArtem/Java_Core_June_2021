package homework_2.traffic_light;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class TrafficLightTest {

    @Test
    void testGreenCaseTrafficLight()  throws TrafficLight.WrongSecondsException {
        TrafficLight trl = new TrafficLight();
        trl.setTrafficLightColour(11);

        final String actual = trl.getTrafficLightColour().toString();
        final String expected = "GREEN";

        assertEquals(actual, expected);
    }

    @Test
    void testYellowCaseTrafficLight() throws TrafficLight.WrongSecondsException {
        TrafficLight trl = new TrafficLight();
        trl.setTrafficLightColour(37);

        final String actual = trl.getTrafficLightColour().toString();
        final String expected = "YELLOW";

        assertEquals(actual, expected);
    }

    @Test
    void testRedCaseTrafficLight() throws TrafficLight.WrongSecondsException {
        TrafficLight trl = new TrafficLight();
        trl.setTrafficLightColour(53);

        final String actual = trl.getTrafficLightColour().toString();
        final String expected = "RED";

        assertEquals(actual, expected);
    }

    @Test
    void testNegativeSecondsTrafficLight() {
        TrafficLight trl = new TrafficLight();

        Assertions.assertThrows(TrafficLight.WrongSecondsException.class, () -> trl.setTrafficLightColour(-37));
    }

    @Test
    void testTooBigValueSecondsCaseTrafficLight() {
        TrafficLight trl = new TrafficLight();

        Assertions.assertThrows(TrafficLight.WrongSecondsException.class, () -> trl.setTrafficLightColour(86401));
    }
}