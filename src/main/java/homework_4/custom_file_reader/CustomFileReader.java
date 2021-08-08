package homework_4.custom_file_reader;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class CustomFileReader {

    static final String GLOBAL_PATH = "src/main/resources/custom_file_reader/custom.file.reader.txt";

    public void run1() {
        try (Scanner input = new Scanner(new File(GLOBAL_PATH))) {
            String line = input.nextLine().replace(",", "");
            String output = line.replace(".", "");
            System.out.println(output);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    public void run2() {
        StringBuilder contents = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(GLOBAL_PATH))) {
            String file = "";
            while ((file = reader.readLine()) != null) {
                System.out.println(contents.append(file.replaceAll("[,.]", "")));
            }
        } catch (IOException e) {
            System.out.println("File not found.");
        }
    }

    public void run3() {
        Path path = Paths.get(GLOBAL_PATH);
        try {
            List<String> text = Files.readAllLines(path);
            for (String line : text) {
                System.out.println(line.replaceAll("[,.]", ""));
            }
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
}
