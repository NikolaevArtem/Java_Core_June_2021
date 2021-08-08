package homework_4.custom_file_reader;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        String file = "src/main/resources/custom_file_reader/fileTest.txt";
        Path path = Paths.get("src/main/resources/custom_file_reader/fileTest.txt");
        new CustomFileReader(path).run3();
    }
}
