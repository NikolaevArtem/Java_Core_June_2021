package homework_2;

import java.io.IOException;
import static homework_2.IOMod.bufferedReaderIntReader;

public class PyramidPrinter {

    public static void main(String[] args) throws IOException {
        System.out.print("Please, input pyramids height value: ");
        int pyramidHeight = bufferedReaderIntReader();
        assert (pyramidHeight > 0); // need nothing to do if input is less then 1
        for (int i = 1; i <= pyramidHeight; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("x");
            }
            System.out.println();
        }
    }

}
