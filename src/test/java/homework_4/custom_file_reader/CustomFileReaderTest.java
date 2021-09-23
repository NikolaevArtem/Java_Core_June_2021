package homework_4.custom_file_reader;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomFileReaderTest extends UnitBase {

    private final String FILENAME = "testCustom.txt";

    @Test
    void givenFileName_whenRun_thenFileContentPrintOutFirstMode() {
        new CustomFileReader().run1(FILENAME);
        printOut();

        assertEquals("Linkin park Halestorm The Pretty Reckless Disturbed", getOutputLines()[0]);
        assertNotEquals("TestTestTest", getOutputLines()[0]);
    }

    @Test
    void givenIncorrectFileName_whenRun_thenExceptionThrownFirstMode(){
        String filenameIncorrect = "testCustom";

        assertThrows(IllegalArgumentException.class,()-> new CustomFileReader().run1(filenameIncorrect));
    }

    @Test
    void givenFileName_whenRun_thenFileContentPrintOutSecondMode() {
        new CustomFileReader().run2(FILENAME);
        printOut();

        assertEquals("Linkin park Halestorm The Pretty Reckless Disturbed", getOutputLines()[0]);
        assertNotEquals("TestTestTest", getOutputLines()[0]);
    }

    @Test
    void givenIncorrectFileName_whenRun_thenExceptionThrownSecondMode(){
        String filenameIncorrect = "testCustom";

        assertThrows(IllegalArgumentException.class,()-> new CustomFileReader().run2(filenameIncorrect));
    }

    @Test
    void givenFileName_whenRun_thenFileContentPrintOutThirdMode() {
        new CustomFileReader().run3(FILENAME);
        printOut();

        assertEquals("Linkin park Halestorm The Pretty Reckless Disturbed", getOutputLines()[0]);
        assertNotEquals("TestTestTest", getOutputLines()[0]);
    }

    @Test
    void givenIncorrectFileName_whenRun_thenExceptionThrownThirdMode(){
        String filenameIncorrect = "testCustom";

        assertThrows(IllegalArgumentException.class,()-> new CustomFileReader().run3(filenameIncorrect));
    }

    @Test
    void givenEmptyFileName_whenRun_thenExceptionThrown(){
        String emptyName = " ";

        assertThrows(IllegalArgumentException.class,()-> new CustomFileReader().run3(emptyName));
        assertThrows(IllegalArgumentException.class,()-> new CustomFileReader().run2(emptyName));
        assertThrows(IllegalArgumentException.class,()-> new CustomFileReader().run1(emptyName));
    }


}