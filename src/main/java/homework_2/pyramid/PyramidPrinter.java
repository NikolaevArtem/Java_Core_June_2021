package homework_2.pyramid;

import homework_2.utils.AppWithIntInput;
import homework_2.utils.Executable;

public class PyramidPrinter extends AppWithIntInput {

    public static void main(String[] args) {
        Executable pyramidPrinter = new PyramidPrinter();
        pyramidPrinter.execute();
    }
    @Override
    protected String calculate() {
        if (error != null) return error;
        StringBuilder strBuilder = new StringBuilder();
        StringBuilder result = new StringBuilder("\n");
        for (int i = 0; i < data; i++) {
            strBuilder.append('x');
            result
                    .append(strBuilder)
                    .append('\n');
        }
        return result.toString();
    }
}
