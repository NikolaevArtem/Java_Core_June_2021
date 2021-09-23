package homework_4.custom_file_reader;

import homework_4.custom_file_reader.utility_classes.*;
import homework_4.custom_file_reader.utility_classes.InputStreamReaderFileReader;

import java.io.*;

public class CustomFileReader {

    private String fileContent;
    private File fileReader;

    public CustomFileReader() {
        fileReader = new File("./src/main/resources/custom_file_reader/file.txt");
    }

    public CustomFileReader(String filePath) {
        fileReader = new File(filePath);
    }

    public CustomFileReader(File file) {
        fileReader = file;
    }

    public String getFileContent() {
        return fileContent;
    }

    private void run(AbstractFileReader reader) {
        if (fileReader.exists()) {
            fileContent = reader.getFileContent(fileReader);
            printResult();
        } else {
            System.out.println("File not found in path");
        }
    }

    //used NIO
    public void run1() {
        this.run(new NIOFileReader());
    }

    //used FileInputStream (only end)
    public void run2() {
        this.run(new FileInputStreamFileReader());
    }

    //used InputStreamReaderFileReader
    public void run3() {
        this.run(new InputStreamReaderFileReader());
    }

    //used Scanner
    public void run4() {
        this.run(new ScannerFileReader());
    }

    //used BufferedReader
    public void run5() {
        this.run(new BufferedReaderFileReader());
    }

    private void printResult() {
        System.out.println(fileContent.replaceAll("[.,]", ""));
    }
}
