package homework_5.power_of_number;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PowerOfNumber {
    final private static String ERROR_MSG = "Only 2 non-negative integers are allowed";
    private static Object Exception;

    public static void run() throws Throwable {
        System.out.println("Enter 2 non-negative integers");
        try {
            int[] numbers = getNumbers();
            int a = numbers[0];
            int b = numbers[1];
            System.out.println(power(a,b));

        } catch (Exception e) {
            System.out.println(ERROR_MSG);
        }
    }

    public static int[] getNumbers() throws Throwable {
        String[] s;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        s = reader.readLine().split(" ");

        if (s.length != 2)
            throw (Throwable) Exception;

        int[] numbers = new int[2];
        for (int i = 0; i < 2; i++) {
            numbers[i] = Integer.parseInt(s[i]);
        }

        if (numbers[0] < 0 || numbers[1] < 0)
            throw (Throwable) Exception;
        return numbers;
    }

    public static int power(int a, int b) {
        int result = 1;
        if (b == 0){
            return result;
        }
        result = a * power(a, b - 1);
        return result;
    }

}
