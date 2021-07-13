package homework_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class RandomCharsTable {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            String s = reader.readLine();
            String[] as = s.split(" ");
            if (as.length > 2) {

                int arg1;
                int arg2;
                String arg3;

                try {
                    arg1 = Integer.parseInt(as[0]);
                    arg2 = Integer.parseInt(as[1]);
                } catch (NumberFormatException e) {
                    System.out.println("Error: first and second args must be integer");
                    return;
                }

                if (arg1 < 0 || arg2 < 0) {
                    System.out.println("Error: first and second args must be positive");
                    return;
                }

                arg3 = as[2];

                if (!arg3.equals("even") && !arg3.equals("odd")) {
                    System.out.println("Error: third arg must be even or odd now <" + arg3 + ">");
                    return;
                }

                char[][] arr = new char[arg1][arg2];
                Random r = new Random();
                StringBuilder b = new StringBuilder();
                StringBuilder log = new StringBuilder();

                for (char[] c1 : arr) {
                    for (char c2 : c1) {
                        int num = 65 + r.nextInt(26);
                        c2 = (char) (num);
                        if (num%2==0 && arg3.equals("even")) {
                            b.append(c2);
                        } else if (num%2>0 && arg3.equals("odd")) {
                            b.append(c2);
                        }
                        log.append("|" + c2);
                    }
                    log.append("|" + "\n");
                }
                System.out.println(log);
                System.out.println(arg3.substring(0,1).toUpperCase() +
                        arg3.substring(1) + " letters - " + b);

            } else {
                System.out.println("Error: less when 3 args");
            }
        }  catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
