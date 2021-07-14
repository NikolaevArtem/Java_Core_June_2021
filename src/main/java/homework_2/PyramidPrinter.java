package homework_2;

import java.io.IOException;
import static homework_2.BufferReader.bufferReaderForPyramid;

public class PyramidPrinter {
    public static void main(String[] args) throws IOException {
       int level = bufferReaderForPyramid();
        for (int i = 0; i < level; i++) {
            for(int j = 0; j <= i; j ++) {
                System.out.print("x ");
            }
            System.out.println();
        }
    }
}
