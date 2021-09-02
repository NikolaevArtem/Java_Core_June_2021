package homework_2.traffic_light;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputTrafficLightReader {

    public int bufferReaderConsole() {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int i = Integer.parseInt(reader.readLine());
            if(i < 0) {
                System.out.println("Error, negative numbers are not allowed");
            } else if(i >= 86400) {
                System.out.println("Error, the day is over");
            }
            return i;
        } catch(NumberFormatException ex) {
            System.out.println("Error, invalid data format, please enter integer");
            return -1;
        } catch(IOException e) {
            System.out.println("System error");
            return -1;
        }
    }
}
