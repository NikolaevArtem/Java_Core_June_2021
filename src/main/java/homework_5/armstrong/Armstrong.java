package homework_5.armstrong;

import homework_5.powered.Power;

public class Armstrong {

    public static void main(String[] args) {
        int a = 135;
        int b = 370;
        int c = 12;
        int d = 1234567;
        System.out.println("arm(135, digitCounter(135)) = " + (long) arm(a, digitCounter(a)));
        System.out.println("arm(370, digitCounter(370)) = " + (long) arm(b, digitCounter(b)));
        System.out.println("arm(12, digitCounter(12)) = " + (long) arm(c, digitCounter(c)));
        System.out.println("arm(1234567, digitCounter(1234567)) = " + (long) arm(d, digitCounter(d)));
    }

    public static double arm(long n, int p) {
        if (n < 10) return Power.power(n, p);
        return Power.power(n%10, p) + arm(n/10, p);
    }

    public static int digitCounter(int num) {
        if (Math.abs(num) < 10) return 1;
        return 1 + digitCounter(Math.abs(num)/10);
    }

}
