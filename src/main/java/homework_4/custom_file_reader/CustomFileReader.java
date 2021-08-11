package homework_4.custom_file_reader;

import homework_4.custom_annotation.ResourcesPath;
import homework_4.custom_file_reader.utils.*;

import static homework_4.custom_file_reader.utils.ModifiedStringPrinter.printModifiedString;


public class CustomFileReader {

    private static final String FILE_IS_EMPTY = "File is empty!";

    private final String fileName;
    private final String dirPath;

    @ResourcesPath
    public CustomFileReader() {
        this.fileName = "example.txt";
        String tmpDirPath;
        try {
            ResourcesPath resourcesPath = (ResourcesPath) this.getClass().getConstructor().getDeclaredAnnotations()[0];
            tmpDirPath = resourcesPath.dirPath();
        } catch (NoSuchMethodException e) {
            tmpDirPath = "./src/main/resources/"; // not including custom folder!
        }
        this.dirPath = tmpDirPath;
    }

    public CustomFileReader(String dirPath, String fileName) {
        this.dirPath = dirPath;
        this.fileName = fileName;
    }

    // using scanner
    public synchronized void run1() {
        doExcellent(new ScannerFileRead().fileReader(this.dirPath, this.fileName));
    }

    // using buffered reader
    public synchronized void run2() {
        doExcellent(new BufferedReaderAsStreamFileRead().fileReader(this.dirPath, this.fileName));
    }

    // using nio
    public synchronized void run3() {
        doExcellent(new NIOFileRead().fileReader(this.dirPath, this.fileName));
    }

    // using InputStreamReader
    public synchronized void run4() {
        doExcellent(new InputStreamReaderFileRead().fileReader(this.dirPath, this.fileName));
    }

    // prints all files and subdirectories from set directory
    public void showDir() {
        DirectoryScan.scanDir(this.dirPath);
    }

    private boolean isNotEmpty(String res) {
        return !res.equals("");
    }

    private boolean isNotExists(String res) {
        return res == null;
    }

    private void doExcellent(String result) {
        if (isNotExists(result)) {
            System.out.println("File " + this.fileName + " not found at: " + this.dirPath);
        } else if (isNotEmpty(result)) {
            printModifiedString(result);
        } else System.out.println(FILE_IS_EMPTY);
    }

}
