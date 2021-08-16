package homework_4.custom_file_reader;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) {
        try {
            CustomFileReader.run1();
            CustomFileReader.run2();
            //The resource URL is not working in the JAR
            CustomFileReader.run3();
            //The resource URL is not working in the JAR
            CustomFileReader.run4();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
