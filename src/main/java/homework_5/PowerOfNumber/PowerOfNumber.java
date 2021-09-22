package homework_5.PowerOfNumber;

public class PowerOfNumber {

    public void run() {

        InputValidator inputValidator = new InputValidator();
        int [] input = inputValidator.input();
        if (input.length > 1) {
            System.out.println(power(input[0], input[1]));
        }
    }

    private long power(int a, int b) {

        if (b < 1) {
            return 1;
        }
        return a * power(a, b - 1);
    }
}
