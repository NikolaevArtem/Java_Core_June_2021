package homework_2.pyramid_printer;

import homework_2.bufferReaders.IOHelper;

public class PyramidPrinter {

    public void run() {
       IOHelper IOHelperForPyramid = new IOHelper ();
       int pyramidLength = IOHelperForPyramid.bufferReaderForPyramid();

        for (int i = 0; i < pyramidLength; i++) {
            for(int j = 0; j <= i; j ++) {
                System.out.print("x");
            }
            System.out.println();
        }
    }
}
