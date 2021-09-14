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
    private static final String FILE_PATH = "custom_file_reader" + File.separator + "file";
    private static final Consumer<String> FUNCTION = x -> System.out.println(x.replaceAll("[,.]", ""));

    public static void run() {
        try {
            run1();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            run2();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            run3();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            run4();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void run1() throws IOException {
        Scanner scanner = new Scanner(getFileURL().openStream()).useDelimiter("\n");;
        scanner.forEachRemaining(FUNCTION);
        scanner.close();
    }

    public static void run2() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getFileURL().openStream()));
        bufferedReader.lines().forEach(FUNCTION);
        bufferedReader.close();
    }
    //The resource URL is not working in the JAR
    public static void run3() throws IOException {
        //lines - close stream
        Files.lines(Paths.get(getFileURL().getPath()));
    }
    //The resource URL is not working in the JAR
    public static void run4() throws IOException {
        //readAllLines - close stream
        Files.readAllLines(Paths.get(getFileURL().getPath())).forEach(FUNCTION);
    }

    private static URL getFileURL() {
        return ClassLoader.getSystemResource(FILE_PATH);
    }

}
