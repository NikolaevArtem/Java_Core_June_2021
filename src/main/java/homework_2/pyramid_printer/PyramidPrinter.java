package homework_2.pyramid_printer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PyramidPrinter {
//    считывает число с командной строки, и печатает пирамиду из "x" согласно введенному положительному целому числу.
//    После первой печати завершает работу.

    public static void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        int num;

        System.out.println("Enter 1 positive integer");

        try {
            str = reader.readLine();
            num = Integer.parseInt(str);
            if (num < 0) {
                System.out.println("Only 1 non-negative integer is allowed as passed parameter");
            } else {
                printPyramid(num);
            }
        } catch (NumberFormatException | IOException e) {
            System.out.println("Only 1 non-negative integer is allowed as passed parameter");
        }
    }

    private static void printPyramid(int num) {
        String output = "";
        for (int i = 0; i < num; i++) {
            output += "x";
            System.out.println(output);
        }
    }
}