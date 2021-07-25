package Homework2.Pyramid_Printer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        int size = 0;
        PyramidPrinter pyramidPrinter = new PyramidPrinter();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            size = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        char[][] pyramidArray = pyramidPrinter.getPyramidArray(size);

        for (char[] c : pyramidArray) {
            System.out.println(c);
        }
    }
}
