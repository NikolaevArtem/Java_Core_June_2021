package homework_2.pyramid_printer;

public class PyramidPrinter {

    private void printerPyramid(int height) {
        for (int i = 1; i <= height; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("x");
            }
            System.out.println();
        }
    }

    public void run() {
        System.out.println("Pyramid Printer App \nEnter height: ");
        printerPyramid(new InputValidator().input());
    }
}
