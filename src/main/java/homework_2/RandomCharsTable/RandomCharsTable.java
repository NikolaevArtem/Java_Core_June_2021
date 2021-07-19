package homework_2.RandomCharsTable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class RandomCharsTable {
    public static int strategyFlag;
    public static Set<String> setLetters = new HashSet<>();

    public static void main(String[] args) throws IOException {
        System.out.println("RandomCharTable App");
        System.out.println("Enter table length, width and strategy separated by a space:");

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String [] subString = bufferedReader.readLine().split(" ");
            int tableLength = Integer.parseInt(subString[0]);
            int tableWidth = Integer.parseInt(subString[1]);
            String strategy = subString[2];
            strategyFlag(strategy);
            tableCharPrinter(tableLength, tableWidth);
            lettersPrint();
        }
    }

    private static void lettersPrint() {
        if (strategyFlag == 0) {
            System.out.println("Even letters - " +
                    String.join(",", setLetters));
        }
        else {
            System.out.println("Odd letters - " +
                    String.join(",", setLetters));
        }
    }

    private static char randomChar() {
        return (char) (65 + Math.random()*26);
    }

    public static void strategyFlag(String strategy) {
        if ("even".equals(strategy)) {
            strategyFlag = 0;
        }
        else if ("odd".equals(strategy)) {
            strategyFlag = 1;
        }
        else {
           throw new IllegalArgumentException();
        }
    }

    private static void strategyStringBuilder(char currentChar) {
        if(currentChar % 2 == strategyFlag){
            setLetters.add(Character.toString(currentChar));
            }
        }

    private static void tableCharPrinter(int tableLength, int tableWidth) {
        for (int i = 0; i < tableLength; i++) {
            System.out.print("|");
            for (int j = 0; j < tableWidth; j++) {
                char currentChar = randomChar();
                strategyStringBuilder(currentChar);
                System.out.print(currentChar + "|");
            }
            System.out.print("\n");
        }
    }
}
