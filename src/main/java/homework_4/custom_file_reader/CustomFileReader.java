package homework_4.custom_file_reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class CustomFileReader {
    final static String FILE_PATH = "custom_file_reader" + File.separator + "file.txt";


    public static void run1() throws IOException {
        System.out.println(FILE_PATH);
        FileInputStream fileInputStream = new FileInputStream(FILE_PATH);
        int i;

        while((i=fileInputStream.read())!= -1){
            System.out.print((char)i);
        }
    }
}
