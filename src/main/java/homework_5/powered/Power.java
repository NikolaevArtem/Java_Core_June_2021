package homework_5.powered;


public class Power {

    private Power() {}

    public static double power(double base, int p) {
        if (p != 0) return base * power(base, p-1);
        return 1;
    }

}
