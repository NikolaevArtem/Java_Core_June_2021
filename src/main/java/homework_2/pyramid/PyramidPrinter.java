package homework_2.pyramid;

import homework_2.utils.Data;
import homework_2.utils.Executable;

public class PyramidPrinter implements Executable {

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

        int baseOfPyramid = Integer.parseInt(data.getInValue());
        StringBuilder strBuilder = new StringBuilder();
        StringBuilder result = new StringBuilder("\n");
        for (int i = 0; i < baseOfPyramid; i++) {
            strBuilder.append('x');
            result
                    .append(strBuilder)
                    .append('\n');
        }
        data.setResult(result.toString());
    }
}
