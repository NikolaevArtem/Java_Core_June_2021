package homework_2.random_chars_table;

import homework_2.utils.App;

import java.util.Random;

public class RandomCharsTable extends App {
    private int length;
    private int width;
    private boolean isOdd;

    private boolean isDebug;

    @Override
    protected void parseData() {
        final String ERR_NON_VALID_DATA_MSG = "Passed parameters should match the format [positive integer] [positive integer] [even|odd]";

        if (!inputStr.matches("[1-9][0-9]*\\s[1-9][0-9]*\\s(even|odd)")) {
            error = ERR_NON_VALID_DATA_MSG;
            return;
        }
        String[] arguments = inputStr.split("\\s");
        isOdd = arguments[2].equalsIgnoreCase("odd");
        try {
            length = Integer.parseInt(arguments[0]);
            width = Integer.parseInt(arguments[1]);
        } catch (NumberFormatException ex) {
            error = ERR_NON_VALID_DATA_MSG;
        }
    }
    @Override
    protected String calculate() {
        if (error != null) return error;

        int check;
        Random random;

        if (isDebug) random = new Random(1L);
        else random = new Random();

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
                if (letter % 2 == check) {
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

    public RandomCharsTable setDebug(boolean debug) {
        isDebug = debug;
        return this;
    }
}
