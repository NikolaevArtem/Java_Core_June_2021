package homework_2.pyramid_printer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputPyramidReader {

    public int bufferReaderForPyramid() {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int i = Integer.parseInt(reader.readLine());
            if(i < 0) {
                System.out.println("Error, negative numbers are not valid");
            } else {
                return i;
            }
        } catch(NumberFormatException ex) {
            System.out.println("Error, only numbers are allowed");
        } catch(IOException e) {
            System.out.println("System Error");
        }
        return 0;
    }
}
