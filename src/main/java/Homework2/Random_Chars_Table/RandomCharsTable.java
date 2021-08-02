package Homework2.Random_Chars_Table;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RandomCharsTable {
    int length = 0;
    int height = 0;
    String input = "";

    //получаю случайные числа
    static char getRandomChar(int min, int max) {
        min = 65;
        max = 90;
        max -= min;
        char randomCh = (char) ((int) (Math.random() * ++max) + min);
        return randomCh;
    }

    //складываю случайые числа в массив  и делаю из них буквы
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

    public boolean isValid() {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try (reader) {
            input = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (input.matches("\\d+\\s\\d+\\sodd") || input.matches("\\d+\\s\\d+\\seven")
                && height >= 0 && length >= 0) {
            return true;
        } else

            return false;
    }

    //вся движуха с проверкой стратегии и чёт/нечёт
    public void run() {
        String strategy = "";
        if (!isValid()) {
            System.out.println("The line you entered does not fit the pattern");
        } else {
            String[] split = input.split(" ");
            length = Integer.parseInt(split[0]);
            height = Integer.parseInt(split[1]);
            strategy = split[2];
        }

        StringBuilder buildTable = new StringBuilder();

        char[][] rCT = RandomCharsTable.getRandomCharsTable(length, height);

        for (char[] ch : rCT) {
            buildTable.append("| ");
            for (char c : ch) {
                buildTable.append(c).append(" | ");
            }
            buildTable.append("\n");
        }
        System.out.println(buildTable.toString());

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
        System.out.println(buildResult.toString());

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

}


