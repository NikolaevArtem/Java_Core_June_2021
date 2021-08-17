package homework_5.recursion;

public class Recursion {

    public double recPow(double n, double power) {
        if (power == 0) {
            return 1;
        } else if (power > 0) {
            return n * recPow(n, power - 1);
        } else {
            return (1 / n) * recPow(n, power + 1);
        }
    }
}
