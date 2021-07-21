package homework_2.pyramid_printer;

import java.io.IOException;

import static homework_2.IOMod.bufferedReaderIntReader;

public class PyramidPrinter {

    public void run() throws IOException {
        menu();
    }

    private void menu() throws IOException {
        System.out.print("Please, input pyramids height value: ");
        int pyramidHeight = Math.abs(bufferedReaderIntReader());
        assert (pyramidHeight != 0) : "the plane is still a plane";
        printPyramid(pyramidHeight);
    }

    private void printPyramid(int height) {
        for (int i = 1; i <= height; i ++) {
            System.out.println(genPyramidRow(i));
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
