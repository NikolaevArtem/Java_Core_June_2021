package homework_4.custom_file_reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.function.Consumer;

public class CustomFileReader {
    private static String FILE_PATH = "custom_file_reader" + File.separator + "file";
    private static final Consumer<String> FUNCTION = x -> System.out.println(x.replaceAll("[,.]", ""));

    public static void run1() throws IOException {
            new Scanner(getFileURL().openStream()).useDelimiter("\n").forEachRemaining(FUNCTION);
    }

    public static void run2() throws IOException {
        new BufferedReader(new InputStreamReader(getFileURL().openStream())).lines().forEach(FUNCTION);
    }
    //The resource URL is not working in the JAR
    public static void run3() throws IOException {
        Files.lines(Paths.get(getFileURL().getPath())).forEach(FUNCTION);
    }
    //The resource URL is not working in the JAR
    public static void run4() throws IOException {
        Files.readAllLines(Paths.get(getFileURL().getPath())).forEach(FUNCTION);
    }

    private static URL getFileURL() {
        return ClassLoader.getSystemResource(FILE_PATH);
    }

    public static String getFilePath() {
        return FILE_PATH;
    }

    public static void setFilePath(String filePath) {
        FILE_PATH = filePath;
    }

}
