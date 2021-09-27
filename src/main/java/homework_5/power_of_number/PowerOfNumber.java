package homework_5.power_of_number;

import java.util.Scanner;

public class PowerOfNumber {
    private static final String GREETING = "Enter two non-negative integers (the number and the desired power for it), split with blank:";
    private static final String ERROR_MSG = "Only 2 non-negative integers are allowed!";
    private int a, b;
    private boolean inputIsValid = true;

    public void run(){
        System.out.println(GREETING);
        readValidInput();
        if (inputIsValid) {
            int res = powerOfInt(a, b);
            System.out.println(res);
        }

    }

    private void readValidInput() {
        try (Scanner scanner = new Scanner(System.in)) {
            String s = scanner.nextLine();
            if (s.matches("\\d+\\s\\d+")) {
                a = Integer.parseInt(s.split("\\s")[0]);
                b = Integer.parseInt(s.split("\\s")[1]);
                if (a < 0 || b < 0) {
                    throw new IllegalArgumentException();
                }
            } else {
                throw new IllegalArgumentException();
            }
        }
        catch (RuntimeException e){
            System.out.println(ERROR_MSG);
            inputIsValid = false;
        }

    }

    private int powerOfInt(int n, int pow) {
        if (pow == 0) {
            return 1;
        }
        return n * powerOfInt(n, pow - 1);

    }

}
