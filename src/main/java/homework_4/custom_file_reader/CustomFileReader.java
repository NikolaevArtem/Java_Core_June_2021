package homework_4.custom_file_reader;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;

public class CustomFileReader {

    void run1() {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();

        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String output  = reader.readLine();
            while (output != null) {
                output = output.replace(".", "");
                output = output.replace(",", "");
                System.out.println(output);
                output  = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
