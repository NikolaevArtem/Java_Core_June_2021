package homework_2.pyramid_printer.sources;

import static homework_2.IOMod.*;
import static homework_2.Colors.*;

public class OptimizedPyramidPrinter {

    public void run(String arg) {
        if (arg.equalsIgnoreCase("o") || arg.equalsIgnoreCase("optimized")) {
            System.out.print("Please, input Pyramid height: ");
            int h = bufferedReaderIntReader();
            if (h < 0) {
                System.out.println(ERROR);
                return;
            }
            printPyramid(h);
        } else {
            System.out.println("Incorrect argument. You can call this app as:\n" +
                    PURPLE_BG + "java Main -o" + ANSI_RESET + "\nor\n" +
                    BLUE_BG + "java Main -optimized" + ANSI_RESET);
        }
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
