package homework_5;

public class PowerRecursion {
    private int n;
    private int power;

    public PowerRecursion(int n, int power) {
        if (power < 0) {
            throw new IllegalArgumentException();
        }
        this.n = n;
        this.power = power;
    }

    public long run() {
        return power(1, 0);
    }

    private long power(int res, int count) {
        if (count == power) {
            return res;
        }
        return power(n * res, ++count);
    }
}
