package base;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UnitBaseFileMode extends UnitBase {

    public void createAndFillTempFile(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteTempFile(String fileName) {
        try {
            Files.deleteIfExists(Paths.get(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
