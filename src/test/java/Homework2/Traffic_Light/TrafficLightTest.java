package Homework2.Traffic_Light;

import base.UnitBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrafficLightTest extends UnitBase {
    static TrafficLight trafficLight;

    @BeforeAll
    public static void init(){
        trafficLight = new TrafficLight();
    }

    @Test
    void getTrafficLightTestZero() {
        String color = TrafficLightTest.trafficLight.getTrafficLight(0);
        assertEquals("Green", color);
    }

    @Test
    void getTrafficLigthTest(){
        String color = TrafficLightTest.trafficLight.getTrafficLight(357);
        assertEquals("Yellow", color);
    }

    @Test
    void negativeInputNumberTest(){
        assertThrows(IllegalArgumentException.class, () -> TrafficLightTest.trafficLight.getTrafficLight(-6));
    }

    @Test
    void endOfTheDayTest(){
        assertThrows(IllegalArgumentException.class, () -> TrafficLightTest.trafficLight.getTrafficLight(87000));
    }

    @Test
    void runTestZero() {
        setInput("0");
        TrafficLightTest.trafficLight.run();
        String color = getOutput();
        assertEquals("Green", color);
    }

    @Test
    void runTest(){
        setInput("357");
        TrafficLightTest.trafficLight.run();
        String color = getOutput();
        assertEquals("Yellow", color);
    }

    @Test
    void runTestNegative(){
        setInput("-6");
        assertThrows(IllegalArgumentException.class, () -> TrafficLightTest.trafficLight.run());
    }

    @Test
    void runTestEndOfTheDay(){
        setInput("87000");
        assertThrows(IllegalArgumentException.class, () -> TrafficLightTest.trafficLight.run());
    }
}