package homework_2_tests.random_chars_table_test;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RandomCharsTableTest {

    public void run() {
        int length;
        int width;
       /* enum strategy {
            EVEN,
            ODD
        };*/
        int[][] table;
        table = new int[3][4];

        Scanner in = new Scanner(System.in);
        String[] arr = in.nextLine().trim().split("\\s");
        in.close();
        if (arr.length < 3) {
            System.out.println("Error! Not all data entered!");
            return;
        }
        try {
            length = Integer.parseInt(arr[0]);
            width = Integer.parseInt(arr[1]);
           /* if (strategy.EVEN != strategy.valueOf(arr[2]) && strategy.ODD != strategy.valueOf(arr[2])) {

            }*/

        } catch (InputMismatchException e) {
            System.out.println("Error! Only numbers!");
        }
    }
}
