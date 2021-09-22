package homework_4.custom_file_reader;

import java.io.*;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class CustomFileReader {
    private File file;
    private String filePath;

    public CustomFileReader() throws FileNotFoundException {
        file = new File("src/main/resources/custom_file_reader/file.txt");
        filePath = "src/main/resources/custom_file_reader/file.txt";
    }

    public CustomFileReader(String path) throws FileNotFoundException {
        file = new File(path);
        filePath = path;
    }

    public void printResult(String result) {
        System.out.println(result.replaceAll("[,.]", ""));
    }

    /**
     * Using Scanner
     */
    public void run1() throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        StringBuilder result = new StringBuilder();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            result.append(line)
                    .append("\n");
        }
        printResult(result.toString());
    }

    /**
     * Using BufferedReader
     */
    public void run2() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result.append(line)
                        .append("\n");
            }
            printResult(result.toString());
        }
    }

    /**
     * NIO
     */
    public void run3() throws IOException {
        Path path = Paths.get(filePath);
        List<String> lines = Files.readAllLines(path,StandardCharsets.UTF_8);
        StringBuilder result = new StringBuilder();
        for(String line : lines){
            result.append(line)
                    .append("\n");
        }
        printResult(result.toString());
    }

}
