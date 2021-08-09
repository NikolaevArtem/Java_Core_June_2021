package homework_4.custom_file_reader;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/custom_file_reader/text.txt");
        file.createNewFile();
        new CustomFileReader().run1();
        new CustomFileReader().run2();
        new CustomFileReader().run3();
    }
}
