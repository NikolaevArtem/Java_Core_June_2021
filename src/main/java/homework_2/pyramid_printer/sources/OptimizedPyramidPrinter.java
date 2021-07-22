package homework_2.pyramid_printer.sources;

import java.io.IOException;

import static homework_2.IOMod.*;
import static homework_2.Colors.*;

public class OptimizedPyramidPrinter {

    public void run(String arg) {
        if (arg.equalsIgnoreCase("o") || arg.equalsIgnoreCase("optimized")) {
            try {
                int h = inputHeight();
                printPyramid(h);
            } catch (IOException e) {
                System.out.println(CYAN_BG + ERROR + ANSI_RESET);
            }
        } else {
            System.out.println("Incorrect argument. You can call this app as:\n" +
                    PURPLE_BG + "java Main -o" + ANSI_RESET + "\nor\n" +
                    BLUE_BG + "java Main -optimized" + ANSI_RESET);
        }
    }

    private int inputHeight() throws IOException {
        System.out.print("Please, input pyramids height value: ");
        int pyramidHeight = bufferedReaderIntReader();
        assert (pyramidHeight < 0) : ERROR;
        return pyramidHeight;
    }

    private void printPyramid(int height) {
        for (int i = 0; i < height; i++) {
            System.out.println(genPyramidRow(i + 1));
        }
    }

    private String genPyramidRow(int rowLen) {
        StringBuilder xRow = new StringBuilder();
        for (int i = 0; i < rowLen; i++) {
            xRow.append('x');
        }
        return xRow.toString();
    }

}
