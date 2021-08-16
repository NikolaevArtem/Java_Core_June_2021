package homework_5.exponentiation_via_recursion;

public class ExponentiationViaRecursion {
    public static double run(double number, int degree) {
       if (degree != 0){
            return number * run(number, degree - 1);
        }
       return 1;
    }
}