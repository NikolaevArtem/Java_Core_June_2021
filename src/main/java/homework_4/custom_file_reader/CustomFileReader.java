package homework_4.custom_file_reader;

import homework_4.custom_annotation.ClassInfo;
import homework_4.custom_annotation.FilePathCustomAnnotation;
import homework_4.custom_annotation.MethodInfo;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


@ClassInfo(date = "15/08/2021", specification = "Customized FileReader Class")
@FilePathCustomAnnotation
public class CustomFileReader {

    private String filePath = CustomFileReader.class.getAnnotation(FilePathCustomAnnotation.class).path();

    @MethodInfo(description = "NIO2")
    public void run1() {
        Path path = Paths.get(filePath);
        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            String result = bufferedReader.readLine();
            printResult(result);
        } catch (IOException e) {
            e.printStackTrace();
            printErrorMessage();
        }
    }

    @MethodInfo(description = "BufferedReaderFileReader")
    public void run2() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String result = bufferedReader.readLine();
            printResult(result);
        } catch (IOException e) {
            printErrorMessage();
            e.printStackTrace();
        }
    }

    @MethodInfo(description = "InputStreamFileReader")
    public void run3() {
        try (InputStream inputStream = CustomFileReader.class.getResourceAsStream(filePath)) {
            if (inputStream != null) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                    String result = reader.readLine();
                    printResult(result);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            printErrorMessage();
            e.printStackTrace();
        }
    }

    @MethodInfo(description = "ScannerFileReader")
    public void run4() {
        try (Scanner scanner = new Scanner(new File(filePath))) {
            scanner.useDelimiter("[.,]");
            StringBuilder stringBuilder = new StringBuilder();
            while (scanner.hasNext()) {
                stringBuilder.append(scanner.next());
            }
            System.out.println(stringBuilder);
        } catch (FileNotFoundException e) {
            printErrorMessage();
            e.printStackTrace();
        }
    }

    public void printResult(String result) {
        System.out.println(result.replaceAll("[.,]", ""));
    }

    private void printErrorMessage() {
        System.out.println(Messages.FILE_NOT_FOUND_MESSAGE);
    }

}
