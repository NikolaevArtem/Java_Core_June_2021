package homework_4.custom_file_reader;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.function.Consumer;

public class CustomFileReader {
    private static String FILE_PATH = "custom_file_reader/file";
    private static final Consumer<String> FUNCTION = x -> System.out.println(x.replaceAll("[,.]", ""));

    public static void run1() throws IOException {
            new Scanner(getFileURL().openStream()).useDelimiter("\n").forEachRemaining(FUNCTION);
    }

    public static void run2() throws FileNotFoundException {
        new BufferedReader(new FileReader(getFileURL().getFile())).lines().forEach(FUNCTION);
    }

    public static void run3() throws IOException {
        Files.lines(Paths.get(getFileURL().getPath())).forEach(FUNCTION);
    }

    public static void run4() throws IOException {
        Files.readAllLines(Paths.get(getFileURL().getPath())).forEach(FUNCTION);
    }

    private static URL getFileURL() {
        ClassLoader classLoader = CustomFileReader.class.getClassLoader();
        return classLoader.getResource(FILE_PATH);
    }

    public static String getFilePath() {
        return FILE_PATH;
    }

    public static void setFilePath(String filePath) {
        FILE_PATH = filePath;
    }

}
