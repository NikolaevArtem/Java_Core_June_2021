package homework_2.bufferReaders;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOHelper {

    public int bufferReaderConsole() {
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
        } catch (IOException e) {
            System.out.println ("System error");
            return -1;
        }
    }

    public String bufferReaderConsoleForRandom() {
        try (BufferedReader reader = new BufferedReader (new InputStreamReader (System.in))) {
            return reader.readLine ();
        } catch (IOException ex){
            System.out.println ("System Error");
            return "";
        }
    }

    public int bufferReaderForPyramid() {
        try (BufferedReader reader = new BufferedReader (new InputStreamReader (System.in))) {
            int i = Integer.parseInt (reader.readLine ());
            if (i < 0) {
                System.out.println ("Error, negative numbers are not valid");
            } else {
                return i;
            }
        } catch (NumberFormatException ex) {
            System.out.println ("invalid format data, please enter integer");
        } catch (IOException e) {
            System.out.println ("System Error");
        }
        return 0;
    }

}
