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
            String output = "";
            while (input.hasNext()) {
                output = output.concat(input.nextLine().replace(",", "") + "\n");
            }
            output = output.replace(".", "").trim();
            System.out.println(output);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    public void run2() {
        StringBuilder contents = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(GLOBAL_PATH))) {
            String check;
            String space = "";
            while ((check = reader.readLine()) != null) {
                contents.append(space);
                contents.append(check.replaceAll("[,.]", ""));
                space = "\n";
            }
            System.out.println(contents);
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
