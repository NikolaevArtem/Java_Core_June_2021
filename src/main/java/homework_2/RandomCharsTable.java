package homework_2;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RandomCharsTable {
    public static void main(String[] args) {
        randomCharsTable();
    }

    private static void randomCharsTable() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Please type size of a table: 2 numbers and strategy - even or odd:");

            int lengthOfTable = scanner.nextInt();
            int widthOfTable = scanner.nextInt();
            String strategy = scanner.next();

            char[][] randomCharsTable = new char[lengthOfTable][widthOfTable];

            int minRand = 'A';
            int maxRand = 'Z';
            for (int i = 0; i < lengthOfTable; i++) {
                for (int j = 0; j < widthOfTable; j++) {
                    randomCharsTable[i][j] = (char) ((int) (Math.random() * (maxRand - minRand + 1) + minRand));
                    System.out.print(" | " + randomCharsTable[i][j] + " |");
                }
                System.out.println();
            }

            if ("even".equals(strategy.toLowerCase())) {
                System.out.print("Even letters: ");
            }

            if ("odd".equals(strategy.toLowerCase())) {
                System.out.print("Odd letters: ");
            }

            StringBuffer stringBuffer = new StringBuffer();

            for (int i = 0; i < lengthOfTable; i++) {
                for (int j = 0; j < widthOfTable; j++) {
                    int codeOfChar = randomCharsTable[i][j];
                    if ("even".equals(strategy.toLowerCase())) {
                        if (codeOfChar % 2 == 0) {
                            stringBuffer.append(" ").append((char) codeOfChar).append(" ,");
                        }
                    }

                    if ("odd".equals(strategy.toLowerCase())) {
                        if (codeOfChar % 2 != 0) {
                            stringBuffer.append(" ").append((char) codeOfChar).append(" ,");
                        }
                    }
                }
            }

            stringBuffer.deleteCharAt(stringBuffer.length() - 1);

            System.out.print(stringBuffer);
        } catch (InputMismatchException | NegativeArraySizeException e) {
            System.out.println("Please follow to the correct format: 2 positive numbers + even/odd word");
        }
    }
}
