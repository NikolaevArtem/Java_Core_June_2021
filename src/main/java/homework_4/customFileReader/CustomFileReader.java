package homework_4.customFileReader;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class CustomFileReader {

    private String path;

    public CustomFileReader(String file) {
        this.path = file;
    }

    public void run1() {
        String line;
        try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while((line = reader.readLine()) != null) {
                System.out.println(line.replaceAll("[,.]", ""));
            }

        } catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void run2() {
        StringBuilder line = new StringBuilder();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(path));
            scanner.useDelimiter("");
            while(scanner.hasNext()) {
                line.append(scanner.next());
            }
            System.out.println(line.toString().replaceAll("[,.]", ""));

        } catch(FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if(scanner != null) {
                scanner.close();
            }
        }
    }

    //NIO
    public void run3() {
        Path path = Paths.get(this.path);
        try {
            List<String> read = Files.readAllLines(path);

            for(String list : read) {
                System.out.println(list.replaceAll("[,.]", ""));
            }

        } catch(IOException ex) {
            System.out.println("Internal Error");
        }
    }

}
