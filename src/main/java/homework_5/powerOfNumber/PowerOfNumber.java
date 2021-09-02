package homework_5.powerOfNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PowerOfNumber {

    private int number;
    private int power;

    private int recursion(int firstNumber, int secondNumber) {
        if(secondNumber < 1) return 1;
        return firstNumber * recursion(firstNumber, secondNumber - 1);
    }

    public void run() {
        String inputString = bufferReaderConsole();
        if(validator(inputString)) {
            System.out.println(recursion(number, power));
        } else {
            System.out.println("Only 2 non-negative integers are allowed");
        }
    }

    private String bufferReaderConsole() {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            return reader.readLine();
        } catch(IOException ex) {
            return "";
        }
    }

    public boolean validator(String input) {
        try {
            String[] arr = input.split(" ");
            if(arr.length != 2) {
                return false;
            }
            number = Integer.parseInt(arr[0]);
            power = Integer.parseInt(arr[1]);
            if(number < 0 || power < 0) {
                return false;
            }
        } catch(NumberFormatException | NullPointerException ex) {
            return false;
        }
        return true;
    }

}
