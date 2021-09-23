package homework_2.random_chars_table;

import java.util.HashSet;
import java.util.Set;

public class StrategyCharacterSet {
    private final Set<String> characterSet = new HashSet<>();

    enum Strategy {
        ODD,
        EVEN
    }

    public Set<String> getCharacterSet() {
        return characterSet;
    }

    protected void fillCharacterSet(Table table) {
        char[][] chars = table.getTable();
        for (int i = 0; i < table.getHeight(); i++) {
            for (int j = 0; j < table.getWidth(); j ++) {
                if (isStrategyOK(chars[i][j], table.getStrategy())) {
                    characterSet.add(chars[i][j] + "");
                }
            }
        }
    }

    protected void printCharacterSet(Strategy strategy) {
        System.out.print(strategy.name().charAt(0)
                + strategy.name().substring(1).toLowerCase() + " letters - ");
        System.out.println(String.join(", ", characterSet));
    }

    private boolean isStrategyOK(char c, Strategy strategy) {
        boolean isEven = c % 2 == 0;
        return (strategy == Strategy.EVEN) == isEven;
    }
}
