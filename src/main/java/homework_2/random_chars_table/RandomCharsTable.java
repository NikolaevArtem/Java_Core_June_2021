package homework_2.random_chars_table;

import java.util.Random;
import java.util.Scanner;

public class RandomCharsTable {
    public static void run(){
        System.out.println("Please enter number of rows, columns and even|odd:");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] subStr;
        String delimiter = " ";
        subStr = str.split(delimiter);

        if (subStr.length != 3) {
            System.out.println("Passed parameters should match the format [positive integer] [positive integer] [even|odd]");
            return;
        }

        int rows = 0;
        int columns = 0;

        try {
            rows = Integer.parseInt(subStr[0]);
            columns = Integer.parseInt(subStr[1]);
        } catch (NumberFormatException ex) {
            System.out.println("Passed parameters should match the format [positive integer] [positive integer] [even|odd]");
            return;
        }

        if ((!subStr[2].equals("even")) && (!subStr[2].equals("odd"))) {
            System.out.println("Passed parameters should match the format [positive integer] [positive integer] [even|odd]");
            return;
        }

        String evenOrOdd = subStr[2];
        boolean evenCheck = false;

        if (evenOrOdd.equals("even")){
            evenCheck = true;
        }

        String ans = printTable(rows, columns, evenCheck);

        if (ans.length() == 0) {
            ans = "";
        } else {
            ans = ans.substring(0, ans.length() - 1);
        }

        if (evenCheck){
            System.out.print("Even letters - " + ans);
        } else {
            System.out.print("Odd letters - " + ans);
        }
    }

    private static String printTable(int rows, int columns, boolean evenCheck) {
        String ans = "";
        Random random = new Random();
        int [][] arr = new int[rows][columns];
        int a = 65;
        int b = 90;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = a + (random.nextInt(b - a + 1));
                System.out.print("|");
                System.out.print((char)arr[i][j]);
                if (!(arr[i][j] % 2 == 0) ^ (evenCheck)) {
                    ans = ans.concat(Character.toString((char)arr[i][j]));
                    ans = ans.concat(",");
                }
            }
            System.out.print("|\n");
        }

        return ans;
    }
}
