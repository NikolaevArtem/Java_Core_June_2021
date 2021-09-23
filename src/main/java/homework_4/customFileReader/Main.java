package homework_4.customFileReader;

import java.io.IOException;

public class Main {

    private static String filename = "src/main/resources/custom_file_reader/file.txt";

    public static void main(String[] args) throws IOException {
        new CustomFileReader(filename).run1();
        new CustomFileReader(filename).run2();
        new CustomFileReader(filename).run3();
        new CustomFileReader(filename).run4();
    }

}
