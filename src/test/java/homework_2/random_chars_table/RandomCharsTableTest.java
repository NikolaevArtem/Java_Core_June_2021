package homework_2.random_chars_table;


import homework_2.random_chars_table.RandomCharsTable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class RandomCharsTableTest {

    @Test
    void test1() { //ODD
        RandomCharsTable rct = new RandomCharsTable();

        rct.setLength(3);
        rct.setWidth(2);
        rct.setStrategy(RandomCharsTable.Strategy.ODD);
        int [][] twoDimArray = {{65,77}, {87,90}, {78,81}};
        rct.setTable(twoDimArray);

        final StringBuilder actualPrinting = rct.getStrForPrinting();
        final StringBuilder actualPrintingByStrategy = rct.getStrForPrintingByStrategy(rct.getStrategy());
        final StringBuilder expectedPrinting = new StringBuilder("|A|M|" + "\n" + "|W|Z|" + "\n" + "|N|Q|" + "\n");
        final StringBuilder expectedPrintingByStrategy = new StringBuilder("Odd letters: A, M, W, Q");
        assertEquals(actualPrinting, expectedPrinting);
        //assertEquals(actualPrintingByStrategy, expectedPrintingByStrategy);
    }
}
