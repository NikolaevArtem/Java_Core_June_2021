package homework_5.powerOfNumber;

import java.util.Scanner;

public class PowerOfNumber {
   public void run() {
       Scanner scanner = new Scanner(System.in);
       try {
           int fir = scanner.nextInt();
           int sec = scanner.nextInt();
           PowerOfNumber power = new PowerOfNumber();
           int result = power.rec(fir, sec);
           System.out.println(result);
       } catch (Exception e) {
           System.out.println("Only 2 non-negative integers are allowed");
       } finally {
           scanner.close();
       }
   }
   public int rec(int firstNumber, int secondNumber) {
        if (firstNumber < 0 || secondNumber < 0) {
            throw new RuntimeException("Only 2 non-negative integers are allowed");
        }
        if (secondNumber == 0) {
            return 1;
        }
        if (secondNumber > 0 ) {
            return firstNumber * rec(firstNumber, secondNumber-1);
        }
        return rec(firstNumber, secondNumber) * secondNumber;
    }
}