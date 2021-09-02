package homework_2.random_chars_table;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputRandomCharsReader {

    public String bufferReaderConsoleForRandom() {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            return reader.readLine();
        } catch(IOException ex) {
            System.out.println("System Error");
            return "";
        }
    }
}
