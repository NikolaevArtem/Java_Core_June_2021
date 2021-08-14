package Homework2.Traffic_Light;

import base.UnitBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrafficLightTest extends UnitBase {
    static TrafficLight trafficLight;

    @BeforeAll
    public void init(){
        trafficLight = new TrafficLight();
    }

    @Test
    void getTrafficLightTest() {
        trafficLight.getTrafficLight(0);


    }


    @Test
    void runTest() {
    }
}