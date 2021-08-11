package homework_4.custom_file_reader.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class InputStreamReaderFileRead implements FileReadability {

    @Override
    public String fileReader(String dirPath, String fileName) {
        try (FileInputStream inputStream = new FileInputStream(dirPath + fileName);
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            StringBuilder lines = new StringBuilder();
            String line;
            while (null != (line = bufferedReader.readLine())) {
                lines.append(line).append("\n");
            }
            return String.valueOf(lines);
        } catch (IOException e) {
            return null;
        }
    }

}
