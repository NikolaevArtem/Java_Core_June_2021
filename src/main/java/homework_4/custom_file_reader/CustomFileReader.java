package homework_4.custom_file_reader;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CustomFileReader {

    private final String PATH = "src/main/resources/custom_file_reader/";
    private final String FILE_NAME = "file.txt";
    private final String filePath;
    private final String ioError = "IO Error";
    private final String fnf = "File is not found";
    private final File file;
    private ArrayList<String> strings;

    public CustomFileReader() {
        filePath = PATH + FILE_NAME;
        file = new File(filePath);
    }

    public CustomFileReader(String fileName) {
        if (fileName == null || fileName.isEmpty()) {
            this.filePath = PATH + FILE_NAME;
        } else {
            this.filePath = PATH + fileName;
        }
        file = new File(filePath);
    }

    public CustomFileReader(String path, String fileName) {
        if (fileName == null || fileName.isEmpty() ||
                path == null || path.isEmpty()) {
            this.filePath = PATH + FILE_NAME;
        } else {
            this.filePath = path + fileName;
        }
        file = new File(filePath);
    }

    //Using CharStream
    public void run1() {
        strings = bufferedFileReader(this.file);
        showStrings(strings);
    }

    //Using BinaryStream
    public void run2() {
        strings = binaryStreamRead(this.file);
        showStrings(strings);
    }

    //Using NIO
    public void run3() {
        strings = nioReader(file);
        showStrings(strings);
    }

    //Using only FileReader
    public void run4() {
        onlyFileReader(file);
    }

    //Using NIO
    public void run5() {
        strings = nioReader2(filePath);
        showStrings(strings);
    }

    //Using Scanner
    public void run6() {
        scannerReader(file);
    }



    private ArrayList<String> bufferedFileReader(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            return (ArrayList<String>) reader.lines().collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            System.out.println(fnf);
            return null;
        } catch (IOException e) {
            System.out.println(ioError);
            return null;
        }
    }

    private ArrayList<String> binaryStreamRead(File file) {
        try (FileInputStream input = new FileInputStream(file)) {
            byte[] bytes = new byte[input.available()];
            for(int i = 0; i < bytes.length; i++) {
                bytes[i] = (byte) input.read();
            }
            return bytesToListOfStrings(bytes);
        } catch (FileNotFoundException e) {
            System.out.println(fnf);
            return null;
        } catch (IOException e) {
            System.out.println(ioError);
            return null;
        }
    }

    private ArrayList<String>  nioReader(File file) {
        try (FileChannel input = new FileInputStream(file).getChannel()) {
            ByteBuffer chars = ByteBuffer.allocate((int) input.size());
            input.read(chars);
            return bytesToListOfStrings(chars.array());
        } catch (FileNotFoundException e) {
            System.out.println(fnf);
            return null;
        } catch (IOException e) {
            System.out.println(ioError);
            return null;
        }
    }

    private void onlyFileReader(File file) {
        try (FileReader reader = new FileReader(file)) {
            int i;
            while((i = reader.read()) != -1) {
                char temp = (char) i;
                if (temp != '.' && temp != ',') {
                    System.out.print(temp);
                }
            }
            System.out.println();
        } catch (FileNotFoundException e) {
            System.out.println(fnf);
        } catch (IOException e) {
            System.out.println(ioError);
        }
    }

    private ArrayList<String> nioReader2(String filePath) {
        try {
            return (ArrayList<String>) Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println(ioError);
            return null;
        }
    }

    private void scannerReader(File file) {
        try (Scanner scn = new Scanner(file)) {
            while(scn.hasNext()) {
                String temp = scn.nextLine();
                System.out.println(temp.replaceAll("[.,]", ""));
            }
        } catch (FileNotFoundException e) {
            System.out.println(fnf);
        }
    }

    private ArrayList<String> deletePunctuation(List<String> list) {
        list = list.stream()
                .map(n -> n = n.replaceAll("[.,]", ""))
                .collect(Collectors.toList());
        return (ArrayList<String>) list;
    }

    private ArrayList<String> bytesToListOfStrings(byte[] bytes) {
        return new ArrayList<>(Arrays.asList(new String(bytes).split("\n")));
    }

    private void showStrings(ArrayList<String> strings) {
        if (strings != null) {
            strings = deletePunctuation(strings);
            strings.forEach(System.out::println);
        }
    }
}
