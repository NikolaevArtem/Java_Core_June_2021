package homework_4.custom_file_reader;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.*;
import java.util.Scanner;
import java.util.stream.Stream;

public class CustomFileReader {

    private static final String FILE_NOT_FOUND_MESSAGE = "File not found";
    private static final String PATH_TO_FILE = "src/main/resources/custom_file_reader/";

    private final String sourceFile;

    public CustomFileReader() {
        String defaultFileName = "file.txt";
        sourceFile = PATH_TO_FILE + defaultFileName;
    }

    public CustomFileReader(String fileName) {
        sourceFile = PATH_TO_FILE + fileName;
    }

    public void run1() {
        readByByte();
    }
    
    public void run2() {
        readBytesInBuffer();
    }
    
    public void run3() {
        readCharsInBuffer();
    }

    public void run4() {
        readCharsFromCharacterStream();
    }
    
    public void run5() {
        readWithScanner();
    }

    public void run6() {
        readWithNIO();
    }

    public void run7() {
        readWithNIO2();
    }

    private void readByByte() {
        try (FileInputStream inputStream = new FileInputStream(sourceFile)) {
            int charsAvailable = inputStream.available();
            StringBuilder readText = new StringBuilder();
            while (charsAvailable > 0) {
                char next = (char) inputStream.read();
                if ((next != '.') && (next != ',')) {
                    readText.append(next);
                }
                charsAvailable--;
            }
            System.out.println(readText);
        } catch (FileNotFoundException exc) {
            System.out.println(FILE_NOT_FOUND_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readBytesInBuffer() {
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(
                new FileInputStream(sourceFile))) {
            int charsAvailable = bufferedInputStream.available();
            byte[] input = new byte[charsAvailable];
            int byteRead = bufferedInputStream.read(input);
            if (byteRead != -1) {
                String readText = new String(input);
                readText = removePunctuation(readText);
                System.out.println(readText);
            }
        } catch (FileNotFoundException exc) {
            System.out.println(FILE_NOT_FOUND_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readCharsInBuffer() {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(sourceFile)))) {
            String readText = reader.readLine();
            while (readText != null) {
                readText = removePunctuation(readText);
                System.out.println(readText);
                readText = reader.readLine();
            }
        } catch (FileNotFoundException exc) {
            System.out.println(FILE_NOT_FOUND_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readCharsFromCharacterStream() {
        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile))) {
            String readText = reader.readLine();
            while (readText != null) {
                readText = removePunctuation(readText);
                System.out.println(readText);
                readText = reader.readLine();
            }
        } catch (FileNotFoundException exc) {
            System.out.println(FILE_NOT_FOUND_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readWithScanner() {
        try (Scanner scanner = new Scanner(new File(sourceFile))) {
            while (scanner.hasNext()) {
                String readText = scanner.nextLine();
                readText = removePunctuation(readText);
                System.out.println(readText);
            }
        } catch (FileNotFoundException e) {
            System.out.println(FILE_NOT_FOUND_MESSAGE);
        }
    }

    private void readWithNIO() {
        try (FileChannel fileChannel = new FileInputStream(sourceFile).getChannel()) {
            int availableBytes = (int) fileChannel.size();
            ByteBuffer buffer = ByteBuffer.allocate(availableBytes);
            fileChannel.read(buffer);
            String readText = new String(buffer.array());
            readText = removePunctuation(readText);
            System.out.println(readText);
        } catch (FileNotFoundException exc) {
            System.out.println(FILE_NOT_FOUND_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readWithNIO2() {
        Path path = Paths.get(sourceFile);
        try (Stream<String> lines = Files.lines(path)) {
            lines.map(n -> n = n.replaceAll("[,.]", ""))
                    .forEach(System.out::println);
        } catch (NoSuchFileException exc) {
            System.out.println(FILE_NOT_FOUND_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String removePunctuation(String text) {
        return text.replace(".", "").replace(",", "");
    }
}
