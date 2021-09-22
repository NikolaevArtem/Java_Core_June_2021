package homework_4.custom_file_reader.utils;

import java.io.*;


public class BufferedReaderAsStreamFileRead implements FileReadability {

    @Override
    public String fileReader(String dirPath, String fileName) {
        try (final FileInputStream fileInputStream = new FileInputStream(dirPath + fileName);
             final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream))) {
            final StringBuilder stringBuilder = new StringBuilder(fileInputStream.available());
            while (bufferedReader.ready()) {
                stringBuilder.append(bufferedReader.readLine()).append("\n");
            }
            return String.valueOf(stringBuilder);
        } catch (IOException e) {
            return null;
        }
    }

}
