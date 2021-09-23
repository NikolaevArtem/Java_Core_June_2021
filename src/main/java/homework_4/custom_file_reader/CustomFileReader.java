package homework_4.custom_file_reader;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CustomFileReader {
    //reading file with BufferedReader
    public void run1() {
        try (BufferedReader in = new BufferedReader(new FileReader(new File("src/main/resources/custom_file_reader/input.txt")))) {
            String str;
            while ((str = in.readLine()) != null) {
                System.out.println(str.replaceAll("[,.]", ""));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    //reading file with nio Files.readAllLines
    public void run2() {
        Path path = Paths.get("src/main/resources/custom_file_reader/input.txt");
        List<String> list = null;
        try {
            list = Files.readAllLines(path);

            for (String str : list)
                System.out.println(str.replaceAll("[,.]", ""));
        }
        catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    //reading a file with BufferedInputStream and FileInputStream
    public void run3() {
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream("src/main/resources/custom_file_reader/input.txt"))) {
            int i;

            while ((i = in.read()) != -1) {
                if ((char)i != ',' && (char)i != '.')
                    System.out.print((char)i);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
