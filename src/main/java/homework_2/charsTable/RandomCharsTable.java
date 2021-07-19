package homework_2.charsTable;

import homework_2.utils.App;
import homework_2.utils.Executable;

import java.util.Random;
import java.util.Scanner;

public class RandomCharsTable extends App {
    int length;
    int width;
    boolean isOdd;

    public static void main(String[] args) {
        Executable rct = new RandomCharsTable();
        rct.execute();
    }
    @Override
    protected void parseData() {
        try(Scanner sc = new Scanner(inputStr)) {
            length = sc.nextInt();
            width = sc.nextInt();
            isOdd = sc.next().equalsIgnoreCase("odd");
        }
    }
    @Override
    protected String calculate() {
        int check;
        Random random = new Random();
        StringBuilder charTable = new StringBuilder("\n");
        StringBuilder answerBuilder = new StringBuilder();

        if(isOdd) {
            check = 1;
            answerBuilder.append("Odd letters - ");
        } else {
            check = 0;
            answerBuilder.append("Even letters - ");
        }

        for (int y = 0; y < length; y++) {
            for (int x = 0; x < width; x++) {
                char letter = (char)(65 + random.nextInt(25));
                charTable
                        .append("| ")
                        .append(letter)
                        .append(" ");
                if( (letter & check) == check) {
                    answerBuilder
                            .append(letter)
                            .append(", ");
                }
            }
            charTable.append("|\n");
        }
        answerBuilder.setLength(answerBuilder.length() - 2);
        return charTable.append(answerBuilder).toString();
    }
}
