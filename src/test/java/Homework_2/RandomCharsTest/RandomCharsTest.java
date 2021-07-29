package Homework_2.RandomCharsTest;

import Homework_2.RandomCharsTable.RandomCharsTable;
import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomCharsTest extends UnitBase {

    @Test
    void CaseStandard1_pass() {
        setInput("2 2 even");

        new RandomCharsTable().run();

        printOut();
        removeFromOutput("Enter the sizes of a table and a strategy: ");
        assertEquals("x", getOutputLines()[0]);
        assertEquals("xx", getOutputLines()[1]);
        assertEquals("Even Letters -", getOutputLines()[2]);

    }

//    |L|O|
//            |Y|Z|


}
