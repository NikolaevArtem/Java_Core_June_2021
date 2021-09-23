package homework_4.custom_file_reader;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class CustomFileReader {

    private final String fileName = "src/main/resources/custom_file_reader";

    public void run1() throws IOException {
        try (FileReader fileReader = new FileReader(fileName)) {
            int charCode;
            while ((charCode = fileReader.read()) != -1) {
                processAndPrintChar(charCode);
            }
            System.out.println();
        }
    }

    public void run2() throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
            int charCode;
            while ((charCode = fileInputStream.read()) != -1) {
                processAndPrintChar(charCode);
            }
            System.out.println();
        }
    }

    public void run3() throws IOException {
        RandomAccessFile file = new RandomAccessFile(fileName, "r");
        FileChannel fileChannel = file.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate((int) fileChannel.size());
        while (fileChannel.read(byteBuffer) > 0) {
            String content = new String(byteBuffer.array(), StandardCharsets.UTF_8);
            content = content.replaceAll("[.,]", "");
            System.out.println(content);
            byteBuffer.clear();
        }
        fileChannel.close();
        file.close();
    }

    private void processAndPrintChar(int charCode) {
        char ch = (char) charCode;
        if (ch != ',' && ch != '.') {
            System.out.print(ch);
        }
    }

}
