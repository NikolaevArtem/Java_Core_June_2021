package homework_2.pyramid_printer;

public class Main {
    public static void main(String[] args) {
        if (args.length > 1) {
            System.out.println("Only 1 parameter is allowed");
        } else if (args.length == 0) {
            System.out.println("Mode: x Representation");
            PyramidPrinter.xRepresentation();
        } else if (args[0].equals("dRepresentation")) {
            System.out.println("Mode: Digital Representation");
            PyramidPrinter.dRepresentation();
        }
    }
}
