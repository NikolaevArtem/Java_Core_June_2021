package course_project;

public class Field {
    private static final int SIZE = 10;
    private final Cell[][] field = new Cell[SIZE][SIZE];

    public Field() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                field[i][j] = new Cell();
            }
        }
    }

    public Cell getCell(String coordinate) {
        return getCell(new Coordinate(coordinate));
    }

    public Cell getCell(Coordinate coordinate) {
        return field[coordinate.row][coordinate.column];
    }

    public void setCell(Coordinate point, CellState newState) {
        getCell(point).setState(newState);
    }

    public void print(boolean hideShips) {
        System.out.println(letters());
        for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE + 1; j++) {
                    if (j == 0) {
                        System.out.printf("%2s", i + 1);
                    } else {
                        Cell cell = field[i][j - 1];
                        boolean isSecret = hideShips && cell.getState().equals(CellState.DECK);
                        String allowed = isSecret ? CellState.EMPTY.toString() : cell.toString();
                        System.out.printf(" %s", allowed);
                    }
                }
            System.out.println();
        }
        System.out.println();
    }

    private String letters() {
        StringBuilder sb = new StringBuilder("  ");
        for (int i = 0; i < SIZE; i++) {
            sb.append(" ").append((char) (65 + i));
        }
        return sb.toString();
    }
}
