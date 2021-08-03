package homework_4.custom_file_reader;

import homework_4.custom_file_reader.utility_classes.*;

import java.io.*;

public class CustomFileReader {

    private String fileContent;
    private File fileReader;
    private String filePath = "./src/main/resources/custom_file_reader/testFile.txt";

    public CustomFileReader() {
    }

    public CustomFileReader(String filePath) {
        this.filePath = filePath;
    }

    public CustomFileReader(File file) {
        this.filePath = file.getPath();
    }

    public String getFileContent() {
        return fileContent.toString();
    }

    //used NIO
    public void run1(/*NIO*/) {
        if (isExistsFile(filePath)) {
            fileReader = new File(filePath);
            fileContent = new NIOFileReader().getFileContent(fileReader);
            printResult();
        } else {
            printErrorMessage();
        }
    }

    //used FileInputStream
    public void run2() {
        if (isExistsFile(filePath)) {
            fileReader = new File(filePath);
            fileContent = new FileInputStreamFileReader().getFileContent(fileReader);
            printResult();
        } else {
            printErrorMessage();
        }
    }

    //used Scanner
    public void run3() {
        if (isExistsFile(filePath)) {
            fileReader = new File(filePath);
            fileContent = new MyScannerFileReader().getFileContent(fileReader);
            printResult();
        } else {
            printErrorMessage();
        }
    }

    //used BufferedReader
    public void run4() {
        if (isExistsFile(filePath)) {
            fileReader = new File(filePath);
            fileContent = new BufferedReaderFileReader().getFileContent(fileReader);
            printResult();
        } else {
            printErrorMessage();
        }
    }

    //used GuavaFiles
    public void run5() {
        if (isExistsFile(filePath)) {
            fileReader = new File(filePath);
            fileContent = new GuavaFileReader().getFileContent(fileReader);
            printResult();
        } else {
            printErrorMessage();
        }
    }

    //user ApacheFileUtils
    public void run6() {
        if (isExistsFile(filePath)) {
            fileReader = new File(filePath);
            fileContent = new ApacheFileReader().getFileContent(fileReader);
            printResult();
        } else {
            printErrorMessage();
        }
    }

    private boolean isExistsFile(String filePath) {
        return new File(filePath).exists();
    }

    private void printResult() {
        System.out.println(fileContent.replaceAll("(\\.)|(,)", ""));
    }

    private void printErrorMessage() {
        System.out.println("File not found in path");
    }
}
