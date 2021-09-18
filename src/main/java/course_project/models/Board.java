package course_project.models;

import java.util.*;

public class Board {
    private HashMap<Integer, List<String>> board;
    private final List<Integer> rowNames = Arrays.asList(1, 2 , 3, 4, 5, 6, 7, 8, 9, 10);
    private final List<String> colNames = Arrays.asList("a", "b" , "c", "d", "e", "f", "g", "h", "i", "j");
    private final List<String> emptyRows = Arrays.asList(" ", " " , " ", " ", " ", " ", " ", " ", " ", " ");

    public Board() {
        this.board = new HashMap<>();
        for (int r : rowNames) {
            board.put(r, getEmptyRows());
        }
    }

    private List<String> getEmptyRows() {
        return new ArrayList<>(emptyRows);
    }

    public List<Integer> getRowNames() {
        return this.rowNames;
    }

    public List<String> getColNames() {
        return this.colNames;
    }

    public HashMap<Integer, List<String>> getBoard() {
        return this.board;
    }

    public void changeCell(Coordinate coordinate, String sign) {
        List<String> currentRow = board.get(coordinate.Row());
        currentRow.set(coordinate.Col(),sign);
        board.put(coordinate.Row(), currentRow);
    }

    public String getCell(Coordinate c) {
        return board.get(c.Row()).get(c.Col());
    }
}
