package homework_2.random_chars_table;

import java.util.LinkedList;
import java.util.List;

public class TablePrinter {

    private final int rows;
    private final int columns;
    private final int remains;
    private final String strategy;
    private List<Character> charList;

    public TablePrinter(int rows, int columns, String strategy) {
        this.rows = rows;
        this.columns = columns;
        this.strategy = strategy;
        remains = "even".equalsIgnoreCase(strategy) ? 0 : 1;
    }

    public void printTable() {
        charList = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            System.out.print("| ");
            for (int j = 0; j < columns; j++) {
                char ch = (char) (Math.round(Math.random() * 25) + 65);
                if (ch % 2 == remains && !charList.contains(ch)) {
                    charList.add(ch);
                }
                System.out.print(ch + " | ");
            }
            System.out.println();
        }
    }

    public void printLetters() {
        System.out.print(strategy + "letters - ");
        for (int i = 0; i < charList.size(); i++) {
            if (i != charList.size() - 1) {
                System.out.print(charList.get(i) + ", ");
            } else {
                System.out.println(charList.get(i));
            }
        }
    }
}
