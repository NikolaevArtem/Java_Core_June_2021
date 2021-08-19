package homework_4.custom_file_reader.utility_classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class InputStreamReaderFileReader extends AbstractFileReader {

    @Override
    public String getFileContent(File file) {
        try (InputStreamReader inputStreamReader = new java.io.InputStreamReader(new FileInputStream(file.getPath()), StandardCharsets.UTF_8)) {
            StringBuilder fileCSB = new StringBuilder();
            int i;
            while ((i = inputStreamReader.read()) != -1) {
                fileCSB.append((char) i);
            }
            fileContent = fileCSB.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileContent;
    }
}
