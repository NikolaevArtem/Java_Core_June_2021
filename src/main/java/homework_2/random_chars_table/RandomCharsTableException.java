package homework_2.random_chars_table;

public class RandomCharsTableException extends RuntimeException {
    public RandomCharsTableException(MessageType e) {
        super(e.getMessage());
    }
}
