package homework_5.power_of_number;

import java.util.Scanner;

public class PowerOfNumber {

    private static final String ERROR_MESSAGE = "Only 2 non-negative integers are allowed";

    public void run() {
        System.out.println("Please enter 2 non-negative numbers:");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] subStr= str.split(" ");

        if (subStr.length != 2) {
            System.out.println(ERROR_MESSAGE);
            return;
        }

        int num = 0;
        int pow = 0;

        try {
            num = Integer.parseInt(subStr[0]);
            pow = Integer.parseInt(subStr[1]);
        } catch (NumberFormatException ex) {
            System.out.println(ERROR_MESSAGE);
            return;
        }

        System.out.println(raiseNumToPower(num, pow));
    }

    public int raiseNumToPower(int num, int pow) {
        if (pow == 0) return 1;

        if (pow == 1) return num;

        if (num == 0) return 0;

        return num * raiseNumToPower(num, pow - 1);
    }
}
