package homework_4.custom_file_reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CustomFileReader {

    private final Path path = Paths.get("src/main/resources/file.txt");
    private final String lineSeparator = System.lineSeparator();
    private String resultString = "";

    public final void run1() {
        try {
            //using nio's File class wrapper
            resultString = String.join(lineSeparator, Files.readAllLines(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        EditAndPrintResult();
    }

    public final void run2() {
        //using core IO + streams
        try (BufferedReader reader = new BufferedReader(new FileReader(path.toAbsolutePath().toString()))) {
            resultString = reader.lines().collect(Collectors.joining(lineSeparator));
            EditAndPrintResult();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public final void run3() {
        //using core IO + Scanner
        try (FileReader reader = new FileReader(path.toAbsolutePath().toString())) {
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    break;
                }
                resultString += line + lineSeparator;
            }
            EditAndPrintResult();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void EditAndPrintResult() {
        resultString = resultString.replaceAll("[.,]", ""); //not the fastest way but readable
        System.out.println(resultString);
    }

}
