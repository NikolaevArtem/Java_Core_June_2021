package homework_2.pyramid_printer;

import homework_2.utils.AppWithIntInput;

public class PyramidPrinter extends AppWithIntInput {

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
