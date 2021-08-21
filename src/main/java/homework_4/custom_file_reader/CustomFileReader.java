package homework_4.custom_file_reader;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;


public class CustomFileReader {
    private static final String FILE_PATH = "src/main/resources/custom_file_reader/file.txt";

    public static void run1() throws IOException {
        String content = Files.readString(Path.of(FILE_PATH));
        printWithoutDotAndComma(content);
    }


    public static void run2() throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(FILE_PATH), 300);
        int i;
        while ((i = bufferedInputStream.read()) != -1) {
            printWithoutDotAndComma((char) i);
        }
        bufferedInputStream.close();
    }

    public static void run3() throws IOException {
        FileReader fileReader = new FileReader(FILE_PATH, StandardCharsets.UTF_8);
        int i;
        while ((i = fileReader.read()) != -1) {
            printWithoutDotAndComma((char) i);
        }
        fileReader.close();
    }

    public static void printWithoutDotAndComma(String s) {
        char[] chars = s.toCharArray();
        for (char ch : chars)
            if (ch != '.' && ch != ',')
                System.out.print(ch);
    }

    public static void printWithoutDotAndComma(char ch) {
        if (ch != '.' && ch != ',')
            System.out.print(ch);
    }
}
