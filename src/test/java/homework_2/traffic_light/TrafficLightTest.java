package homework_2.traffic_light;

import base.UnitBase;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TrafficLightTest  extends UnitBase {
    private final String GREET = "Enter the time (valid range is from 0 to 86399 ):";
    private final String HINT = "Only 1 non-negative integer is allowed as passed parameter! Please, try again";
    TrafficLight trafficLight = new TrafficLight();

    @Test
    void given0_whenOk_then_Green (){
        setInput("0");
        trafficLight.run();
        printOut();
        removeFromOutput(GREET);
        assertTrue(getOutputLines()[0].contains("GREEN"));
    }

    @Test
    void given5_whenOk_then_Green (){
        setInput("5");
        trafficLight.run();
        printOut();
        removeFromOutput(GREET);
        assertTrue(getOutputLines()[0].contains("GREEN"));
    }

    @Test
    void given35_whenOk_then_Yellow (){
        setInput("35");
        trafficLight.run();
        printOut();
        removeFromOutput(GREET);
        assertTrue(getOutputLines()[0].contains("YELLOW"));
    }

    @Test
    void given54_whenOk_then_Red (){
        setInput("54");
        trafficLight.run();
        printOut();
        removeFromOutput(GREET);
        assertTrue(getOutputLines()[0].contains("RED"));
    }

    @Test
    void given86401_whenOk_then_TheDayIsOver (){
        setInput("86401");
        trafficLight.run();
        printOut();
        removeFromOutput(GREET);
        assertTrue(getOutputLines()[0].contains("The day is over"));
    }


    @Test
    void givenString_whenBad_then_Hint (){
        setInput("Qwe");
        trafficLight.run();
        printOut();
        removeFromOutput(GREET);
        assertEquals(HINT, getOutputLines()[0]);
    }

    @Test
    void givenFractal_whenBad_then_Hint (){
        setInput("2.5");
        trafficLight.run();
        printOut();
        removeFromOutput(GREET);
        assertEquals(HINT, getOutputLines()[0]);
    }

    @Test
    void givenNegative_whenBad_then_Hint (){
        setInput("-5");
        trafficLight.run();
        printOut();
        removeFromOutput(GREET);
        assertEquals(HINT, getOutputLines()[0]);
    }

    @Test
    void givenBigInt_whenBad_then_Hint (){
        setInput("99999999999999999999999999999");
        trafficLight.run();
        printOut();
        removeFromOutput(GREET);
        assertEquals(HINT, getOutputLines()[0]);
    }

}


