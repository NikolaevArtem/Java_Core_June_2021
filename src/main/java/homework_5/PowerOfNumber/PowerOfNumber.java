package homework_5.PowerOfNumber;

public class PowerOfNumber {

    public void run() {
        InputValidator inputValidator = new InputValidator();
        inputValidator.run(this);
    }

    void input(int a, int b) {
        print(a, b);
    }


    private long power(int a, int b) {
        if (b < 1) {
            return 1;
        }
        return a * power(a, b - 1);
    }

    private void print(int a, int b) {
        System.out.println(power(a, b));
    }

}
