package Homework2.Pyramid_Printer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PyramidPrinter {
    public static int size;
    public static final char X = 'x';
    public static final char SPACE = ' ';

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            size = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        char[][] twoDimArray = new char[size][size];


        if (size == 0) {
            return;
        } else {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (i < j) {
                        twoDimArray[i][j] = SPACE;
                    } else {
                        twoDimArray[i][j] = X;
                    }
                }
            }

        }
        for (char[] c : twoDimArray) {
            System.out.println(c);
        }
    }
}
