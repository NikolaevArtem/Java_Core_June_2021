package homework_4.CustomFileReader;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class ExtraCustomFileReaderTest extends UnitBase {

    ExtraCustomFileReader extraCustomFileReader = new ExtraCustomFileReader();

    @Test
    void giveFile_whenRun1_thenPrintStrings() {
        extraCustomFileReader.run1();
        assertFalse(getOutput().contains(".") || getOutput().contains(","));
    }

    @Test
    void giveFile_whenRun2_thenPrintStrings() {
        extraCustomFileReader.run2();
        assertFalse(getOutput().contains(".") || getOutput().contains(","));
    }

    @Test
    void giveFile_whenRun3_thenPrintStrings() {
        extraCustomFileReader.run3();
        assertFalse(getOutput().contains(".") || getOutput().contains(","));
    }

    @Test
    void giveWrongDirName_whenRun_thenPrintStrings() {
        if (!(new File(extraCustomFileReader.DIRECTORY).isDirectory())){
            extraCustomFileReader.run1();
            extraCustomFileReader.run2();
            extraCustomFileReader.run3();
            assertEquals("File not found", getOutputLines()[0]);
            assertEquals("File not found", getOutputLines()[1]);
            assertEquals("File not found", getOutputLines()[2]);
        }
    }

}