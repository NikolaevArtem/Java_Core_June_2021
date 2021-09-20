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

        if (fileName == null) {
            throw new IllegalArgumentException("Error: filename is null.");
        }

        this.fileName = fileName;
    }

    public void run() {

        for (Method m : this.getClass().getDeclaredMethods()) {
            if (m.isAnnotationPresent(CustomAnnotation.class)) {
                CustomAnnotation ca = m.getAnnotation(CustomAnnotation.class);
                String fullPath = ca.path() + fileName;
                try {
                    m.invoke(this, fullPath);
                } catch (Exception e) {
                    System.out.println("Exception: " + e.getMessage());
                }
            }
        }
    }

    public void run(String methodName) {

        try {
            Method m = this.getClass().getMethod(methodName);
            if (m.isAnnotationPresent(CustomAnnotation.class)) {
                CustomAnnotation ca = m.getAnnotation(CustomAnnotation.class);
                String fullPath = ca.path() + fileName;
                try {
                    m.invoke(this, fullPath);
                } catch (Exception e) {
                    System.out.println("Exception: " + e.getMessage());
                }
            }
        } catch (NoSuchMethodException e) {
            System.out.println("Error:" + e.getMessage());
        }
    }

    @CustomAnnotation(path = "/custom_file_reader/")
    public void run1(String path) {

        if (path == null) {
            throw new IllegalArgumentException("Error: path is null.");
        }

        if (path == "") {
            throw new IllegalArgumentException("Error: path is empty.");
        }

        try (
                InputStream inputStream = this.getClass().getResourceAsStream(path);
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                Stream<String> lines = bufferedReader.lines();
        ) {
            lines.forEach(System.out::println);
        } catch (IOException e) {
            throw new IllegalArgumentException("IO Exception: " + e.getMessage());
        }
    }

    @CustomAnnotation
    public void run2(String path) {

        if (path == null) {
            throw new IllegalArgumentException("Error: path is null.");
        }

        if (path == "") {
            throw new IllegalArgumentException("Error: path is empty.");
        }

        try (
                FileReader fileReader = new FileReader(path);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                Stream<String> lines = bufferedReader.lines();
        ) {
            lines.forEach(System.out::println);
        } catch (Exception e) {
            throw new IllegalArgumentException("Exception: " + e.getMessage());
        }

    }

    @CustomAnnotation
    public void run3(String path) {

        if (path == null) {
            throw new IllegalArgumentException("Error: path is null.");
        }

        if (path == "") {
            throw new IllegalArgumentException("Error: path is empty.");
        }

        try (
                BufferedReader bufferedReader = Files.newBufferedReader(
                        Paths.get(path)
                );
                Stream<String> lines = bufferedReader.lines();
        ) {
            lines.forEach(System.out::println);
        } catch (IOException e) {
            throw new IllegalArgumentException("IO Exception: " + e.getMessage());
        }
    }
}
