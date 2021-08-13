package homework_4.custom_file_reader;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import static org.junit.jupiter.api.Assertions.*;


class CustomFileReaderTest {

    @Test
    void testRightCaseFileReaderCustomFileReader() {
        CustomFileReader cfr = new CustomFileReader();
        String str = null;

        try {
            str = cfr.readFileFileReader("src/main/resources/custom_file_reader.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        final String actual = cfr.replaceDotsCommas(str);

        assertEquals(getExpectedText(), actual);
    }

    @Test
    void testWrongCaseFileReaderCustomFileReader() {
        CustomFileReader cfr = new CustomFileReader();
        assertThrows(IOException.class, () -> cfr.readFileFileReader("src/main/resources/custom_file_reader1.txt"));
    }

    @Test
    void testRightCaseInChannelCustomFileReader() {
        CustomFileReader cfr = new CustomFileReader();
        String str = null;
        RandomAccessFile file = null;
        try {
            file = cfr.getFile("src/main/resources/custom_file_reader.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            str = cfr.readFileInChannel(file);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String str2 = cfr.replaceDotsCommas(str);

        final String actual = cfr.replaceDotsCommas(str);

        assertEquals(getExpectedText(), actual);
    }

    @Test
    void testWrongCase1InChannelCustomFileReader() {
        CustomFileReader cfr = new CustomFileReader();
        assertThrows(FileNotFoundException.class, () -> cfr.getFile("src/main/resources/custom_file_reader1.txt"));
    }

    @Test
    void testWrongCase2InChannelCustomFileReader() {
        CustomFileReader cfr = new CustomFileReader();
        assertThrows(NullPointerException.class, () -> cfr.readFileInChannel(null));
    }

    @Test
    void testRightCaseInputStreamCustomFileReader() {
        CustomFileReader cfr = new CustomFileReader();
        String str = null;

        try {
            str = cfr.readFileInputStream("src/main/resources/custom_file_reader.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        final String actual = cfr.replaceDotsCommas(str);

        assertEquals(getExpectedText(), actual);
    }

    @Test
    void testWrongCase1InputStreamCustomFileReader() {
        CustomFileReader cfr = new CustomFileReader();
        assertThrows(IOException.class, () -> cfr.readFileInputStream("src/main/resources/custom_file_reader1.txt"));
    }

    @Test
    void testWrongCase2InputStreamCustomFileReader() {
        CustomFileReader cfr = new CustomFileReader();
        assertThrows(NullPointerException.class, () -> cfr.readFileInputStream(null));
    }

    private String getExpectedText() {
        return "You think I'm delirious with malaria?" + '\r' + '\n' +
                '\r' + '\n' +
                "This happened" + '\r' + '\n' +
                "In Odessa this happened" + '\r' + '\n' +
                '\r' + '\n' +
                "\"I'll come at four\" promised Maria" + '\r' + '\n' +
                '\r' + '\n' +
                "Eight" + '\r' + '\n' +
                "Nine" + '\r' + '\n' +
                "Ten" + '\r' + '\n' +
                '\r' + '\n' +
                "Soon after" + '\r' + '\n' +
                "The evening" + '\r' + '\n' +
                "Frowning" + '\r' + '\n' +
                "And Decemberish" + '\r' + '\n' +
                '\r' + '\n' +
                "Left the windows" + '\r' + '\n' +
                "And vanished in dire darkness" + '\r' + '\n' +
                '\r' + '\n' +
                "Behind me I hear the neighing and laughter" + '\r' + '\n' +
                "Of candelabras" + '\r' + '\n' +
                '\r' + '\n' +
                "You wouldn't recognize me if you knew me prior:" + '\r' + '\n' +
                "A bulk of sinews" + '\r' + '\n' +
                "Moaning" + '\r' + '\n' +
                "Fidgeting" + '\r' + '\n' +
                "What can such a clod desire?" + '\r' + '\n' +
                "But a clod desires many things";
    }
}