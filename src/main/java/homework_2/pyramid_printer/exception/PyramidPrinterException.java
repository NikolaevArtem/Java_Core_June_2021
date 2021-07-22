package homework_2.pyramid_printer.exception;

import homework_2.pyramid_printer.utils.MessageType;

public class PyramidPrinterException extends Throwable {
    public PyramidPrinterException(MessageType e) {
        super(e.getMessage());
    }
}
