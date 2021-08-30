package homework_4.custom_file_reader;

import java.awt.datatransfer.StringSelection;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class CustomFileReader {
    private static final String FILE_PATH = "src/main/resources/custom_file_reader/File_for_CustomFileReader_Task.txt";
    private static final String ERROR_MSG = "Something went wrong: can't find the file or can't read it";

//      BufferedReader
    public void run1() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String s;
            while ((s = reader.readLine()) != null) {
                System.out.println(removeDotsAndCommas(s));
            }

        } catch (Exception e) {
            System.out.println(ERROR_MSG);
        }

    }

//      Scanner
    public void run2() {
        try (Scanner scanner = new Scanner(new File(FILE_PATH))) {
            String s;
            while (scanner.hasNextLine()) {
                s = scanner.nextLine();
                System.out.println(removeDotsAndCommas(s));
            }

        } catch (IOException e) {
            System.out.println(ERROR_MSG);
        }

    }

//      NIO
    public void run3() {
        Path path = Paths.get(FILE_PATH);
        try (BufferedReader reader = Files.newBufferedReader(path)){
            String s;
            while ((s = reader.readLine()) != null){
                System.out.println(removeDotsAndCommas(s));
            }
        } catch (IOException e) {
            System.out.println(ERROR_MSG);
        }

    }




    private String removeDotsAndCommas (String s) {
        return s.replaceAll("[,.]", "");
    }

}
