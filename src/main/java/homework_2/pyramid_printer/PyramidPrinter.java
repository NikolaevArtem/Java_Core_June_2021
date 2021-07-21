package homework_2.pyramid_printer;

import homework_2.bufferReaders.BufferReader;
import java.io.IOException;

public class PyramidPrinter {
    public void run() throws IOException {
       BufferReader bufferReaderForPyramid = new BufferReader();
       int pyramidLength = bufferReaderForPyramid.bufferReaderForPyramid();
        for (int i = 0; i < pyramidLength; i++) {
            for(int j = 0; j <= i; j ++) {
                System.out.print("x ");
            }
            System.out.println();
        }
    }
}
