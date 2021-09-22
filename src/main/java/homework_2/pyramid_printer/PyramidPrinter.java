package homework_2.pyramid_printer;

import static homework_2.IOMod.ERROR;
import static homework_2.IOMod.bufferedReaderIntReader;

public class PyramidPrinter {

    public void run() {
        System.out.print("Please, input Pyramid height: ");
        int height = bufferedReaderIntReader();
        if (height < 0) {
            System.out.println(ERROR);
            return;
        }
        printPyramid(height);
    }

    private void printPyramid(int height) {
        for (int i = 0; i < height; i++) {
            for (int j = 1; j <= i + 1; j++) {
                System.out.print("x");
            }
            System.out.println();
        }
    }

}
