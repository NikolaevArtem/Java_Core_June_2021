package homework_4.CustomFileReader;

import java.io.*;
import java.nio.file.*;
import java.util.Objects;

public class ExtraCustomFileReader {

    public String DIRECTORY = "src/main/resources/custom_file_reader";
    private static File file = null;

    public ExtraCustomFileReader(){
        try {
            file = Objects.requireNonNull(new File(DIRECTORY).listFiles())[0];
        }
        catch (NullPointerException e){
            System.out.println("Directory not found");
        }
    }

    public void run1() {
        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream(file);
            int i;
            while ((i = fileInputStream.read()) != -1){
                if ( (char) i == '\u002C' || (char) i == '\u002E' ) {
                    continue;
                }
                System.out.print( (char) i);
            }
            System.out.println();

        } catch (NullPointerException e) {
            errorMsg();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
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
        } catch (NullPointerException e) {
            errorMsg();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void run3() {
        Path dir = Paths.get(DIRECTORY);

        try {
            DirectoryStream<Path> stream = Files.newDirectoryStream(dir);
            Path file = stream.iterator().next();
            Files.readAllLines(file)
                    .stream().map(line -> line.replaceAll("[,.]+", ""))
                    .forEach(System.out::println);
        }
        catch (NoSuchFileException e){
            errorMsg();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void errorMsg() {
        System.out.println("File not found");
    }

}
