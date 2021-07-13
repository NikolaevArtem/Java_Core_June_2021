package homework_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PyramidPrinter {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int pyramid = Integer.parseInt(reader.readLine());
        char[] arr = new char[pyramid];
        while (true) {
            for (int i = 0; i < pyramid; i++) {
                arr[i] = 'x';
                System.out.println(arr);
            }
            break;
        }
    }
}
