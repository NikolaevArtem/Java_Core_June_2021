package homework_2.pyramid_printer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PyramidPrinter {
//    считывает число с командной строки, и печатает пирамиду из "x" согласно введенному положительному целому числу.
//    После первой печати завершает работу.

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        int num;

        System.out.println("Введите положительное целое число");
        str = reader.readLine();

        try {
            num = Integer.parseInt(str);
            if (num < 0) {
                System.out.println("Разрешено вводить только положительные числа");
            }
        } catch (NumberFormatException e) {
            System.out.println("Разрешено вводить только целые положительные числа");
        }

        System.out.println("здесь писать код");

    }
}