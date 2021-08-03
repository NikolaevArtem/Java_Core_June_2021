package homework_4.custom_file_reader.utility_classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class BufferedReaderFileReader extends AbstractFileReader {

    @Override
    public String getFileContent(File file) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            List<String> stringList = bufferedReader.lines().collect(Collectors.toList());
            fillFileContent(stringList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileContent;
    }
}
