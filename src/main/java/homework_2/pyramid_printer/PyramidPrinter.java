package homework_2.pyramid_printer;

public class PyramidPrinter {

    public void run() {
        InputPyramidReader IOHelperForPyramid = new InputPyramidReader();
        int pyramidLength = IOHelperForPyramid.bufferReaderForPyramid();

        for(int i = 0; i < pyramidLength; i++) {
            for(int j = 0; j <= i; j++) {
                System.out.print("x");
            }
            System.out.println();
        }
    }
}
