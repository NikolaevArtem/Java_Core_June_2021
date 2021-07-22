package homework_2.random_chars_table;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class RandomCharsTable {

    private static int arg1;
    private static int arg2;
    private static String arg3;
    private static boolean even;

    void run() {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            String s = reader.readLine();
            printTable(s);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    void printTable(String s) {

        if (chekOk(s)) {

            char[][] arr = new char[arg1][arg2];
            Random r = new Random();
            StringBuilder b = new StringBuilder();
            StringBuilder log = new StringBuilder();

            for (char[] c1 : arr) {
                for (char c2 : c1) {
                    int num = 65 + r.nextInt(26);
                    c2 = (char) (num);
                    if (num % 2 == 0 && even) {
                        b.append(c2);
                    } else if (num % 2 > 0 && !even) {
                        b.append(c2);
                    }
                    log.append("|" + c2);
                }
                log.append("|" + "\n");
            }
            System.out.println(log);
            System.out.println(arg3.substring(0, 1).toUpperCase() +
                    arg3.substring(1) + " letters - " + b);

        }
    }

    private static boolean chekOk(String s) {

        String[] as = s.split(" ");

        if (as.length < 3) {
            System.out.println("Error: less when 3 args");
            return false;
        }

        try {
            arg1 = Integer.parseInt(as[0]);
            arg2 = Integer.parseInt(as[1]);
            arg3 = as[2];
        } catch (NumberFormatException e) {
            System.out.println("Error: first and second args must be integer");
            return false;
        }

        if (arg1 < 0 || arg2 < 0) {
            System.out.println("Error: first and second args must be positive");
            return false;
        }

        if (arg3.equals("even")) {
            even = true;
        } else if (arg3.equals("odd")) {
            even = false;
        } else {
            System.out.println("Error: third arg must be even or odd now <" + arg3 + ">");
            return false;
        }

        return true;
    }
}
