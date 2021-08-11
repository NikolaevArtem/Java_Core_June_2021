package homework_4.custom_file_reader.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;


public class NIOFileRead implements FileReadability {

    @Override
    public String fileReader(String dirPath, String fileName) {
        File textFile;
        try {
            textFile = new File(dirPath + fileName);
            List<String> lines;
            lines = Files.readAllLines(textFile.toPath());
            StringBuilder stringBuilder = new StringBuilder();
            lines.forEach(line -> stringBuilder.append(line).append("\n"));
            return String.valueOf(stringBuilder);
        } catch (IOException e) {
            return null;
        }
    }

}
