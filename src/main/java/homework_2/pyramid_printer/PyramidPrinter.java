package homework_2.pyramid_printer;

import homework_1.Start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PyramidPrinter implements Start {

    @Override
    public void start() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int pyramid = Integer.parseInt(reader.readLine());
            char[] arr = new char[pyramid];
            while (true) {
                for (int i = 0; i < pyramid; i++) {
                    arr[i] = 'x';
                    System.out.println(arr);
                }
                break;
            }
        } catch (NumberFormatException e ) {
            System.out.println("Please use number");
            return;
        } finally {
            reader.close();
        }
    }
}
