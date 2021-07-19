package homework_2;

import java.io.IOException;
import static homework_2.IOMod.bufferedReaderIntReader;

public class PyramidPrinter {

    public static void main(String[] args) throws IOException {
        System.out.print("Please, input pyramids height value: ");
        int pyramidHeight = Math.abs(bufferedReaderIntReader());
        assert (pyramidHeight != 0) : "the plane is still a plane";
        printPyramid(pyramidHeight);
    }

    private static void printPyramid(int height) {
        for (int i = 1; i <= height; i ++) {
            System.out.println(genPyramidRow(i));
        }
    }

    private static String genPyramidRow(int row_len) {
        StringBuilder x_row = new StringBuilder();
        for (int i = 0; i < row_len; i++) {
            x_row.append('x');
        }
        return x_row.toString();
    }

}
