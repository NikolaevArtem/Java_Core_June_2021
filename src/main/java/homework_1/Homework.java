package homework_1;

public class Homework {
    private static final String WARNING_MESSAGE = "Alarm!";
    private static final String NOT_FOUND_MESSAGE = "Arguments have not been found! Please enter arguments when starting the program!";
    private static final String INVALID_ARGUMENT = "error";
    private static final String OUTPUT_PATTERN = "%s: %d %s\n";

    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println(NOT_FOUND_MESSAGE);
            return;
        }
        for (String s : args) {
            if (s.equals(INVALID_ARGUMENT)) {
                System.err.println(WARNING_MESSAGE);
                return;
            }
            System.out.printf(OUTPUT_PATTERN, s, s.length(), generateNumerator(s.length()));
        }
    }

    private static String generateNumerator(int wordLength) {
        return wordLength == 1 ? "letter" : "letters";
    }
}