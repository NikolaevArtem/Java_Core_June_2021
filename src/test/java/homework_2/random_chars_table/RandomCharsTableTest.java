package homework_2.random_chars_table;


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
        int [][] twoDimArray = {{65, 77}, {87, 90}, {78, 81}};
        rct.setTable(twoDimArray);

        final StringBuilder actualPrinting = rct.getStrForPrinting();
        final StringBuilder actualPrintingByStrategy = rct.getStrForPrintingByStrategy(rct.getStrategy());
        final StringBuilder expectedPrinting = new StringBuilder("|A|M|" + "\n" + "|W|Z|" + "\n" + "|N|Q|" + "\n");
        final StringBuilder expectedPrintingByStrategy = new StringBuilder("Odd letters: A, M, W, Q");

        assertEquals(actualPrinting.toString(), expectedPrinting.toString());
        assertEquals(actualPrintingByStrategy.toString(), expectedPrintingByStrategy.toString());
    }

    @Test
    void test2() { //EVEN
        RandomCharsTable rct = new RandomCharsTable();

        rct.setLength(3);
        rct.setWidth(2);
        rct.setStrategy(RandomCharsTable.Strategy.EVEN);
        int [][] twoDimArray = {{65,77}, {87,90}, {78,81}};
        rct.setTable(twoDimArray);

        final StringBuilder actualPrinting = rct.getStrForPrinting();
        final StringBuilder actualPrintingByStrategy = rct.getStrForPrintingByStrategy(rct.getStrategy());
        final StringBuilder expectedPrinting = new StringBuilder("|A|M|" + "\n" + "|W|Z|" + "\n" + "|N|Q|" + "\n");
        final StringBuilder expectedPrintingByStrategy = new StringBuilder("Even letters: Z, N");

        assertEquals(actualPrinting.toString(), expectedPrinting.toString());
        assertEquals(actualPrintingByStrategy.toString(), expectedPrintingByStrategy.toString());
    }

    @Test
    void test3() {
        RandomCharsTable rct = new RandomCharsTable();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            rct.setParameters(new String[] {"3", "4", "odd", "ODD"});
        });
    }

    @Test
    void test4() {
        RandomCharsTable rct = new RandomCharsTable();

        Assertions.assertThrows(NumberFormatException.class, () -> {
            rct.setParameters(new String[] {"3", "j", "ODD"});
        });
    }

    @Test
    void test5() {
        RandomCharsTable rct = new RandomCharsTable();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            rct.setParameters(new String[] {"3", "-2", "EVEN"});
        });
    }

    @Test
    void test6() {
        RandomCharsTable rct = new RandomCharsTable();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            rct.setParameters(new String[] {"3", "2", "eeven"});
        });
    }
}
