package homework_4.custom_file_reader;

import base.UnitBase;
import homework_4.custom_file_reader.utils.DirectoryScan;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;


class CustomFileReaderTest extends UnitBase {

    CustomFileReader customFileReader = new CustomFileReader();
    String correctPath = "./src/main/resources/custom_file_reader/";
    String correctFileName = "file.txt";

    @Test
    void testRun1() {
        customFileReader.run1();
        String result = getOutput();
        assertTrue(checkResult(result));
    }

    @Test
    void testRun2() {
        customFileReader.run2();
        String result = getOutput();
        assertTrue(checkResult(result));
    }

    @Test
    void testRun3() {
        customFileReader.run3();
        String result = getOutput();
        assertTrue(checkResult(result));
    }

    @Test
    void testRun4() {
        customFileReader.run4();
        String result = getOutput();
        assertTrue(checkResult(result));
    }

    @Test
    void testNotValidDataForConstructorWParams() {
        CustomFileReader cfr1 = new CustomFileReader(correctPath, "passwords.txt");
        String expected = "File " + "passwords.txt" + " not found at: " + correctPath;
        cfr1.run1();
        String output = getOutput();
        assertEquals(expected, output);
    }

    @Test
    void testNotValidDataForConstructorWParams2() {
        CustomFileReader cfr1 = new CustomFileReader("./src/", correctFileName);
        String expected = "File " + correctFileName + " not found at: " + "./src/";
        cfr1.run4();
        String output = getOutput();
        System.out.println(output);
        assertEquals(expected, output);
    }

    @Test
    void testEmptyConstructor() {
        new CustomFileReader();
        String notExpected = "File " + correctFileName + " not found at: " + correctPath;
        assertNotEquals(notExpected, getOutput());
    }

    @Test
    void testShowDirMethod() {
        CustomFileReader cfr1 = new CustomFileReader(correctPath, correctFileName);
        cfr1.showDir();
        String output = getOutput();

        File directoryPath = new File(correctPath);
        File[] filesList = directoryPath.listFiles();
        StringBuilder tmp = new StringBuilder();
        tmp.append(correctPath).append(" contains:").append("\n--- --- ---\n");
        assertNotNull(filesList);
        for (File file : filesList) {
            tmp.append(file.getName()).append("\tat: ").append(file.getAbsolutePath()).append("\n").append("---").append("\n");
        }
        tmp.append("--- --- ---");
        String expected = String.valueOf(tmp);
        assertEquals(expected, output);
    }

    @Test
    void testEmptyDir() {
        String hm3testDir = "./src/test/homework_3/";
        String expected = hm3testDir + " is empty!";
        DirectoryScan.scanDir(hm3testDir);
        String output = getOutput();
        assertEquals(expected, output);
    }

    @Test
    void testIsInDir() {
        assertTrue(DirectoryScan.isInDir(correctPath, correctFileName));
    }

    private boolean checkResult(String res) {
        return !(res.contains(".") && res.contains(","));
    }

}
