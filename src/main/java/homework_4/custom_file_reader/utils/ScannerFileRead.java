package homework_4.custom_file_reader.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class ScannerFileRead implements FileReadability {

    @Override
    public String fileReader(String dirPath, String fileName) {
        try (Scanner scanner = new Scanner(new File(dirPath + fileName))) {
            StringBuilder stringBuilder = new StringBuilder();
            while (scanner.hasNextLine()) {
                stringBuilder.append(scanner.nextLine());
                stringBuilder.append("\n");
            }
            return String.valueOf(stringBuilder);
        } catch (FileNotFoundException e) {
            return null;
        }
    }

}
