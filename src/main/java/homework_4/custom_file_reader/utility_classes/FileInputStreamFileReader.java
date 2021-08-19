package homework_4.custom_file_reader.utility_classes;

import java.io.*;
public class FileInputStreamFileReader extends AbstractFileReader {

    @Override
    public String getFileContent(File file) {
        try (FileInputStream fileInputStream = new FileInputStream(file.getPath())) {
            StringBuilder fileCSB = new StringBuilder();
            int i;
            while ((i = fileInputStream.read()) != -1) {
                fileCSB.append((char) i);
            }
            fileContent = fileCSB.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileContent;
    }
}
