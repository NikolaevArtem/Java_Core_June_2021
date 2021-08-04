package homework_4.custom_file_reader;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CustomFileReader {
    public void run() {
        Path filePath = Paths.get("main/resources/custom_file_reader/test_file.txt");

        if (Files.exists(filePath)) {
            try {
                byte[] bytes = Files.readAllBytes(filePath);
                String text = new String(bytes, StandardCharsets.UTF_8);

                System.out.println(text);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void run2() {

    }

    public void run3() {

    }
}
