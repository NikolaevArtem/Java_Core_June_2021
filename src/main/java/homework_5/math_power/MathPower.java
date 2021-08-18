package homework_5.math_power;

public class MathPower {

    public static double pow(double value, int powValue) {
        if (powValue < 0) {
            return 1 / pow(value, - powValue);
        }
        return powValue == 1 ? value : value * pow(value, powValue - 1);
    }
}
