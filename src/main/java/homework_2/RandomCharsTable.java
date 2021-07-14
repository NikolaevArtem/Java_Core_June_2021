package homework_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class RandomCharsTable {
    public static boolean strategyFlag;
    public static StringBuilder stringLetters = new StringBuilder();


    public static void main(String[] args) throws IOException {
        System.out.println("RandomCharTable App");
        System.out.println("Enter table length, width and strategy separated by a space:");

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
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
        if (strategyFlag) {
            System.out.println("Even letters: " + stringLetters);
        }
        else {
            System.out.println("Odd letters: " + stringLetters);
        }
        stringLetters.setLength(0);
    }

    private static char randomChar() {
        return (char) (65 + Math.random()*26);
    }

    public static void strategyFlag(String strategy) {
        if ("even".equals(strategy)) {
            strategyFlag = true;
        }
        else if ("odd".equals(strategy)) {
            strategyFlag = false;
        }
        else {
           throw new IllegalArgumentException();
        }
    }

    private static void stratStringBuilder(char currentChar) {
        if (strategyFlag){
            if(currentChar % 2 == 0){
                if(stringLetters.indexOf(String.valueOf(currentChar)) == -1){
                    stringLetters.append(currentChar);
                    stringLetters.append(", ");
                }
            }
        }
        if (!strategyFlag) {
            if(currentChar % 2 == 1){
                if(stringLetters.indexOf(String.valueOf(currentChar)) == -1){
                    stringLetters.append(currentChar);
                    stringLetters.append(", ");
                }
            }
        }
    }

    private static void tableCharPrinter(int tableLength, int tableWidth){
        for (int i = 0; i < tableLength; i++) {
            System.out.print("|");
            for (int j = 0; j < tableWidth; j++) {
                char currentChar = randomChar();
                stratStringBuilder(currentChar);
                System.out.print(currentChar + "|");
            }
            System.out.print("\n");
        }
    }
}
