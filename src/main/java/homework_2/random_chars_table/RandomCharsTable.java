package homework_2.random_chars_table;

import homework_2.utils.App;

import java.util.Random;

public class RandomCharsTable extends App {

    protected final String ERR_MSG = "Passed parameters should match the format [positive integer] [positive integer] [even|odd]";

    int length;
    int width;
    boolean isOdd;

    @Override
    protected void parseData() {

        if (!inputStr.matches("[1-9][0-9]*\\s+[1-9][0-9]*\\s+(even|odd)")) {
            error = ERR_MSG;
            return;
        }
        String[] arguments = inputStr.split("\\s");
        isOdd = arguments[2].equalsIgnoreCase("odd");
        try {
            length = Integer.parseInt(arguments[0]);
            width = Integer.parseInt(arguments[1]);
        } catch (NumberFormatException ex) {
            error = ERR_MSG;
        }
    }
    @Override
    protected String calculate() {
        if (error != null) return error;
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
