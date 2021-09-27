package homework_4.custom_file_reader;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CustomFileReader {
    private final String ERR_MSG = "File by the path doesn't exists!";
    private String content;
    private File source;
    private String filePath = "./src/main/resources/custom_file_reader/file.txt";

    // Using InputStreams - binary stream
    public void run1() {
        if (fileExists(filePath)) {

            source = new File(filePath);
            StringBuilder stringBuilder = new StringBuilder();
            try (FileInputStream fis = new FileInputStream(filePath)) {
                int i;
                while ((i = fis.read()) != -1) {
                    if (i <= 127) {
                        stringBuilder.append((char) i);
                    }
                }
                content = stringBuilder.toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(ERR_MSG);
        }
        printResult(content);
    }

    // Using Reader - character stream
    public void run2() {
        if (fileExists(filePath)) {
            StringBuilder stringBuilder = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                while (reader.ready()) {
                    int read = reader.read();
                    if (read >= 0 && read <= 127) {
                        stringBuilder.append((char) read);
                    }
                }
                content = stringBuilder.toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(ERR_MSG);
        }
        printResult(content);
    }

    // Using NIO, read bytes from path.
    public void run3() {
        if (fileExists(filePath)) {
            Path path = Paths.get(filePath);
            try {
                byte[] characters = Files.readAllBytes(path);
                StringBuilder stringBuilder = new StringBuilder();
                for (byte by : characters
                ) {
                    if (by >= 0 && by <= 127) {
                        stringBuilder.append((char) by);
                    }
                }
                content = stringBuilder.toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(ERR_MSG);
        }
        printResult(content);
    }

    private boolean fileExists(String filePath) {
        return new File(filePath).exists();
    }

    private void printResult(String content) {
        System.out.println(content.replaceAll("(\\.)|(,)", "").trim());
    }


}
