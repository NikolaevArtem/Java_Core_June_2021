package Homework2.Random_Chars_Table;

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

    public String getResult(String strategy, char[][] rCT) {
        StringBuilder buildResult = new StringBuilder();
        buildResult.append(strategy)
                .append(" letters -");

        boolean strategyOdd = strategy.equals("odd");

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < height; j++) {
                boolean isOdd = rCT[i][j] % 2 == 1;

                if ((!strategyOdd && !isOdd) || (strategyOdd && isOdd)) {
                    buildResult.append(' ')
                            .append(rCT[i][j]);
                }
            }
        }
        return buildResult.toString();
    }

    public void run() {
        String strategy;
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();

        if (!isValid(input)) {
            throw new IllegalArgumentException("The line you entered does not fit the pattern");
        } else {
            String[] split = input.split("\\s");
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

        System.out.println(getResult(strategy, rCT));
    }

}



