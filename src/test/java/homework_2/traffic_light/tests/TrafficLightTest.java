package homework_2.traffic_light.tests;

import homework_2.UnitBase;
import homework_2.traffic_light.sources.TrafficLight;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrafficLightTest extends UnitBase {

    @Test
    void testNegative1() {
        setInput("-1");

        new TrafficLight().run();
        printOut();
        removeFromOutput("Please, input seconds gone from the day start: ");
        assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutputLines()[0]);
    }

    @Test
    void testString() {
        setInput("anytext");

        new TrafficLight().run();
        printOut();
        removeFromOutput("Please, input seconds gone from the day start: ");
        assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutputLines()[0]);
    }

    @Test
    void testOverTheDay() {
        setInput("86400");

        new TrafficLight().run();
        printOut();
        removeFromOutput("Please, input seconds gone from the day start: ");
        assertEquals("The day is over", getOutputLines()[0]);
    }

    @Test
    void testZero() {
        setInput("0");

        new TrafficLight().run();
        printOut();
        removeFromOutput("Please, input seconds gone from the day start: ");
        assertEquals("[1;92mGREEN\u001B[0m", getOutputLines()[0]);
    }

    @Test
    void test121() {
        setInput("121");

        new TrafficLight().run();
        printOut();
        removeFromOutput("Please, input seconds gone from the day start: ");
        assertEquals("[1;92mGREEN\u001B[0m", getOutputLines()[0]);
    }

    @Test
    void test86399() {
        setInput("86399");

        new TrafficLight().run();
        printOut();
        removeFromOutput("Please, input seconds gone from the day start: ");
        assertEquals("[1;93mYELLOW\u001B[0m", getOutputLines()[0]);
    }

    @Test
    void test155() {
        setInput("155");

        new TrafficLight().run();
        printOut();
        removeFromOutput("Please, input seconds gone from the day start: ");
        assertEquals("[1;93mYELLOW\u001B[0m", getOutputLines()[0]);
    }

    @Test
    void test101() {
        setInput("101");

        new TrafficLight().run();
        printOut();
        removeFromOutput("Please, input seconds gone from the day start: ");
        assertEquals("[1;91mRED\u001B[0m", getOutputLines()[0]);
    }
}
