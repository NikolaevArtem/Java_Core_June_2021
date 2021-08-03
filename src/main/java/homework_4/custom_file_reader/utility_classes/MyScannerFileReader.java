package homework_4.custom_file_reader.utility_classes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyScannerFileReader extends AbstractFileReader {

    @Override
    public String getFileContent(File file) {
        Path path = Paths.get(file.getPath());
        try (Scanner scanner = new Scanner(path)) {
            List<String> stringList = new ArrayList<>();
            while (scanner.hasNextLine()) {
                stringList.add(scanner.nextLine());
            }
            fillFileContent(stringList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileContent;
    }
}
