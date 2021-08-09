package homework_4.custom_file_reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CustomFileReader {

    private final String PATH = "src/main/resources/custom_file_reader/";
    private final String FILE_NAME = "file.txt";
    private final String fullPath;
    private final File file;
    private ArrayList<String> strings;

    public CustomFileReader() {
        fullPath = PATH + FILE_NAME;
        file = new File(fullPath);
    }

    public CustomFileReader(String fileName) {
        if (fileName == null || fileName.isEmpty()) {
            this.fullPath = PATH + FILE_NAME;
        } else {
            this.fullPath = PATH + fileName;
        }
        file = new File(fullPath);
    }

    public CustomFileReader(String path, String fileName) {
        if (fileName == null || fileName.isEmpty() ||
                path == null || path.isEmpty()) {
            this.fullPath = PATH + FILE_NAME;
        } else {
            this.fullPath = path + fileName;
        }
        file = new File(fullPath);
    }

    //Using CharStream
    public void run1() {
        strings = charStreamRead(this.file);
        showStrings(strings);
    }

    //Using BinaryStream
    public void run2() {
        strings = binaryStreamRead(this.file);
        showStrings(strings);
    }

    //Using NIO
    public void run3() {
        strings = nioRead(file);
        showStrings(strings);
    }

    private ArrayList<String> charStreamRead(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            return (ArrayList<String>) reader.lines().collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            System.out.println("There is no file for reading");
            return null;
        } catch (IOException e) {
            System.out.println("IO error");
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
            System.out.println("There is no file for reading");
            return null;
        } catch (IOException e) {
            System.out.println("IO error");
            return null;
        }
    }

    private ArrayList<String>  nioRead(File file) {
        try (FileChannel input = new FileInputStream(file).getChannel()) {
            ByteBuffer chars = ByteBuffer.allocate((int) input.size());
            input.read(chars);
            return bytesToListOfStrings(chars.array());
        } catch (FileNotFoundException e) {
            System.out.println("There is no file for reading");
            return null;
        } catch (IOException e) {
            System.out.println("IO error");
            return null;
        }
    }

    private ArrayList<String> deletePunctuation(List<String> list) {
        list = list.stream()
                .map(n -> n = n.replaceAll("\\.|,", ""))
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
