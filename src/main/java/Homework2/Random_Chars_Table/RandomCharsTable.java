package Homework2.Random_Chars_Table;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class RandomCharsTable {
    int length = 0;
    int height = 0;
    String input = "";

    static char getRandomChar(int min, int max) {
        max -= min;
        char randomCh = (char) ((int) (Math.random() * ++max) + min);
        return randomCh;
    }

    public static char[][] getRandomCharsTable(int length, int height) {
        char[][] randomCharTable = new char[length][height];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < height; j++) {
                char ch = getRandomChar(65, 90);
                randomCharTable[i][j] = ch;
            }
        }
        return randomCharTable;
    }

    private boolean isValid(String input) {
        return (input.matches("\\d+\\s\\d+\\sodd") || input.matches("\\d+\\s\\d+\\seven")
                && height >= 0 && length >= 0);

    }


    public void run() {
        String strategy = "";
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();

        if (!isValid(input)) {
            System.out.println("The line you entered does not fit the pattern");
        } else {
            String[] split = input.split(" ");
            length = Integer.parseInt(split[0]);
            height = Integer.parseInt(split[1]);
            strategy = split[2];
        }

        StringBuilder buildTable = new StringBuilder();
        char[][] rCT = getRandomCharsTable(length, height);

        for (char[] ch : rCT) {
            buildTable.append("| ");
            for (char c : ch) {
                buildTable.append(c).append(" | ");
            }
            buildTable.append("\n");
        }
        System.out.println(buildTable);

        StringBuilder buildResult = new StringBuilder();
        if (strategy.equals("odd")) {
            buildResult.append("Odd letters - ");
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < height; j++) {
                    if (rCT[i][j] % 2 == 1) {
                        buildResult.append(rCT[i][j]).append(" ");
                    }
                }
            }
        }

        if (strategy.equals("even")) {
            buildResult.append("Even letters - ");
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < height; j++) {
                    if (rCT[i][j] % 2 == 0) {
                        buildResult.append(rCT[i][j]).append(" ");
                    }
                }
            }
        }
        System.out.println(buildResult.toString());
    }

//    private String getResult(String strategy, char[][] rCT) {
//        StringBuilder buildResult = new StringBuilder();
//        String result = "";
//
//        for (int i = 0; i < length; i++) {
//            for (int j = 0; j < height; j++) {
//                if (rCT[i][j] % 2 == 0 && strategy.equals("odd")) {
//                    buildResult.append("Odd letters - ");
//                    buildResult.append(rCT[i][j]).append(" ");
//                    result = buildResult.toString();
//                } else {
//                    buildResult.append("Even letters - ");
//                    buildResult.append(rCT[i][j]).append(" ");
//                    result = buildResult.toString();
//                }
//            }
//        } return result;
//
//    }
}



