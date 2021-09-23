package homework_2.random_chars_table;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RandomCharsTable {
    public void run() {
        int x;
        int y;
        String word;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            String[] str = reader.readLine().split(" ");
            x = Integer.parseInt(str[0]);
            y = Integer.parseInt(str[1]);
            word = str[2];

            if (x < 1 || y < 1 || !(word.equals("even") || word.equals("odd")) || str.length > 3) {
                System.out.println("Passed parameters should match the format [positive integer] [positive integer] [even|odd]");
                return;
            }

        } catch (Exception e) {
            System.out.println("Passed parameters should match the format [positive integer] [positive integer] [even|odd]");
            return;
        }

        char[][] table = new char[x][y];
        ArrayList<Integer> words = new ArrayList<>();

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                int helper = getRandomNumber();
                table[i][j] = (char) helper;
                words.add(helper);
            }
        }

        printTable(table, x, y);

        if (word.equals("even")) {
            System.out.println(getResultChar(words, true));
        }
        if (word.equals("odd")) {
            System.out.println(getResultChar(words, false));
        }
    }

    public static int getRandomNumber() {
        return (int) ((Math.random() * ('Z' - 'A')) + 'A');
    }

    public static String getResultChar(ArrayList<Integer> words, boolean even) {
        String result;
        Predicate<Integer> predicate;
        if (even) {
            result = "Even letters - ";
            predicate = i -> i % 2 == 0;
        } else {
            result = "Odd letters - ";
            predicate = i -> i % 2 == 1;
        }
        result += words.stream().filter(predicate)
                .distinct()
                .map(i -> String.valueOf((char) i.intValue()))
                .collect(Collectors.joining(", "))
                .trim();
        return result;
    }

    public void printTable(char[][] table, int x, int y) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print("|" + table[i][j]);
            }
            System.out.print("|");
            System.out.println();
        }
    }
}
