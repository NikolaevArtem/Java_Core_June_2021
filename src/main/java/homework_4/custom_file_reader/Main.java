package homework_4.custom_file_reader;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            CustomFileReader customFileReader = new CustomFileReader();
            customFileReader.run1();
            customFileReader.run2();
            customFileReader.run3();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
