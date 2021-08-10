package homework_4.customFileReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class CustomFileReader {

    private static final String filename = "src/main/resources/custom_file_reader/file.txt";
    private final StringBuilder result = new StringBuilder("");

    public String run1() {

        try(FileReader reader = new FileReader(filename)){
            int ch;
            while ((ch = reader.read()) != -1){
                char x = (char)ch;
                if (x == '.' || x == ',') {
                    continue;
                }
                result.append(x);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(result);
        return result.toString();
    }

    public String run2() {

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.replaceAll("[,.]", "");
                result.append(line + "\n");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(result);
        return result.toString();
    }

    public String run3(){

        Path path = Paths.get(filename);

        try (Scanner scanner =  new Scanner(path)){
            String line;
            while (scanner.hasNextLine()){
                line = scanner.nextLine().replaceAll("[,.]", "");
                result.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(result);
        return result.toString();
    }

    public String run4(){

        String content;
        Path path = Paths.get(filename);

        try {
            content = new String(Files.readAllBytes(path));
            content = content.replaceAll("[,.]", "");
            result.append(content);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(result);
        return result.toString();
    }
}
