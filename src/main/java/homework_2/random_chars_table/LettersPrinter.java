package homework_2.random_chars_table;

import java.util.HashSet;
import java.util.Set;

public class LettersPrinter {

    private final Set<String> setLetters = new HashSet<>();

    public void lettersPrint(int strategyFlag) {
        if (strategyFlag == 0) {
            System.out.println("Even letters - " +
                    String.join(", ", setLetters));
        } else {
            System.out.println("Odd letters - " +
                    String.join(", ", setLetters));
        }
    }

    public void strategyStringBuilder(char currentChar, int strategyFlag) {
        if (currentChar % 2 == strategyFlag) {
            setLetters.add(Character.toString(currentChar));
        }
    }
}
