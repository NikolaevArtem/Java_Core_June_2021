package homework_2.pyramid_printer;

public class PyramidPrinterException extends Throwable {
    public PyramidPrinterException(MessageType e) {
        super(e.getMessage());
    }
}
