package homework_4.custom_file_reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import static java.lang.System.lineSeparator;

public class CustomFileReader {
    private static final String FILE_NAME = "src/main/resources/custom_file_reader/Shakespeare.txt";
    private static final String ERROR_MESSAGE = "Can not read file.";
    private static final File FILE = new File(FILE_NAME);

    public void run1() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                printMessage(trimDotsAndCommas(line) + lineSeparator());
            }
        } catch (IOException e) {
            printMessage(ERROR_MESSAGE);
        }
    }

    public void run2() {
        try {
            Scanner scanner = new Scanner(FILE);
            while (scanner.hasNextLine()) {
                printMessage(trimDotsAndCommas(scanner.nextLine()) + lineSeparator());
            }
        } catch (FileNotFoundException e) {
            printMessage(ERROR_MESSAGE);
        }
    }

    public void run3() {
        try {
            String data = new String(Files.readAllBytes(Paths.get(FILE_NAME)));
            printMessage(trimDotsAndCommas(data));
        } catch (IOException e) {
            printMessage(ERROR_MESSAGE);
        }
    }

    private void printMessage(String message) {
        System.out.print(message);
    }

    private String trimDotsAndCommas(String line){
        return line.replace(".", "").replace(",", "");
    }
}