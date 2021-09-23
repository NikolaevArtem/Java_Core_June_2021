package homework_4.custom_file_reader;

import java.io.*;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CustomFileReader {
    private final String filePath = "src/main/resources/custom_file_reader/test_file";
    public void run1() {
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

      try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
          StringBuilder string = new StringBuilder();

          while (reader.ready()) {
              string.append(reader.readLine()).append("\n");
          }
          String resul = string.toString().replaceAll("[,.]", "");
          System.out.println(resul);
      }
    }

    public void run3() throws IOException {

        try(FileReader reader = new FileReader(filePath)) {
            StringBuffer stringBuffer = new StringBuffer();

            while (reader.ready()) {
                int scan = reader.read();
                if (scan == ',' || scan == '.') {

                } else {
                    stringBuffer.append((char) scan);
                }
            }
            System.out.println(stringBuffer);
        }
    }

    //test helper
    public void changeFileText(String text) throws IOException {
        try(FileWriter writer = new FileWriter(filePath)) {
            if (text == null) return;
            writer.write(text);
        }
    }

}
