package homework.homework_5.power_of_number;


import homework.unit_base.UnitBase;
import homework_5.power_of_number.PowerOfNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PowerOfNumberTest extends UnitBase {
    private final String ERR_MSG = "Only 2 non-negative integers are allowed";
    private PowerOfNumber powerOfNumber = new PowerOfNumber();
    // tested cases : string in input
    //                single integer
    //                three integers
    //                empty input
    //                three args, wrong method string
    //                empty input
    //                double numbers
    //                negative numbers
    //                2 3
    // 10             123 21, result bigger then int

    @Test
    public void givenString_whenRun_thenErrorOccurs() {
        setInput("string");
        powerOfNumber.run();
        removeFromOutput("Enter the number and degree, please, only 2 non-negative integers are allowed:");
        assertEquals(ERR_MSG, getOutput());
    }

    @Test
    public void givenOneInteger_whenRun_thenErrorOccurs() {
        setInput("12");
        powerOfNumber.run();
        removeFromOutput("Enter the number and degree, please, only 2 non-negative integers are allowed:");
        assertEquals(ERR_MSG, getOutput());
    }

    @Test
    public void givenThreeIntegers_whenRun_thenErrorOccurs() {
        setInput("12 12 12");
        powerOfNumber.run();
        removeFromOutput("Enter the number and degree, please, only 2 non-negative integers are allowed:");
        assertEquals(ERR_MSG, getOutput());
    }

    @Test
    public void givenEmptyInput_whenRun_thenErrorOccurs() {
        setInput("");

        removeFromOutput("Enter the number and degree, please, only 2 non-negative integers are allowed:");
        assertThrows(NullPointerException.class, () ->
                new PowerOfNumber().run());
    }

    @Test
    public void givenTwoDoubles_whenRun_thenErrorOccurs() {
        setInput("12.1 12.1");
        powerOfNumber.run();
        removeFromOutput("Enter the number and degree, please, only 2 non-negative integers are allowed:");
        assertEquals(ERR_MSG, getOutput());
    }

    @Test
    public void givenNegativeInInput_whenRun_thenErrorOccurs() {
        setInput("-2 12");
        powerOfNumber.run();
        removeFromOutput("Enter the number and degree, please, only 2 non-negative integers are allowed:");
        assertEquals(ERR_MSG, getOutput());
        removeFromOutput(ERR_MSG);
        setInput("2 -12");
        powerOfNumber.run();
        removeFromOutput("Enter the number and degree, please, only 2 non-negative integers are allowed:");
        assertEquals(ERR_MSG, getOutput());

    }

    @Test
    public void givenTwoAndThree_whenRun_thenErrorOccurs() {
        setInput("2 3");
        powerOfNumber.run();
        removeFromOutput("Enter the number and degree, please, only 2 non-negative integers are allowed:");
        assertEquals("8", getOutput());
    }

    @Test
    public void given123and21_whenRun_thenErrorOccurs() {
        setInput("123 21");
        powerOfNumber.run();
        removeFromOutput("Enter the number and degree, please, only 2 non-negative integers are allowed:");
        assertEquals("77269364466549865653073473388030061522211723", getOutput());
    }


}
