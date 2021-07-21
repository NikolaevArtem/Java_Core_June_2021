package homework_2.random_chars_table;

public enum MessageType {
    INFO_MESSAGE_FOR_COLUMNS("Enter a positive integer for columns: "),
    INFO_MESSAGE_FOR_ROWS("Enter a positive integer for rows: "),
    INFO_MESSAGE_FOR_STRATEGY("Enter the word \"odd\" or \"even\" without quotes for strategy: "),
    INTEGER_ERROR_MESSAGE("It was not a positive integer."),
    STRATEGY_ERROR_MESSAGE("It was not a word \"odd\" or \"even\"."),
    ERROR_MESSAGE("Something went wrong. Please restart the program!");

    private final String message;

    MessageType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
