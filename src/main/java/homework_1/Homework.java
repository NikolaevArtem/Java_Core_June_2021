package homework_1;

public class Homework {
    private static final String WARNING_MESSAGE = "Тревога!";
    private static final String NOT_FOUND_MESSAGE = "Аргументы не найдены! Задайте аргументы при запуске программы!";
    private static final String INVALID_ARGUMENT = "ошибка";
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
        if (wordLength % 10 == 1 && wordLength != 11) {
            return "буква";
        }
        return getPlural(wordLength);
    }

    private static String getPlural(int wordLength){
        if ((wordLength % 10 == 2 && wordLength != 12) ||
                (wordLength % 10 == 3 && wordLength != 13) ||
                (wordLength % 10 == 4 && wordLength != 14)) {
            return "буквы";
        }
        return "букв";
    }
}