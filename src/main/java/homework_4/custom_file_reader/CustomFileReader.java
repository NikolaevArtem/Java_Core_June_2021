package homework_4.custom_file_reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class CustomFileReader implements Runnable {
    private static final String FILE_NAME = "src/main/resources/custom_file_reader/Shakespeare.txt";
    private static final File FILE = new File(FILE_NAME);

    @Override
    public void run1() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line.replace(".", "").replace(",", ""));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run2() {
        try {
            Scanner scanner = new Scanner(FILE);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine().replace(".", "").replace(",", ""));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run3() {
        try {
            String data = new String(Files.readAllBytes(Paths.get(FILE_NAME)));
            data = data.replace(".", "").replace(",", "");
            System.out.println(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}