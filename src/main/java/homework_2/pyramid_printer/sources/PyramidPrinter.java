package homework_2.pyramid_printer.sources;

import java.io.IOException;

import static homework_2.IOMod.ERROR;
import static homework_2.IOMod.bufferedReaderIntReader;

public class PyramidPrinter {

    public void run() {
        try {
            int height = inputHeight();
            printPyramid(height);
        } catch (IOException e) {
            System.out.println(ERROR);
            return;
        }
    }

    private int inputHeight() throws IOException {
        System.out.print("Please, input pyramids height value: ");
        int pyramidHeight = bufferedReaderIntReader();
        if (pyramidHeight < 0) {
            System.out.println(ERROR);
            throw new IOException();
        }
        return pyramidHeight;
    }

    private void printPyramid(int height) {
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("x");
            }
            System.out.println();
        }
    }

}
