package homework_5.exponentiation_via_recursion;

public class ExponentiationViaRecursion {
    public long run(int number, int degree) {
        if (degree == 0) {
            return 1;
        } else if (number == 0) {
            return 0;
        } else {
            return number * run(number, degree - 1);
        }
    }
}