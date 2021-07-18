package homework_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Random_Chars_Table {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(reader.readLine());
        int y = Integer.parseInt(reader.readLine());
        String word = reader.readLine();

        char[][] table = new char[x][y];
        int helper;
        ArrayList<Integer> words = new ArrayList<>();

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                helper = getRandomNumber();
                table[i][j] = (char) helper;
                words.add(helper);

            }
        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print("|" + table[i][j]);
            }
            System.out.print("|");
            System.out.println();
        }

        if (word.equals("even")) {

            System.out.println(getResultChar(words, true));

        } else if (word.equals("odd")) {

            System.out.println(getResultChar(words, false));

        }

    }

    public static int getRandomNumber() {
        return (int) ((Math.random() * (90 - 65)) + 65);
    }

    public static String getResultChar(ArrayList<Integer> words, boolean even) {
        String res;
        if (even) {
            res = words.stream().filter(i -> i % 2 == 0)
                                .distinct()
                                .map(i -> String.valueOf((char) i.intValue()))
                                .collect(Collectors.joining(","));
        } else {
            res = words.stream().filter(i -> i % 2 == 1)
                                .distinct()
                                .map(i -> String.valueOf((char) i.intValue()))
                                .collect(Collectors.joining(","));
        }
        return res;
    }
}
