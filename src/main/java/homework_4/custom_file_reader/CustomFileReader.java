package homework_4.custom_file_reader;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import static java.nio.charset.StandardCharsets.UTF_8;

public class CustomFileReader {

    private String message;
    private File file;
    private String filePath = "src/main/resources/custom_file_reader/text.txt";

    public void run1() {
        if (isFilePathExist(filePath)) {
            file = new File(filePath);
            Scanner scanner = null;
            try {
                scanner = new Scanner(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            while (scanner.hasNextLine()) {
                message = scanner.nextLine();
                printResult();
            }
        } else {
           printErrorMessage();
        }
    }
    public void run2() {
        if (isFilePathExist(filePath)) {
            file = new File(filePath);
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            while (true) {
                try {
                    if (!reader.ready()) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    message = reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                printResult();
            }
        }
    }

    public void run3() {
        Path file = Paths.get(filePath);
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get(filePath), UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        lines.stream().filter(s -> s.contains(",") || s.contains("."))
                .map(s -> s.replaceAll("(\\.)|(,)", ""))
                .forEach(System.out::println);
    }


    private void printErrorMessage() {
        System.out.println("Error");
    }

    private boolean isFilePathExist(String filePath) {
        return new File(filePath).exists();
    }

    private void printResult() {
        System.out.println(message.replaceAll("(\\.)|(,)", ""));
    }
}
