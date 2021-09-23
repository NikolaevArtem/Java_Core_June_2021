package homework_5.power_of_number;

import java.util.Scanner;

public class PowerOfNumber {

    public int pow(int number, int pow) {
        if(number < 0 || pow < 0){
            throw new IllegalArgumentException();
        }
        if(pow == 0){
            return 1;
        }
        if(pow == 1) {
            return number;
        }
        return number * pow(number, --pow);
    }

    public void run() {
        System.out.print("Enter two numbers(number, pow): ");
        Scanner scanner = new Scanner(System.in);
        try {
            String str = scanner.nextLine();
            String[] split = str.split(",? ");
            if (split.length != 2) {
                throw new IllegalArgumentException();
            }
            System.out.println("Result: " + pow(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
        } catch (Exception e){
            System.out.println("Only 2 non-negative integers are allowed");
        }
    }
}
