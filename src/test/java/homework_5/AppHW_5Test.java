package homework_5;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppHW_5Test extends UnitBase {

    @Test
    void clearDataTest() {
        String input_data = "default";
        setInput(input_data);

        AppHW_5 appHW_5 = new AppHW_5();
        appHW_5.readData();
        appHW_5.clearData();
        assertEquals("", appHW_5.getData());
    }

    @Test
    void readDataTest() {
        String input_data = "default";
        setInput(input_data);

        AppHW_5 appHW_5 = new AppHW_5();
        appHW_5.readData();

        assertEquals(input_data, appHW_5.getData());
    }

    @Test
    void checkTest() {
        String input_data = "default";
        setInput(input_data);

        AppHW_5 appHW_5 = new AppHW_5();
        appHW_5.readData();

        assertTrue(appHW_5.check());
    }

    @Test
    void closeReaderTest() {
        String input_data = "default";
        setInput(input_data);

        AppHW_5 appHW_5 = new AppHW_5();
        appHW_5.closeReader();

        assertFalse(appHW_5.readData());
    }

    @Test
    void getDataTest() {
        assertEquals("", new AppHW_5().getData());
    }

    @Test
    void getDataTest2() {
        String input_data = "default";
        setInput(input_data);

        AppHW_5 appHW_5 = new AppHW_5();
        appHW_5.readData();

        assertEquals("default", appHW_5.getData());
    }

    @Test
    void getDataInvalidTest() {
        String input_data = "default";
        setInput(input_data);

        AppHW_5 appHW_5 = new AppHW_5();
        appHW_5.readData();

        assertNotEquals("def", appHW_5.getData());
    }
}