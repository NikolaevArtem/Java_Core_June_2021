package homework_5.exp_w_rec;

public class ExpWRec {
    public static double run(double number, int degree) {
       if (degree != 0){
            return number * run(number, degree - 1);
        }
       return 1;
    }
}