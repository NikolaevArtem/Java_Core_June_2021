package homework_4.custom_file_reader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
//        CustomFileReader customFileReader = new CustomFileReader();
//        CustomFileReader.run1();

//        URL url = new URL("https://github.com/NikolaevArtem/Java_Core_June_2021/blob/31540dcd2a47ef8a42bae3e6e03dbbab2dc11241/src/main/resources/custom_file_reader/file.txt");
//        InputStream input = url.openStream();
//        byte[] buffer = input.readAllBytes();
//        String str = new String(buffer);
//        System.out.println(str);

        Path path = Path.of("src/main/resources/custom_file_reader/file.txt");
        List<String> list = Files.readAllLines(path);

        for (String str : list)
            System.out.println(str);
    }


}
