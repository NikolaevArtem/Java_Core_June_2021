package homework_2.pyramid_printer.bin;

import homework_2.pyramid_printer.sources.OptimizedPyramidPrinter;
import homework_2.pyramid_printer.sources.PyramidPrinter;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            new PyramidPrinter().run();
        } else {
            new OptimizedPyramidPrinter().run(args[0]);
        }
    }
}
