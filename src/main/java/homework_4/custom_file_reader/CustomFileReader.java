package homework_4.custom_file_reader;

import homework_4.custom_annotation.CustomAnnotation;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class CustomFileReader {
    String fileName;

    public CustomFileReader(String fileName) {
        this.fileName = fileName;
    }

    public void run() {

        for (Method m : this.getClass().getDeclaredMethods()) {
            if (m.isAnnotationPresent(CustomAnnotation.class)) {
                CustomAnnotation ca = m.getAnnotation(CustomAnnotation.class);
                String fullPath = ca.path() + fileName;
                try {
                    m.invoke(this, fullPath);
                } catch (IllegalArgumentException e) {
                    System.out.println("IllegalArgumentException: " + e.getMessage());
                }
                catch (IllegalAccessException e) {
                    System.out.println("IllegalAccessException: " + e.getMessage());
                }
                catch (InvocationTargetException e) {
                    System.out.println("InvocationTargetException: " + e.getMessage());
                }
            }
        }
    }

    @CustomAnnotation(path = "/custom_file_reader/")
    public void run1(String path) {

        try (
                InputStream inputStream = this.getClass().getResourceAsStream(path);
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                Stream<String> lines = bufferedReader.lines();
        ) {
            lines.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("IO Exception: " + e.getMessage());
        }
    }

    @CustomAnnotation
    public void run2(String path) {
        try (
                FileReader fileReader = new FileReader(path);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                Stream<String> lines = bufferedReader.lines();
        ) {
            lines.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

    }

    @CustomAnnotation
    public void run3(String path) {
        try (
                BufferedReader bufferedReader = Files.newBufferedReader(
                        Paths.get(path)
                );
                Stream<String> lines = bufferedReader.lines();
        ) {
            lines.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("IO Exception: " + e.getMessage());
        }
    }
}
