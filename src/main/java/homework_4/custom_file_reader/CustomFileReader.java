package homework_4.custom_file_reader;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import static java.nio.file.Files.readAllLines;

public class CustomFileReader {
    private String filepath;

    public CustomFileReader(){
        this.filepath = "src/main/resources/custom_file_reader/custom_file.txt";
    }

    public void myPath(String path){
        this.filepath = path;
    }

    //NIO
    public void run1(){
        Path filePath = Paths.get(filepath);

            try(Stream<String> lines = Files.lines(filePath)) {
                lines.map(n -> n = n.replaceAll("[.,]" , ""))
                        .forEach(n -> System.out.println(n));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    public void run2() {
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line = br.readLine();

            while (line != null) {
                String res = line.replaceAll("[,.]" , "");
                System.out.println(res);
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run3(){
        try(FileInputStream inputStream = new FileInputStream(filepath)) {
            int i = -1;
            StringBuilder text = new StringBuilder();
            while((i = inputStream.read()) != -1){
                char simbol = (char) i;
                if((simbol != '.') && (simbol != ','))
                    text.append(simbol);
            }
            System.out.println(text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
