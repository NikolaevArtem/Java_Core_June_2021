package homework_4.custom_file_reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class CustomFileReader {

    private static final String PATH = "src/main/resources/custom_file_reader/input.txt";

    public CustomFileReader() {
    }

    public void run1() {
        File file = new File(PATH);
        try (Scanner scanner = new Scanner(file)) {
            String string = scanner.nextLine();
            String replace = string.replace(".", "");
            System.out.println(replace.replace(",", ""));
        } catch (FileNotFoundException ignore) {
        }
    }

    public void run2() {
        Path path = Paths.get(PATH);
        try (Stream<String> stream = Files.lines(path)) {
            String result = stream
                    .flatMapToInt(CharSequence::chars)
                    .filter(c -> c != 44 && c != 46)
                    .mapToObj(i -> (char) i)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();
            System.out.println(result);
        } catch (IOException ignore) {
        }
    }

    public void run3() {
        File file = new File(PATH);
        try (FileReader fileReader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            String replace = line.replace(".", "");
            System.out.println(replace.replace(",", ""));
        } catch (IOException e) {
        }

    }
}
