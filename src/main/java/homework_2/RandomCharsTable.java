package homework_2;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class RandomCharsTable {
    public static void main(String[] args) {
        System.out.println("Enter two positive integer numbers more than 0 to set the length" +
                " and the width of a table and a strategy(even/odd) ");
        System.out.println("Input example: 2 2 even\n");
        System.out.print("Enter your data: ");
        try (Scanner scn = new Scanner(System.in)) {
            int length = scn.nextInt();
            int width = scn.nextInt();
            String strategy = scn.next();
            if (length > 0 && width > 0 && ("odd".equals(strategy) || "even".equals(strategy))) {
                int remainder = "odd".equals(strategy) ? 1 : 0;
                StringBuilder message = new StringBuilder(remainder == 0 ?
                        "Even letters -" : "Odd letters -");
                char[][] table = new char[length][width];
                Random rnd = new Random(System.currentTimeMillis());
                int lettersCounter = 0;
                for (int i = 0; i < length; i++) {
                    System.out.print("| ");
                    for (int j = 0; j < width; j++) {
                        table[i][j] = (char) (rnd.nextInt(26) + 65);
                        System.out.print(table[i][j] + " | ");
                        if (table[i][j] % 2 == remainder) {
                            message.append(" ").append(table[i][j]).append(",");
                            lettersCounter++;
                        }
                    }
                    System.out.println();
                }
                if (lettersCounter == 0) {
                    System.out.printf("There are no %s letters in the table", strategy);
                } else {
                    message.deleteCharAt(message.length() - 1);
                    System.out.println(message);
                }
            } else {
                throw new InputMismatchException();
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Next time enter two positive integers more than 0" +
                    " and a strategy: \"even\" or \"odd\" without quotes. ");
            System.out.println("Input example: 25 25 odd\n");
        }
    }

}
