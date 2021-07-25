package homework_2.bufferReaders;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferReader {

    public int bufferReaderConsole() throws IOException {
        try (BufferedReader reader = new BufferedReader (new InputStreamReader (System.in))) {

                int i = Integer.parseInt (reader.readLine ());
                if (i < 0) {
                    System.out.println ("Error, negative numbers are not valid");
                } else if (i >= 86400) {
                    System.out.println ("it's a new day...");
                }
                return i;
            } catch (NumberFormatException ex) {
                System.out.println ("Invalid data format, please enter integer");
                return -1;
        }
    }

    public String bufferReaderConsoleForRandom() throws IOException {
        try (BufferedReader reader = new BufferedReader (new InputStreamReader (System.in))) {
            return reader.readLine ();
        }
    }

    public int bufferReaderForPyramid() throws IOException {
        try (BufferedReader reader = new BufferedReader (new InputStreamReader (System.in))) {
            int i = Integer.parseInt (reader.readLine ());
            if (i < 0) {
                System.out.println ("Error, negative numbers are not valid");
            } else {
                return i;
            }
        } catch (NumberFormatException ex) {
            System.out.println ("invalid format data, please enter integer");
        }
        return 0;
    }

}
