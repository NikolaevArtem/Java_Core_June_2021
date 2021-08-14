package homework_4.custom_file_reader;

import homework_4.custom_annotation.FilePath;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

@FilePath
public class CustomFileReader {
    private static final String FILE_PATH = CustomFileReader.class.getAnnotation(FilePath.class).path();


    public void run1() {
        InputStream inputStream = CustomFileReader.class.getResourceAsStream("/custom_file_reader/file.txt");
        if (inputStream != null) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                String result = reader.readLine();
                printResult(result);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void run2() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String result = reader.readLine();
            printResult(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void run3() {
        try (Scanner scanner = new Scanner(new File(FILE_PATH))) {
            scanner.useDelimiter("[.,]");
            StringBuilder stringBuilder = new StringBuilder();
            while (scanner.hasNext()) {
                stringBuilder.append(scanner.next());
            }
            System.out.println(stringBuilder);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //NIO
    public void run4() {
        Path path = Paths.get(FILE_PATH);
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String result = reader.readLine();
            printResult(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printResult(String result) {
        System.out.println(result.replaceAll("[.,]", ""));
    }
}
