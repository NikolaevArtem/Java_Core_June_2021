package Homework2.Random_Chars_Table;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static int length = 0;
    static int height = 0;

    public static void main(String[] args) throws IOException {
        String strategy = "";

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        if (input.matches("\\d+\\s\\d+\\sodd") || input.matches("\\d+\\s\\d+\\seven")
                && height >= 0 && length >= 0) {
            String[] split = input.split(" ");
            length = Integer.parseInt(split[0]);
            height = Integer.parseInt(split[1]);
            strategy = split[2];
        } else {
            System.out.println("The input line does not match the pattern");
        }
        StringBuilder builder = new StringBuilder();
        RandomCharsTable randomCharsTable = new RandomCharsTable();
        char[][] rCT = RandomCharsTable.getRandomCharsTable(length, height);

        for (char[] ch : rCT) {
            builder.append("| ");
            for (char c : ch) {
                builder.append(c).append(" | ");
            }
            builder.append("\n");
        }
        System.out.println(builder.toString());

        if(strategy.equals("odd")){
            builder.append("Odd letters - ");
            for (int i = 0; i < length; i++){
                for (int j = 0; j < height; j++){
                    if (rCT[i][j]% 2 != 0){
                        builder.append(rCT[i][j]).append(" ");
                    }
                }
            }
        }
        System.out.println(builder.toString());

        if (strategy.equals("even")){
            builder.append("Even letters - ");
            for (int i = 0; i < length; i++){
                for (int j = 0; j < height; j++){
                    if (rCT[i][j] % 2 == 0) {
                        builder.append(rCT[i][j]).append(" ");
                    }
                }
            }

        }
        System.out.println(builder.toString());
    }

}
