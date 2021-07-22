package homework_2.random_chars_table.exception;

import homework_2.random_chars_table.utils.MessageType;

public class RandomCharsTableException extends RuntimeException {
    public RandomCharsTableException(MessageType e) {
        super(e.getMessage());
    }
}
