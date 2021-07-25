package homework_2.pyramid_printer;

public class Main {
    public static void main(String[] args) {
        if (args.length > 1) {
            System.out.println("Only 1 parameter is allowed");
        } else if (args.length == 0) {
            new PyramidPrinter().run();
        } else if (args[0].equals("dRepresentation")) {
            new ExtraPyramidPrinter().run();
        }
    }
}
