package homework_2.random_chars_table;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Locale;

public class RandomCharsTable {
    private final String ERR_MSG = "Passed parameters should match the format [positive integer] [positive integer] [even|odd]";

    public void run() {

        RandomCharsTable table = new RandomCharsTable();

        String lenStr;
        String widStr;
        String method;

        String[] strings = table.getInput();

        if (isValid(strings)) {

            lenStr = strings[0];
            widStr = strings[1];
            method = strings[2].toLowerCase(Locale.ROOT);

            char[][] toPrint = table.getTable(lenStr, widStr);
            if(toPrint.length == 0){
                System.out.println("Table is empty");
                return;
            }
            System.out.println("There is an unsorted table:");

            for (char[] ch : toPrint
            ) {
                for (char character : ch
                     ) {
                    System.out.print("|" + character);
                }
                System.out.print("|");
                System.out.println();
            }


            table.printSorted(toPrint, method);
        } else {
            System.out.println(ERR_MSG);
        }

    }

    private String[] getInput() {

        String[] result = new String[3];

        System.out.println("Enter two Integers and sorting method, even or odd, e.g.  12 12 odd");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            String rawInput = reader.readLine();
            result = rawInput.split(" ");

        } catch (IOException e) {
            System.out.println(ERR_MSG);
        }

        return result;
    }

    private char[][] getTable(String length, String width) {

        int len = Integer.parseInt(length);
        int wid = Integer.parseInt(width);

        char[][] res = new char[len][wid];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < wid; j++) {
                res[i][j] = (char) ((Math.random() * (91 - 65) + 65));
            }
        }

        return res;
    }

    private void printSorted(char[][] table, String method) {
        StringBuilder result = new StringBuilder();

        switch (method) {
            case ("odd"):
                result.append("Odd letters - ");
                for (char[] ch : table
                )
                    for (char c : ch
                    ) {

                        if ((c % 2) != 0) {
                            result.append(c);
                            result.append(',');
                        }
                    }
                String res = result.toString();
                System.out.println(res.substring(0, res.length() - 1) + ".");
                break;
            case ("even"):
                result.append("Even letters - ");
                for (char[] ch : table
                )
                    for (char c : ch
                    ) {
                        if ((c % 2) == 0) {

                            result.append(c);
                            result.append(',');
                        }
                    }
                String res1 = result.toString();
                System.out.println(res1.substring(0, res1.length() - 1) + ".");
                break;
        }

    }

    private boolean isValid(String[] strings) {
        boolean firstDigit = false;
        boolean secondDigit = false;
        boolean oddOrEven = false;

        if (strings.length < 3) {
            return false;
        } else if (strings.length == 3) {
            firstDigit = strings[0].chars().allMatch(Character::isDigit);
            secondDigit = strings[1].chars().allMatch(Character::isDigit);
            oddOrEven = (strings[2].equals("odd") || strings[2].equals("even"));
        }
        return (firstDigit && secondDigit && oddOrEven);
    }
}
