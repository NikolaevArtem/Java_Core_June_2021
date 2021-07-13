package homework_2;

import java.io.IOException;

public class PyramidPrinter {

    public static void main(String[] args) throws IOException {
        System.out.print("Please, input pyramids height value: ");
        int pyramidHeight = IOMod.bufferedReaderPyramidHeight();
        if (pyramidHeight <= 0) {
            return;
        }
        for (int i = 1; i <= pyramidHeight; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("x");
            }
            System.out.println();
        }
    }

}
