package homework_2.pyramid_printer;

import homework_1.Run;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PyramidPrinter implements Run {

    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int rows = Integer.parseInt(reader.readLine());
            if (rows<0) {
                System.out.println("Use positive number");
                return;
            }
            printPyramid(rows);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        } catch (NumberFormatException e){
            System.out.println("Only integer!");
            return;
        }
    }

    static void printPyramid(int rows){
        for (int i = 1; i <= rows; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("x");
            }
            System.out.println();
        }
    }
}
