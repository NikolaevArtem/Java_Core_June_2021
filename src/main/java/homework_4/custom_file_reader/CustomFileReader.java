package homework_4.custom_file_reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CustomFileReader {

    private final String fileName = "C:\\Users\\Аркадий\\IdeaProjects\\Java_Core_June_2021\\src\\main\\resources\\testCustomFileReader.txt";

    public void run() {

    }

    private void bufferedReader() {
        try (BufferedReader bf = new BufferedReader(new FileReader(fileName))) {


        } catch (IOException exception) {
            System.out.println("Input error occurred");
        }
    }
}
