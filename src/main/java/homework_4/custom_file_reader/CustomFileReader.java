package homework_4.custom_file_reader;

import java.io.*;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CustomFileReader {
    public String filePath = "C:\\Java_Core_June_2021\\src\\main\\resources\\custom_file_reader\\test_file";

    public void run() {
        if (filePath == null) return;

        if (Files.exists(Paths.get(filePath))) {
            try {
                byte[] bytes = Files.readAllBytes(Paths.get(filePath));
                String text = new String(bytes, StandardCharsets.UTF_8);
                String resul = text.replaceAll("[,.]", "");
                System.out.println(resul);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void run2() throws IOException {
        if (filePath == null) return;

        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        StringBuilder string = new StringBuilder();

        while (reader.ready()) {
            string.append(reader.readLine()).append("\n");
        }
        reader.close();
        String resul = string.toString().replaceAll("[,.]", "");
        System.out.println(resul);
    }

    public void run3() throws IOException {
        if (filePath == null) return;

        FileReader reader = new FileReader(filePath);
        StringBuffer stringBuffer = new StringBuffer();

        while (reader.ready()) {
            int scan = reader.read();
            if (scan == ',' || scan == '.') {

            } else {
                stringBuffer.append((char) scan);
            }
        }
        reader.close();
        System.out.println(stringBuffer);
    }

    //test helper
    public void changeFileText(String text) throws IOException {
        FileWriter writer = new FileWriter(filePath);
        if (text == null) return;
        writer.write(text);
        writer.close();
    }

}
