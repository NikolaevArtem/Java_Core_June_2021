package homework_4.customFileReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class CustomFileReader {

    private final String filename;

    private final StringBuilder result = new StringBuilder();

    public CustomFileReader(String filename) {
        this.filename = filename;
    }

    // using FileReader
    public void run1() throws IOException {

        try (FileReader reader = new FileReader(filename)) {
            int ch;
            while ((ch = reader.read()) != -1) {
                char x = (char) ch;
                if (x == '.' || x == ',') {
                    continue;
                }
                result.append(x);
            }
        }
        System.out.println(result);
    }


    // using BufferedReader
    public void run2() throws IOException {

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.replaceAll("[,.]", "");
                result.append(line + "\n");
            }
        }
        System.out.println(result);
    }

    // using Scanner
    public void run3() throws IOException {

        try (Scanner scanner = new Scanner(Paths.get(filename))) {
            String line;
            while (scanner.hasNextLine()) {
                line = scanner.nextLine().replaceAll("[,.]", "");
                result.append(line + "\n");
            }
        }
        System.out.println(result);
    }

    // using Files.readAllBytes
    public void run4() throws IOException {

        String content = new String(Files.readAllBytes(Paths.get(filename)));
        content = content.replaceAll("[,.]", "");
        result.append(content);
        System.out.println(result);
    }

}
