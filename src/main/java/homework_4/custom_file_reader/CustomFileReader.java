package homework_4.custom_file_reader;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class CustomFileReader {

    public void run1() {
        String str;

        try {
            str = readFileFileReader("src/main/resources/custom_file_reader.txt");
            String str2 = replaceDotsCommas(str);
            print(str2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run2() {
        String str;
        RandomAccessFile file = null;

        try {
            file = getFile("src/main/resources/custom_file_reader.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            str = readFileInChannel(file);
            String str2 = replaceDotsCommas(str);
            print(str2);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run3() {
        String str;

        try {
            str = readFileInputStream("src/main/resources/custom_file_reader.txt");
            String str2 = replaceDotsCommas(str);
            print(str2);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readFileFileReader(String path) throws IOException {
        StringBuilder strb = new StringBuilder();

        try (FileReader reader = new FileReader(path)) {
            int i;

            while ((i = reader.read()) != -1) {
                strb.append((char) i);
            }
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }

        return strb.toString();
    }

    public RandomAccessFile getFile (String path) throws FileNotFoundException {
        RandomAccessFile file;

        try {
            file = new RandomAccessFile(path, "r");
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException(e.getMessage());
        }

        return file;
    }

    public String readFileInChannel(RandomAccessFile file) throws IOException {
        FileChannel channel = file.getChannel();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        int bufferSize = 1024;
        if (bufferSize > channel.size()) {
            bufferSize = (int) channel.size();
        }
        ByteBuffer buff = ByteBuffer.allocate(bufferSize);

        while (channel.read(buff) > 0) {
            out.write(buff.array(), 0, buff.position());
            buff.clear();
        }
        String fileContent = new String(out.toByteArray(), StandardCharsets.UTF_8);
        file.close();
        out.close();
        channel.close();

        return fileContent;
    }

    public String readFileInputStream(String path) throws IOException {
        StringBuilder strb = new StringBuilder();
        FileInputStream fileInputStream = new FileInputStream(path);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream, 200);

        int i;
        while ((i = bufferedInputStream.read()) != -1) {
            strb.append((char) i);
        }
        fileInputStream.close();
        bufferedInputStream.close();

        return strb.toString();
    }

    public String replaceDotsCommas(String str) {
        String str2 = str.replaceAll("\\.", "");
        return str2.replaceAll(",", "");
    }

    public void print(String str) {
        System.out.println(str);
    }
}
