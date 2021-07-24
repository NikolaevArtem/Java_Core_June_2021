package homework_2.pyramid_printer;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            new PyramidPrinter().run();
        } else {
            new OptimizedPyramidPrinter().run(args[0]);
        }
    }
}
