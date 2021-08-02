package Homework2.Pyramid_Printer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PyramidPrinter {
    public static final char X = 'x';
    public static final char SPACE = ' ';

    public char[][] getPyramidArray(int size) {
        char pyramid[][] = new char[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i < j) {
                    pyramid[i][j] = SPACE;
                } else {
                    pyramid[i][j] = X;
                }
            }
        }
        return pyramid;
    }

    public  void  run (){
        int size = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try(reader){
            size = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            System.out.println("Some problem with input stream: " + e.getMessage());
            throw  new RuntimeException();
        } catch (NumberFormatException e){
            System.out.println("The line you entered is not valid");
            throw new RuntimeException();
        }

        char[][] pyramidArray = getPyramidArray(size);

        for (char[] c : pyramidArray) {
            System.out.println(c);
        }
    }
}



