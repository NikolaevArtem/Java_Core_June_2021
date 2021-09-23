package homework_5.power_of_number;

import java.util.Scanner;

public class PowerOfNumber {

    private static final String ERR_MESSAGE = "Only 2 non-negative integers are allowed";

    public void run() {
        System.out.println("Please enter number and power of this number: ");
        String inputString = "";
        try (Scanner scanner = new Scanner(System.in)) {
            if (scanner.hasNextLine()) {
                inputString = scanner.nextLine().trim();
            }
            if (!inputString.matches("\\d+\\s+\\d+")) {
                System.out.println(ERR_MESSAGE);
            } else {
                int number = Integer.parseInt(inputString.split("\\s+")[0]);
                int power = Integer.parseInt(inputString.split("\\s+")[1]);
                System.out.println(powerOfN(number, power));
            }
        }
    }

    private int powerOfN(int number, int pow) {
        if (pow == 0) {
            return 1;
        }
        return powerOfN(number, pow - 1) * number;
    }
}
