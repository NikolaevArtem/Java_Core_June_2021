package homework_5.power_of_number;

import java.util.Arrays;
import java.util.Scanner;

public class PowerOfNumber {
    private final Scanner sc = new Scanner(System.in);
    private final String ERROR = "Only 2 non-negative integers are allowed";

    public void run() {
        String input = sc.nextLine();
        Integer[] inputData = parseData(input);
        int value = inputData[0];
        int powValue = inputData[2];
        int result = pow(value, powValue);
        if(result == -1){
            System.out.println(ERROR);
        } else {
            System.out.println(result);
        }
    }

    private int pow(int value, int powValue) {
        if (powValue == 0) {
            return 1;
        } else if (powValue == 1) {
            return value;
        } else if (value < 0 || powValue < 0) {
            return -1;
        } else {
            return value * pow(value, powValue - 1);
        }
    }

    private Integer[] parseData(String s) {
        Character[] array = s.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
        if (array.length != 3 || (!Character.isDigit(array[0])) || (!Character.isDigit(array[2]))) {
            return new Integer[]{-1, 0, -1};
        } else {
            return Arrays.stream(array).map(Character::getNumericValue).toArray(Integer[]::new);
        }
    }
}
