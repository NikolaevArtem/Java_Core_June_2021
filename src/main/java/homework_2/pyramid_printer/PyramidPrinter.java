package homework_2.pyramid_printer;

import homework_2.WrongInputException;
import java.io.IOException;

public class PyramidPrinter {
    private final char SPEC_CHAR = 'x';

    public void run() throws IOException {
        try {
            InputReader inputReader = new InputReader();
            int n = inputReader.readNum();

            System.out.println(getPyramid(n));
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        }
    }

    private String getPyramid(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                stringBuilder.append(SPEC_CHAR);
            }
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }
}
