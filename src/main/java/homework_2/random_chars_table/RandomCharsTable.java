package homework_2.random_chars_table;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class RandomCharsTable {
    public static final String ERROR_MESSAGE  = "Passed parameters should match the format [positive integer] [positive integer] [even|odd]";
    public void run() {
        Scanner scanner = new Scanner(System.in);
        String[] params = new String[3];
        for (int i = 0; i < params.length; i++) {
            params[i] = scanner.next();
        }
        if (!isNumber(params[0]) || !isNumber(params[1])) {
            System.out.println(ERROR_MESSAGE);
            return;
        }
        int rows = Integer.parseInt(params[0]);
        int columns = Integer.parseInt(params[1]);
        if (rows == 0 || columns == 0) {
            return;
        }
        if (rows < 0 || columns < 0) {
            System.out.println(ERROR_MESSAGE);
            return;
        }
        String strategy = params[2];
        int strategyMod;
        if (strategy.equals("even")) {
            strategyMod = 0;
        } else if (strategy.equals("odd")){
            strategyMod = 1;
        } else {
            System.out.println(ERROR_MESSAGE);
            return;
        }
        StringBuilder result = new StringBuilder(strategy + " letters - ");
        for (int i = 0; i < rows; i++) {
            System.out.print("| ");
            for (int j = 0; j < columns; j++) {
                char letter = (char) (65 + new Random().nextInt(26));
                System.out.print(letter + " | ");
                if (letter % 2 == strategyMod) {
                    result.append(letter).append(", ");
                }
            }
            System.out.println();
        }
        System.out.println(result.deleteCharAt(result.length() - 2));
    }

    private boolean isNumber(String str) {
        return !Pattern.matches(str, "-?[0-9]+");
    }
}
