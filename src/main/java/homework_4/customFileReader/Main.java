package homework_4.customFileReader;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    private static String filename = "src/main/resources/custom_file_reader/file.txt";
    private static Path path = Paths.get(filename);

    public static void main(String[] args) throws IOException {
        new CustomFileReader(filename).run1();
        new CustomFileReader(filename).run2();
        new CustomFileReader(path).run3();
        new CustomFileReader(path).run4();
    }
}
