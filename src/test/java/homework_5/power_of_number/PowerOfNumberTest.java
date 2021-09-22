package homework_5.power_of_number;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PowerOfNumberTest extends UnitBase {

    PowerOfNumber powerOfNumber = new PowerOfNumber();


    @Test
    void given2and3_whenRun_then8() {
        setInput("2 3");
        powerOfNumber.run();
        removeFromOutput("Enter 2 positive integer numbers: ");
        removeFromOutput("The number 2 raised to the power 3 equals: ");
        assertEquals("8", getOutputLines()[0]);
    }

    @Test
    void give3and2_whenRun_then9() {
        setInput("3 2");
        powerOfNumber.run();
        removeFromOutput("Enter 2 positive integer numbers: ");
        removeFromOutput("The number 3 raised to the power 2 equals: ");
        assertEquals("9", getOutputLines()[0]);
    }

    @Test
    void given0and0_whenRun_thenReturn() {
        setInput("0 0");
        powerOfNumber.run();
        removeFromOutput("Enter 2 positive integer numbers: ");
        removeFromOutput("The number 0 raised to the power 0 equals: ");
        assertEquals("1", getOutputLines()[0]);
    }

    @Test
    void given0and3_whenRun_thenReturn() {
        setInput("0 3");
        powerOfNumber.run();
        removeFromOutput("Enter 2 positive integer numbers: ");
        removeFromOutput("The number 0 raised to the power 3 equals: ");
        assertEquals("0", getOutputLines()[0]);
    }

    @Test
    void given3and0_whenRun_thenReturn() {
        setInput("3 0");
        powerOfNumber.run();
        removeFromOutput("Enter 2 positive integer numbers: ");
        removeFromOutput("The number 3 raised to the power 0 equals: ");
        assertEquals("1", getOutputLines()[0]);
    }

    @Test
    void givenStringAndNumber_whenRun_thenError() {
        setInput("two 2");
        powerOfNumber.run();
        removeFromOutput("Enter 2 positive integer numbers: ");
        assertEquals("Only 2 non-negative integers are allowed", getOutputLines()[0]);
    }

    @Test
    void giveNegativeAndNumber_whenRun_thenError() {
        setInput("-7 3");
        powerOfNumber.run();
        removeFromOutput("Enter 2 positive integer numbers: ");
        assertEquals("Only 2 non-negative integers are allowed", getOutputLines()[0]);
    }

    @Test
    void givenNumberAndNegative_whenRun_thenError() {
        setInput("5 -2");
        powerOfNumber.run();
        removeFromOutput("Enter 2 positive integer numbers: ");
        assertEquals("Only 2 non-negative integers are allowed", getOutputLines()[0]);
    }

    @Test
    void givenNullString_whenRun_thenError() {
        setInput("");
        powerOfNumber.run();
        removeFromOutput("Enter 2 positive integer numbers: ");
        assertEquals("Only 2 non-negative integers are allowed", getOutputLines()[0]);
    }

    @Test
    void givenEmptyStting_whenRun_thenError() {
        setInput(" ");
        powerOfNumber.run();
        removeFromOutput("Enter 2 positive integer numbers: ");
        assertEquals("Only 2 non-negative integers are allowed", getOutputLines()[0]);
    }

    @Test
    void givenLessParams_whenRun_thenError() {
        setInput("1");
        powerOfNumber.run();
        removeFromOutput("Enter 2 positive integer numbers: ");
        assertEquals("Only 2 non-negative integers are allowed", getOutputLines()[0]);
    }

    @Test
    void giveMoreParams_whenRun_thenError() {
        setInput("1 2 3");
        powerOfNumber.run();
        removeFromOutput("Enter 2 positive integer numbers: ");
        assertEquals("Only 2 non-negative integers are allowed", getOutputLines()[0]);
    }

}