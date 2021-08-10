package homework_4.CustomFileReader;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class CustomFileReaderTest extends UnitBase {

    CustomFileReader CustomFileReader = new CustomFileReader();

    @Test
    void giveFile_whenRun1_thenPrintStrings() {
        CustomFileReader.run1();
        assertFalse(getOutput().contains(".") || getOutput().contains(","));
    }

    @Test
    void giveFile_whenRun2_thenPrintStrings() {
        CustomFileReader.run2();
        assertFalse(getOutput().contains(".") || getOutput().contains(","));
    }

    @Test
    void giveFile_whenRun3_thenPrintStrings() {
        CustomFileReader.run3();
        assertFalse(getOutput().contains(".") || getOutput().contains(","));
    }

    @Test
    void giveWrongDirName_whenRun_thenPrintStrings() {
        if (!(new File(CustomFileReader.fileName).isFile())){
            CustomFileReader.run1();
            CustomFileReader.run2();
            CustomFileReader.run3();
            assertEquals("File not found", getOutputLines()[0]);
            assertEquals("File not found", getOutputLines()[1]);
            assertEquals("File not found", getOutputLines()[2]);
        }
    }


}