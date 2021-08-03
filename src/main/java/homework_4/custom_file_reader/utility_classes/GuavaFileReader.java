package homework_4.custom_file_reader.utility_classes;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class GuavaFileReader extends AbstractFileReader {

    @Override
    public String getFileContent(File file) {
        try {
            List<String> stringList = Files.readLines(file, Charsets.UTF_8);
            fillFileContent(stringList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileContent;
    }

}
