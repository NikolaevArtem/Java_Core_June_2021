package homework_5.power_of_number;

import java.util.Scanner;

public class PowerOfNumber {

    public void run() {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        String[] line = str.split(" ");
        if (isValid(line)) {
            try {
                int n = Integer.parseInt(line[0]);
                int m = Integer.parseInt(line[1]);

                if (n > 0 && m > 0) {

                    if (m == 0)
                        System.out.println(1);
                    else
                        System.out.println(powerOfNumber(n, m));
                } else {
                    System.out.println("Only 2 non-negative integers are allowed");
                }

            } catch (NumberFormatException e) {
                System.out.println("Only 2 non-negative integers are allowed");
            }
        } else {
            System.out.println("Only 2 non-negative integers are allowed");
        }

    }

    public static boolean isValid(String[] input) {
        if (input.length == 2)
            return true;
        else
            return false;

    }

    public static int powerOfNumber(int n, int m) {
        if (m == 1)
            return n;
        else
            return n * powerOfNumber(n, m - 1);
    }
}
