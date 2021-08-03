package homework_4.custom_file_reader.utility_classes;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ApacheFileReader extends AbstractFileReader {

    @Override
    public String getFileContent(File file) {
        try {
            List<String> contentFileLinesList = FileUtils.readLines(file, "UTF-8");
            fillFileContent(contentFileLinesList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileContent;
    }

}
