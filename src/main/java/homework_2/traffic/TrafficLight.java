package homework_2.traffic;

import homework_2.utils.Data;
import homework_2.utils.Executable;

public class TrafficLight implements Executable {
    private final static int MAX_VALUE = 86399;
    private final static int MIN_VALUE = 0;

    private final static int GREEN_START = 0;
    private final static int GREEN_END = 35;
    private final static int RED_START = 40;
    private final static int RED_END = 55;

    private final static String ERR_MAX_MSG = "Error: день закончен)";
    private final static String ERR_NEGATIVE_MSG = "Error: Отрицательное число недопустимо";
    private final static String ERR_STRING_MSG = "Error: Допустимо только число(max 2^31)";

    @Override
    public void execute(Data data) {
        //повторяется думаю как убрать
        switch (data.getType()) {
            case STRING:
                data.setError(ERR_STRING_MSG);
                return;
            case NEGATIVE_INTEGER:
                data.setError(ERR_NEGATIVE_MSG);
                return;
            case INTEGER:
            default:
                break;
        }

        int value = Integer.parseInt(data.getInValue());
        Color color;
        if (!checkIntValue(value)) {
            data.setError(ERR_MAX_MSG);
        } else {
            int sec = value % 60;
            if (sec >= GREEN_START && sec < GREEN_END) {
                color = Color.GREEN;
            } else if (sec >= RED_START && sec < RED_END) {
                color = Color.RED;
            } else {
                color = Color.YELLOW;
            }
            data.setResult(color.name());
        }
    }

    private boolean checkIntValue(int value) {
        return value <= MAX_VALUE;
    }
}
