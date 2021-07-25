package homework_2.random_chars_table;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class RandomCharsTable {

    private int length;
    private int width;
    private boolean isEven;

    void run() {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            printTable(reader.readLine());

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void printTable(String s) {

        if (argsIsOk(s)) {

            char[][] arr = new char[length][width];
            Random r = new Random();
            StringBuilder result = new StringBuilder();
            StringBuilder massive = new StringBuilder();

            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {

                    int num = 65 + r.nextInt(26);
                    arr[i][j] = (char) (num);
                    if (num % 2 == (isEven ? 0 : 1)) {
                        result.append(arr[i][j] + " ");
                    }
                    massive.append("|" + arr[i][j]);
                }
                massive.append("|" + "\n");
            }

            System.out.println(massive);
            System.out.println(isEven ? "Even" : "Odd" + " letters - " + result.toString().trim());

        }
    }

    private boolean argsIsOk(String s) {

        String[] inputArgs = s.split(" ");

        if (inputArgs.length < 3) {
            System.out.println("Error: less when 3 args");
            return false;
        }

        String mode;

        try {
            length = Integer.parseInt(inputArgs[0]);
            width = Integer.parseInt(inputArgs[1]);
            mode = inputArgs[2];
        } catch (NumberFormatException e) {
            System.out.println("Error: first and second args must be integer");
            return false;
        }

        if (length < 0 || width < 0) {
            System.out.println("Error: first and second args must be positive");
            return false;
        }

        if (mode.equals("even")) {
            isEven = true;
        } else if (mode.equals("odd")) {
            isEven = false;
        } else {
            System.out.println("Error: third arg must be even or odd now <" + mode + ">");
            return false;
        }

        return true;
    }
}
