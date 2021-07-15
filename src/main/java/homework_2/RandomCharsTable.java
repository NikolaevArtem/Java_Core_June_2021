package homework_2;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class RandomCharsTable {

    public static void main(String[] args) {
        System.out.println("Enter two integer numbers to set the length" +
                " and the width of a table and a strategy(even/odd) ");
        System.out.println("Input example: 2 2 even\n");
        System.out.print("Enter your data: ");
        try (Scanner scn = new Scanner(System.in)) {
            int length = scn.nextInt();
            int width = scn.nextInt();
            int remainder = "odd".equals(scn.next()) ? 1 : 0;
            StringBuilder message = new StringBuilder(remainder == 0 ?
                    "Even letters -" : "Odd letters -" ) ;
            char[][] table = new char[length][width];
            Random rnd = new Random(System.currentTimeMillis());
            for (int i = 0; i < length; i++) {
                System.out.print("| ");
                for (int j = 0; j < width; j++) {
                    table[i][j] = (char) (rnd.nextInt(26) + 65);
                    System.out.print(table[i][j] + " | ");
                    if (table[i][j] % 2 == remainder) {
                        message.append(" ").append(table[i][j]).append(",");
                    }
                }
                System.out.println();
            }
            message.deleteCharAt(message.length() - 1);
            System.out.println(message);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Next time enter two integers" +
                    " and a strategy: \"even\" or \"odd\" without quotes. ");
            System.out.println("Input example: 25 25 odd\n");
        }
    }

}
