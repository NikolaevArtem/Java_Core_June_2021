package homework_4.custom_file_reader;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class CustomFileReader {

    private final String filePath = "src/main/resources/custom_file_reader/";
    private final String sourceFile;

    public CustomFileReader() {
        String defaultFileName = "defaultInput.txt";
        sourceFile = filePath + defaultFileName;
    }

    public CustomFileReader(String fileName) {
        sourceFile = filePath + fileName;
    }

    void run1() {
        try (FileInputStream inputStream = new FileInputStream(sourceFile)) {
            int charsAvailable = inputStream.available();
            StringBuilder readText = new StringBuilder();
            while (charsAvailable > 0) {
                char next = (char) inputStream.read();
                if ((next != '.') && (next != ',')) {
                    readText.append(next);
                }
                charsAvailable--;
            }
            System.out.println(readText);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void run2() {
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(sourceFile))) {
            int charsAvailable = bufferedInputStream.available();
            byte[] input = new byte[charsAvailable];
            if (bufferedInputStream.read(input) != -1) {
                String readText = new String(input);
                readText = readText.replace(".", "").replace(",", "");
                System.out.println(readText);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void run3() {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(sourceFile)))) {
            String readText = reader.readLine();
            while (readText != null) {
                readText = readText.replace(".", "").replace(",", "");
                System.out.println(readText);
                readText = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void run4() {
        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile))) {
            String readText = reader.readLine();
            while (readText != null) {
                readText = readText.replace(".", "").replace(",", "");
                System.out.println(readText);
                readText = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void run5() {
        try (Scanner scanner = new Scanner(new File(sourceFile))) {
            while (scanner.hasNext()) {
                String readText = scanner.nextLine();
                readText = readText.replace(".", "").replace(",", "");
                System.out.println(readText);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    void run6() {
        Path path = Paths.get(sourceFile);
        try {
            Stream<String> lines = Files.lines(path);
            lines = lines.map(n -> n = n.replaceAll("[,.]", ""));
            lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
