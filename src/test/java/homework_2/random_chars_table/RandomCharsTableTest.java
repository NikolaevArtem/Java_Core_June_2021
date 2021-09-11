package homework_2.random_chars_table;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RandomCharsTableTest {

    @Test
    void testOddCaseRandomCharsTable() {
        RandomCharsTable rct = new RandomCharsTable();

        rct.setLength(3);
        rct.setWidth(2);
        rct.setStrategy(RandomCharsTable.Strategy.ODD);
        int [][] twoDimArray = {{65, 77}, {87, 90}, {78, 81}};
        rct.setTable(twoDimArray);

        final StringBuilder actualPrinting = rct.getStrForPrinting();
        final StringBuilder actualPrintingByStrategy = rct.getStrForPrintingByStrategy(rct.getStrategy());
        final String expectedPrinting = "|A|M|" + "\n" + "|W|Z|" + "\n" + "|N|Q|" + "\n";
        final String expectedPrintingByStrategy = "Odd letters: A, M, W, Q";

        assertEquals(actualPrinting.toString(), expectedPrinting);
        assertEquals(actualPrintingByStrategy.toString(), expectedPrintingByStrategy);
    }

    @Test
    void testEvenCaseRandomCharsTable() {
        RandomCharsTable rct = new RandomCharsTable();

        rct.setLength(3);
        rct.setWidth(2);
        rct.setStrategy(RandomCharsTable.Strategy.EVEN);
        int [][] twoDimArray = {{65,77}, {87,90}, {78,81}};
        rct.setTable(twoDimArray);

        final StringBuilder actualPrinting = rct.getStrForPrinting();
        final StringBuilder actualPrintingByStrategy = rct.getStrForPrintingByStrategy(rct.getStrategy());
        final String expectedPrinting = "|A|M|" + "\n" + "|W|Z|" + "\n" + "|N|Q|" + "\n";
        final String expectedPrintingByStrategy = "Even letters: Z, N";

        assertEquals(actualPrinting.toString(), expectedPrinting);
        assertEquals(actualPrintingByStrategy.toString(), expectedPrintingByStrategy);
    }

    @Test
    void testWrongNumberOfParametersCaseRandomCharsTable() {
        RandomCharsTable rct = new RandomCharsTable();
        Assertions.assertThrows(IllegalArgumentException.class, () -> rct.setParameters(new String[] {"3", "4", "odd", "ODD"}));
    }

    @Test
    void testNotANumberInParameterCaseRandomCharsTable() {
        RandomCharsTable rct = new RandomCharsTable();
        Assertions.assertThrows(NumberFormatException.class, () -> rct.setParameters(new String[] {"3", "j", "ODD"}));
    }

    @Test
    void testNegativeNumberInParameterCaseRandomCharsTable() {
        RandomCharsTable rct = new RandomCharsTable();
        Assertions.assertThrows(IllegalArgumentException.class, () -> rct.setParameters(new String[] {"3", "-2", "EVEN"}));
    }

    @Test
    void testWrongStrategyInParameterCaseRandomCharsTable() {
        RandomCharsTable rct = new RandomCharsTable();
        Assertions.assertThrows(IllegalArgumentException.class, () -> rct.setParameters(new String[] {"3", "2", "eeven"}));
    }
}
