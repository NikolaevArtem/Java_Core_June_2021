package Homework_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class RandomCharsTable {
    public static void main(String[] args) throws Exception {
        bufferedReaderReadConsole();
    }
    private static void bufferedReaderReadConsole() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String text = reader.readLine();
                String[] text_parts = text.split(" ");
                int length = Integer.parseInt(text_parts[0]);
                int width = Integer.parseInt(text_parts[1]);
                String strategy = text_parts[2];
                char[][] table = new char[length][width];
                StringBuffer evens = new StringBuffer();
                StringBuffer odds = new StringBuffer();
                for (int i = 0; i < length; i++){
                    for(int j = 0; j < width; j++) {
                        Random ran = new Random();
                        int number = 65 + ran.nextInt(26);
                        table[i][j] = (char) number;
                        System.out.print("|" + table[i][j]);
                        if (j == (width - 1)){
                            System.out.print('|');
                        }
                        if (number % 2 == 0){
                            evens = evens.length() == 0 ? evens.append(table[i][j]) : evens.append(", " + table[i][j]);
                        }
                        else {
                            odds = odds.length() == 0 ? odds.append(table[i][j]) : odds.append(", " + table[i][j]);
                        }
                    }
                    System.out.println();
                }
                if (strategy.equalsIgnoreCase("even")){
                    System.out.println("Even letters - " + evens.toString());
                }
                else {
                    System.out.println("Odd letters - " + odds.toString());
                }
            }
        }
    }
}
