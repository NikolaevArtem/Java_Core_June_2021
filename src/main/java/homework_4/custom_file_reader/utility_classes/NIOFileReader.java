package homework_4.custom_file_reader.utility_classes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class NIOFileReader extends AbstractFileReader {

    @Override
    public String getFileContent(File file) {
        Path path = Paths.get(file.getPath());
        try {
            List<String> stringList = Files.readAllLines(path);
            fillFileContent(stringList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileContent;
    }
}
