package homework_2.random_chars_table;

public class RandomCharsTableCreator {

    private final int rows;
    private final int columns;

    RandomCharsTableCreator(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public char[][] createTable() {
        char[][] table = new char[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                table[i][j] = (char) ('A' + Math.random() * 26);
            }
        }
        return table;
    }
}
