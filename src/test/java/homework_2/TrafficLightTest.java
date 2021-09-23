package homework_2;

import base.UnitBase;
import homework_2.traffic_light.TrafficLight;
import homework_2.traffic_light.TrafficLightExtraMod;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TrafficLightTest extends UnitBase {

    private final String ANSI_RESET = "\u001b[0m";

    private final String ANSI_RED = "\u001B[31m";

    private final String ANSI_GREEN = "\u001B[32m";

    private final String ANSI_YELLOW = "\u001B[33m";

    @Test
    void given0_whenRun_thenGreenLightPrinted(){
        setInput("0");

        new TrafficLight().run();
        printOut();
        removeFromOutput("Enter necessary amount of seconds");

        Assertions.assertTrue(getOutput().contains("\u001B[32m"));
    }

    @Test
    void given35_whenRun_thenYellowLightPrinted(){
        setInput("35");

        new TrafficLight().run();
        printOut();
        removeFromOutput("Enter necessary amount of seconds");

        Assertions.assertTrue(getOutput().contains("\u001B[33m"));
    }

    @Test
    void given54_whenRun_thenRedLightPrinted(){
        setInput("54");

        new TrafficLight().run();
        printOut();
        removeFromOutput("Enter necessary amount of seconds");

        Assertions.assertTrue(getOutput().contains("\u001B[31m"));
    }

    @Test
    void given863400_whenRun_thenDayIsOverPrinted(){
        setInput("863400");

        new TrafficLight().run();
        printOut();
        removeFromOutput("Enter necessary amount of seconds");

        Assertions.assertTrue(getOutput().contains("Day is over"));
    }

    @Test
    void givenFiveSecTimeFormat_whenRun_thenGreenLightPrinted(){
        setInput("23:25:05");

        new TrafficLightExtraMod().run();
        printOut();
        removeFromOutput("Enter necessary amount of seconds");

        Assertions.assertTrue(getOutput().contains("\u001B[32m"));
    }

    @Test
    void givenThirtyFiveSecTimeFormat_whenRun_thenYellowLightPrinted(){
        setInput("14:54:35");

        new TrafficLightExtraMod().run();
        printOut();
        removeFromOutput("Enter necessary amount of seconds");

        Assertions.assertTrue(getOutput().contains("\u001B[33m"));
    }

    @Test
    void givenFiftyFourSecTimeFormat_whenRun_thenRedLightPrinted(){
        setInput("07:56:54");

        new TrafficLightExtraMod().run();
        printOut();
        removeFromOutput("Enter necessary amount of seconds");

        Assertions.assertTrue(getOutput().contains("\u001B[31m"));
    }

    @Test
    void givenNegativeNumber_whenRun_thenError(){
        setInput("-56");

        new TrafficLight().run();
        printOut();
        removeFromOutput("Enter necessary amount of seconds");

        Assertions.assertTrue(getOutput().contains("Only 1 non-negative integer is allowed as passed parameter"));
    }

    @Test
    void givenNaN_whenRun_thenError(){
        setInput("text");

        new TrafficLight().run();
        printOut();
        removeFromOutput("Enter necessary amount of seconds");

        Assertions.assertTrue(getOutput().contains("Only 1 non-negative integer is allowed as passed parameter"));
    }
}
