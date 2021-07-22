package homework_2.random_chars_table;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class RandomCharsTable {

    private int strategyFlag;
    private final Set<String> setLetters = new HashSet<>();

    private void checkSetParameters(String[] subString) {
        int tableLength = Integer.parseInt(subString[0]);
        int tableWidth = Integer.parseInt(subString[1]);
        String strategy = subString[2];
        if (tableLength < 1 || tableWidth < 1) {
            throw new IllegalArgumentException();
        }
        if ("even".equals(strategy)) {
            strategyFlag = 0;
        } else if ("odd".equals(strategy)) {
            strategyFlag = 1;
        } else {
            throw new IllegalArgumentException();
        }

        tableCharPrinter(tableLength, tableWidth);
    }

    private void errorMsg(){
        System.out.println("Passed parameters should match the format [positive integer] " +
                "[positive integer] [even|odd]");
    }

    private void input() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] subString = bufferedReader.readLine().split(" ");
            checkSetParameters(subString);
        } catch (IOException e) {
            System.out.println("Something went wrong");
        } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
            errorMsg();
        }
    }

    private void lettersPrint() {
        if (strategyFlag == 0) {
            System.out.println("Even letters - " +
                    String.join(", ", setLetters));
        } else {
            System.out.println("Odd letters - " +
                    String.join(", ", setLetters));
        }
    }

    private char randomChar() {
        return (char) (65 + Math.random() * 26);
    }

    void run() {
        System.out.println("RandomCharTable App");
        System.out.println("Enter table length, width and strategy separated by a space:");

        input();
    }

    private void strategyStringBuilder(char currentChar) {
        if (currentChar % 2 == strategyFlag) {
            setLetters.add(Character.toString(currentChar));
        }
    }

    private void tableCharPrinter(int tableLength, int tableWidth) {
        for (int i = 0; i < tableLength; i++) {
            System.out.print("|");
            for (int j = 0; j < tableWidth; j++) {
                char currentChar = randomChar();
                strategyStringBuilder(currentChar);
                System.out.print(currentChar + "|");
            }
            System.out.print("\n");
        }
        lettersPrint();
    }
}
