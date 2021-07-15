package homework_2.random_chars_table;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class RandomCharsTable {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputValues = br.readLine().split(" ");

        int rows = Integer.parseInt(inputValues[0]);
        int columns = Integer.parseInt(inputValues[1]);
        boolean isEven = inputValues[2].equals("even");
        if (!isEven && !inputValues[2].equals("odd")) {
            System.out.println("Input error: Unrecognized strategy!");
            return;
        }

        ArrayList<Character> selectedChars = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                char ch = (char) ('A' + Math.random() * 26);
                if ((isEven && (int) ch % 2 == 0) || (!isEven && (int) ch % 2 == 1)) {
                    selectedChars.add(ch);
                }
                System.out.print(ch + "|");
            }
            System.out.println();
        }

        if (isEven) {
            System.out.print("Even letters - ");
        } else {
            System.out.print("Odd letters - ");
        }
        String letters = selectedChars.toString();
        System.out.println(letters.substring(1, letters.length() - 1));
    }
}
