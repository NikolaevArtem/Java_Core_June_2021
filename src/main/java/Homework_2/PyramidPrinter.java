package Homework_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PyramidPrinter {
    public static void main(String[] args) throws Exception {
        bufferedReaderReadConsole();
    }
    private static void bufferedReaderReadConsole() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int blocks = Integer.parseInt(reader.readLine());
            String [][] Pyramid = new String[blocks][1];
            for (int i = 0; i < blocks; i++){
                char [] Pyramid_int = new char[i + 1];
                for (int j = 0; j <= i; j++){
                    Pyramid_int[j] = 'x';
                }
                Pyramid[i][0] = Pyramid[i][0].copyValueOf(Pyramid_int);
                System.out.println(Pyramid[i][0]);
            }
        }
        catch (NumberFormatException e) {
            System.out.println("Введите число!");
        }
        //ну мало ли..
        catch (NegativeArraySizeException e) {
            System.out.println("Введите положительное число!");
        }
    }
}
