package homework_5.power_of_number;

import java.util.Scanner;

public class PowerOfNumber {
    private static final String ERROR_MSG = "Only 2 non-negative integers are allowed";

    public void run() {
        Scanner scanner = new Scanner(System.in);
        try {
            int number = scanner.nextInt();
            int pow = scanner.nextInt();
            checkInput(number, pow);
            System.out.println(recursivePow(number,pow));
        } catch (Exception e){
            System.out.println(ERROR_MSG);
        }
        scanner.close();
    }

    private void checkInput (int number, int pow) throws Exception{
        if(number<0 || pow < 0){
            throw new RuntimeException();
        }
    }

    private int recursivePow(int number, int power)
    {
        if (power == 0) return 1;
        return power == 1 ? number : number * recursivePow(number, power - 1);
    }
}
