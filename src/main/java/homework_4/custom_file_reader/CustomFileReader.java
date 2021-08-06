package homework_4.custom_file_reader;

/*
    Custom File Reader realizations provided by 3 methods: run1(), run2(), run3();
    Every realization is encapsulated;
    There are different ways to get access to file and read it.
    run1(): using FileInputStream, BufferedReader, StringBuilder; using FilePath custom annotation for strict file path;
    run2(): using getFileFromResourcesAsStream method returning InputStream and prints it via printModifiedInputStream;
    run3(): using getFileFromResource method returning File and prints it using String Collection in printModifiedFile;
 */

import homework_4.custom_annotation.FilePath;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.util.List;


@FilePath
public class CustomFileReader {

    private final String fileName;

    public CustomFileReader() {
        this.fileName = "custom_file_reader/example.txt";
    }

    public synchronized void run1() throws IOException {
        printModifiedInputStreamWithCustomAnnotation();
    }

    // read file with input stream
    public synchronized void run2() throws IOException {
        try (InputStream inputStream = getFileFromResourcesAsStream(this.fileName)) {
            printModifiedInputStream(inputStream);
        } catch (IOException e) {
            throw new IOException();
        }
    }

    // using NIO
    public synchronized void run3() throws IOException {
        File textFile;
        try {
            textFile = getFileFromResource(this.fileName);
            printModifiedFile(textFile);
        } catch (IOException | URISyntaxException e) {
            throw new IOException();
        }
    }

    private @NotNull InputStream getFileFromResourcesAsStream(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);
        if (inputStream == null) {
            throw new IllegalArgumentException();
        }
        return inputStream;
    }

    private @NotNull File getFileFromResource(String fileName) throws URISyntaxException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException();
        }
        return new File(resource.toURI());
    }

    // fastest file reading realization using FileInputStream and BufferedReader
    // custom annotation implemented for strict path, instead of using method 'getFileFromResourcesAsStream'
    private void printModifiedInputStreamWithCustomAnnotation() throws IOException {
        FilePath filePath = (FilePath) this.getClass().getDeclaredAnnotations()[0];
        try (final FileInputStream fileInputStream = new FileInputStream(filePath.path());
             final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream))) {
            final StringBuilder stringBuilder = new StringBuilder(fileInputStream.available());
            while (bufferedReader.ready()) {
                stringBuilder.append(stringModifier(bufferedReader.readLine())).append("\n");
            }
            System.out.println(stringBuilder);
        } catch (IOException e) {
            throw new IOException();
        }
    }

    private void printModifiedFile(@org.jetbrains.annotations.NotNull File textFile) throws IOException {
        List<String> lines;
        try {
            lines = Files.readAllLines(textFile.toPath());
            lines.forEach(line -> System.out.println(stringModifier(line)));
        } catch (IOException e) {
            throw new IOException();
        }
    }

    private void printModifiedInputStream(InputStream inputStream) throws IOException {
        try (
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            String line;
            while (null != (line = bufferedReader.readLine())) {
                System.out.println(stringModifier(line));
            }
        } catch (IOException e) {
            throw new IOException();
        }
    }

    // returns string without '.' and ',' symbols
    private String stringModifier(String str) {
        return str.replaceAll("[,.]", "");
    }

}
