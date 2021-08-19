package homework_5.math_power;

import static homework_5.math_power.utils.Constants.ERROR_MESSAGE;
import static homework_5.math_power.utils.Utils.isValid;
import static homework_5.math_power.utils.Utils.printMessage;

public class PowerOfNumber {

    public void run(String[] args) {
        if (isValid(args)) {
            printMessage(String.valueOf(pow(Integer.parseInt(args[0]), Integer.parseInt(args[1]))));
        } else {
            printMessage(ERROR_MESSAGE);
        }
    }

    private long pow(int value, int powValue) {
        if (powValue == 0) {
            return 1;
        }
        return powValue == 1 ? value : value * pow(value, powValue - 1);
    }
}
