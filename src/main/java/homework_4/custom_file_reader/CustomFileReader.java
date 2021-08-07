package homework_4.custom_file_reader;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class CustomFileReader {

    public String file = "src/main/resources/custom_file_reader/fileTest.txt";
    Path path = Paths.get(file);

    public void run1() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder stringBuilder = new StringBuilder();
        String currentLine = reader.readLine();
        while (currentLine != null) {
            stringBuilder.append(currentLine).append("\n");
            currentLine = reader.readLine();
        }
        System.out.println(stringBuilder.toString().replaceAll("[.,]", ""));
        reader.close();

    }

    public void run2() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(file));
        while (scanner.hasNext()) {
            String currentLine = scanner.nextLine();
            String newLine = currentLine.replaceAll("[.,]", "");
            System.out.print(newLine);
        }
        scanner.close();
    }

    public void run3() throws IOException {
        String read = Files.readAllLines(path).get(0);
        System.out.println(read.replaceAll("[,.]", ""));
    }

    public void run4() throws IOException {
        BufferedReader reader = Files.newBufferedReader(path);
        StringBuilder stringBuilder = new StringBuilder();
        String currentLine = reader.readLine();
        while (currentLine != null) {
            stringBuilder.append(currentLine).append("\n");
            currentLine = reader.readLine();
        }
        System.out.println(stringBuilder.toString().replaceAll("[.,]", ""));
        reader.close();
    }

    public void run5() throws IOException {
        RandomAccessFile reader = new RandomAccessFile(file, "r");
        FileChannel channel = reader.getChannel();

        int bufferSize = 1024;
        if (bufferSize > channel.size()) {
            bufferSize = (int) channel.size();
        }
        ByteBuffer buff = ByteBuffer.allocate(bufferSize);
        channel.read(buff);
        buff.flip();

        System.out.println(new String(buff.array()).replaceAll("[,.]", ""));

        channel.close();
        reader.close();
    }
}
