package homework_2.pyramid_printer.utils;

public enum MessageType {
    INFO_MESSAGE("Please enter a positive integer for rows"),
    ERROR_MESSAGE("Something went wrong. Please restart the program!"),
    ERROR_WRONG_FORMAT_MESSAGE("Only positive integers are allowed.");

    private final String message;

    MessageType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
