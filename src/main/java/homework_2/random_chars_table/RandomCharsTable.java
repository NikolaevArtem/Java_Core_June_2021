package homework_2.random_chars_table;

import java.util.Random;
import java.util.Scanner;

public class RandomCharsTable {

    private static final String ERROR_MESSAGE = "Passed parameters should match the format [positive integer] [positive integer] [even|odd]";

    public void run(){
        System.out.println("Please enter number of rows, columns and even|odd:");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] subStr= str.split(" ");

        if (subStr.length != 3) {
            System.out.println(ERROR_MESSAGE);
            return;
        }

        int rows = 0;
        int columns = 0;

        try {
            rows = Integer.parseInt(subStr[0]);
            columns = Integer.parseInt(subStr[1]);
        } catch (NumberFormatException ex) {
            System.out.println(ERROR_MESSAGE);
            return;
        }

        if ((!subStr[2].equals("even")) && (!subStr[2].equals("odd"))) {
            System.out.println(ERROR_MESSAGE);
            return;
        }

        if (rows < 1 || columns < 1) {
            System.out.println(ERROR_MESSAGE);
        }

        String evenOrOdd = subStr[2];
        boolean isEven = false;

        if (evenOrOdd.equals("even")){
            isEven = true;
        }

        printTable(rows, columns, isEven);
        sc.close();
    }

    private void printTable(int rows, int columns, boolean isEven) {
        String result = "";
        Random random = new Random();
        int [][] arr = new int[rows][columns];
        int a = 65;
        int b = 90;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = a + (random.nextInt(b - a + 1));
                System.out.print("|");
                System.out.print((char)arr[i][j]);
                if (!(arr[i][j] % 2 == 0) ^ (isEven)) {
                    result = result.concat(Character.toString((char)arr[i][j]));
                    result = result.concat(",");
                }
            }
            System.out.print("|\n");
        }

        if (result.length() == 0) {
            result = "";
        } else {
            result = result.substring(0, result.length() - 1);
        }

        if (isEven){
            System.out.print("Even letters - " + result);
        } else {
            System.out.print("Odd letters - " + result);
        }
    }
}
