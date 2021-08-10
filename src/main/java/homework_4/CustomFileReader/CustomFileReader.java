package homework_4.CustomFileReader;

import java.io.*;
import java.nio.file.*;

public class CustomFileReader {
    String fileName = "src/main/resources/custom_file_reader/custom_file.txt";
    private final File file = new File(fileName);

    public void run1() {

        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            int i;
            while ((i = fileInputStream.read()) != -1){
                if ( (char) i == '\u002C' || (char) i == '\u002E' ) {
                    continue;
                }
                System.out.print( (char) i);
            }
            System.out.println();

        } catch (FileNotFoundException e) {
            errorMsg();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run2() {

        try (FileReader fileReader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String replacedStr = line.replaceAll("[.,]+", "");
                System.out.println(replacedStr);
            }
        } catch (FileNotFoundException e) {
            errorMsg();
        } catch (IOException e) {
            errorMsg();
            e.printStackTrace();
        }
    }


    public void run3() {
        Path path = Paths.get(fileName);

        try {
            Files.readAllLines(path)
                    .stream().map(line -> line.replaceAll("[,.]+", ""))
                    .forEach(System.out::println);
        } catch (NoSuchFileException e) {
            errorMsg();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void errorMsg() {
        System.out.println("File not found");
    }

}
