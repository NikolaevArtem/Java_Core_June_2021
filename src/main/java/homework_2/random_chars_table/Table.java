package homework_2.random_chars_table;

public class Table {
    private final char TABLE_SPLITTER = '|';

    private int width;
    private int height;
    private StrategyCharacterSet.Strategy strategy;

    private char[][] table;

    public Table(int width, int height, StrategyCharacterSet.Strategy strategy) {
        this.width = width;
        this.height = height;
        this.strategy = strategy;

        table = new char[height][width];
    }

    public char[][] getTable() {
        return table;
    }

    public void setTable(char[][] table) {
        this.table = table;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public StrategyCharacterSet.Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(StrategyCharacterSet.Strategy strategy) {
        this.strategy = strategy;
    }

    protected void fillTable() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j ++) {
                table[i][j] = getRandomChar();
            }
        }
    }

    protected void printTable() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j ++) {
                System.out.print(TABLE_SPLITTER);
                System.out.print(table[i][j]);
            }
            System.out.println(TABLE_SPLITTER);
        }
    }

    private char getRandomChar() {
        int range = 'Z' - 'A';
        return (char) (Math.random() * range + 'A');
    }
}
