package homework_4.custom_file_reader;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Scanner;

public class CustomFileReader {
    private String fileName;
    private String pathToResources;

    public CustomFileReader() {
        this.fileName = "custom_file_reader/custom_file_reader.txt";
        this.pathToResources = "src/main/resources/";
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public void setPathToResources(String pathToResources) { this.pathToResources = pathToResources; }


    // BufferedReader approach
    public void run1() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(getFileFromResources()))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                printLineWithoutDotsAndCommas(line);
            }
        } catch (NullPointerException | IOException e) {
            System.out.println("File not found");
        }
    }


    // NOI approach
    public void run2() {
        Path path = Paths.get(pathToResources + fileName);

        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                printLineWithoutDotsAndCommas(line);
            }
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }


    // Scanner approach
    public void run3() {
        try (Scanner scanner = new Scanner(getFileFromResources())) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                printLineWithoutDotsAndCommas(line);
            }
        } catch (FileNotFoundException | NullPointerException e) {
            System.out.println("File not found");
        }
    }

    private File getFileFromResources() throws NullPointerException {
        ClassLoader classLoader = getClass().getClassLoader();
        return new File(Objects.requireNonNull(classLoader.getResource(fileName)).getFile());
    }

    private void printLineWithoutDotsAndCommas(String line) {
        System.out.println(line.replace(",", "").replace(".", ""));
    }
}
