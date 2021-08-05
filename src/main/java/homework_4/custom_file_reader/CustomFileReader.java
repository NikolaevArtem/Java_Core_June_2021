package homework_4.custom_file_reader;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomFileReader {

    private static final String PATH_TO_FILE = "\\src\\main\\resources\\custom_file_reader\\";

    public void run1(String filename) {
        isCorrectFilename(filename);
        List<String> data = new ArrayList<>();
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(getPath(filename))))){
            String line;
            while ((line = bf.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException exception){
            System.out.println("Error occurred");
        }
        System.out.println(String.join("", data).replaceAll("[,.]", ""));
    }

    public void run2(String filename) {
        isCorrectFilename(filename);
        try{
            Files.lines(Path.of(getPath(filename))).map(x->x.replaceAll("[,.]","")).forEach(System.out::println);
        } catch (IOException exception){
            System.out.println("Error occurred");
        }
    }

    public void run3(String filename){
        isCorrectFilename(filename);
        try {
            Scanner scanner = new Scanner(new FileReader(getPath(filename)));
            List<String> data = new ArrayList<>();
            while(scanner.hasNextLine()){
                data.add(scanner.nextLine());
            }
            System.out.println(String.join("", data).replaceAll("[,.]", ""));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private String getPath(String fileName){
        return Paths.get("").toAbsolutePath() + PATH_TO_FILE + fileName;
    }

    private boolean isCorrectFilename(String filename) {
        if (!(filename.endsWith(".txt"))) {
            throw new IllegalArgumentException();
        } else {
            return filename.endsWith(".txt");
        }
    }
}
