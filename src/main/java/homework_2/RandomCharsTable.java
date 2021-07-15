package homework_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.StringJoiner;

public class RandomCharsTable {

    public static void main(String[] args) {
        try {
            String inputString = readInputFromConsole();

            if (inputString.matches("[1-9]\\s+[1-9]\\s+even|\\s*[1-9]\\s*[1-9]\\s*odd")) {

                String[] paramArray = inputString.split("\\s+");
                int length = Integer.parseInt(paramArray[0]);
                int width = Integer.parseInt(paramArray[1]);
                int strategy = getStrategyIndex(paramArray[2]);

                char[][] charArray = getNewCharArray(length, width);
                printArray(charArray, strategy);

            }
            else {
                System.out.println("\u001B[31m" + "Error! Input doesn't match pattern!" + "\u001B[0m");
            }

        } catch (Exception e) {
            System.out.println("\u001B[31m" + "Unknown error!" + "\u001B[0m");
        }
    }

    private static char[] getAlphabetLetters() {
        return "abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray();
    }

    private static int getStrategyIndex(String strategyKeyword) {
        return strategyKeyword.equals("even") ? 0 : 1; //even = 0, odd = 1
    }

    private static char[][] getNewCharArray(int length, int width) {
        char[][] array = new char[length][width];

        Random rand = new Random();
        char[] alphabetLetters = getAlphabetLetters();

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                int randomIndex = rand.nextInt(alphabetLetters.length);
                array[i][j] = alphabetLetters[randomIndex];
            }
        }
        return array;
    }

    private static boolean strategyMatch(int strategy, char charItem) {
       return (strategy == 0 && charItem % 2 == 0) || (strategy == 1 && charItem % 2 != 0);
    }

    private static void printArray(char[][] charArray, int strategy) {
        String modeLetters = "";
        if (strategy == 0) {
            modeLetters = "Even letters - ";
        } else if (strategy == 1) {
            modeLetters = "Odd letters - ";
        }

        StringJoiner joiner = new StringJoiner(",");

        for (int i = 0; i < charArray.length; i++) {
            for (int j = 0; j < charArray[i].length; j++) {
                char arrayItem = charArray[i][j];
                if (strategyMatch(strategy, arrayItem)) {
                    joiner.add("" + arrayItem);
                }
                System.out.print("|" + arrayItem);
            }
            System.out.println("|");
        }
        System.out.println(modeLetters + joiner);
    }

    private static String readInputFromConsole() throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Enter value: ");
            return String.valueOf(reader.readLine());
        }
    }

}
