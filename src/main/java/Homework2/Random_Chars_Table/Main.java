package Homework2.Random_Chars_Table;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int length = 0;
        int height = 0;
        String strategy = "";

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        if (input.matches("\\d+\\s\\d+\\sodd") || input.matches("\\d+\\s\\d+\\seven")) {
            String[] split = input.split(" ");
            length = Integer.parseInt(split[0]);
            height = Integer.parseInt(split[1]);
            strategy = split[2];
        } else {
            System.out.println("The input line does not match the pattern");
        }

        RandomCharsTable randomCharsTable = new RandomCharsTable();
        char[][] randomCharTable = randomCharsTable.getRandomCharTable(length, height);
        for (char[] c : randomCharTable) {
            System.out.println(c);
//            if (strategy.equals("odd")) {
//                {
//                    for (int i = 0; i < length; i++) {
//                        for (int j = 0; j < height; j++) {
//                            if (randomCharTable[i][j] % 2 != 0) {
//                                System.out.println("Odd letters - " + randomCharTable[i][j] + ", ");
//                            }
//                        }
//                    }
//                }
//
//            } else if (strategy.equals("even")) {
//                for (int i = 0; i < length; i++) {
//                    for (int j = 0; j < height; j++) {
//                        if (randomCharTable[i][j] % 2 == 0) {
//                            System.out.println("Odd letters - " + randomCharTable[i][j] + ", ");
//                        }
//                    }
//                }
//            }
        }
    }

}
