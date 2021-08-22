package homework_5.powerOfNumber;

import homework_5.AppHW_5;

import java.util.Scanner;

public class PowerOfNumber extends AppHW_5 {
    private final static String PATTERN_STRING = "[0-9]* [0-9]*";
    private final static String ERROR = "Only 2 non-negative integers are allowed";

    public PowerOfNumber() {
        super(PATTERN_STRING);
    }

    public String run() {
        String result;
        try {
            readData();
            if (!check()) result = ERROR;
            else result = calculate();
        } catch (Exception ex) {
            return ERROR;
        }
        finally {
            closeReader();
        }

        System.out.println(result);
        return result;
    }

    private String calculate() {
        Scanner sc = new Scanner(getData());
        return String.valueOf(Exponent.calculate(sc.nextInt(), sc.nextInt()));
    }

    public static void main(String[] args) {
        new PowerOfNumber().run();
    }

}
