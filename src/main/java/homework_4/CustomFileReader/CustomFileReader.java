package homework_4.CustomFileReader;

import java.io.*;
import java.nio.file.*;

public class CustomFileReader {

    File file = getFile();

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
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void run2() {

        try (FileReader fileReader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String replStr = line.replaceAll("[.,]+", "");
                System.out.println(replStr);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run3() {
        Path path = Paths.get("src/main/resources/custom_file_reader/custom_file.txt");
        try {
            Files.readAllLines(path)
                    .stream().map(line -> line.replaceAll("[,.]+", ""))
                    .forEach(System.out :: println);

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private File getFile() {
        try {
            File dir = new File("src/main/resources/custom_file_reader/");
            File[] files = dir.listFiles();
            file = files[0];
        }
        catch (NullPointerException e) {}
        return file;
    }

}
