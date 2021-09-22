package course_project.field_components;

import course_project.SeaBattle;
import course_project.enums.CellState;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Field {
    private static final int SIZE = SeaBattle.FIELD_SIZE;
    private final Cell[][] field = new Cell[SIZE][SIZE];

    private static final String RED_COLOUR = "\u001B[31m";
    private static final String GREEN_COLOUR = "\u001B[32m";
    private static final String RESET_COLOUR = "\u001B[0m";

    public Field() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                field[i][j] = new Cell(i, j);
            }
        }
    }

    public Cell getCell(Coordinate coordinate) {
        return getCell(coordinate.row,coordinate.column);
    }

    public Cell getCell(int r, int c) {
        return field[r][c];
    }

    public List<Cell> getNeighbourCells(Coordinate coordinate) {
        return getNeighbourCells(coordinate.row, coordinate.column);
    }

    public List<Cell> getNeighbourCells(int r, int c) {
        Cell topCell = r == 0 ? null : field[r - 1][c];
        Cell topLeftCell = r == 0 || c == 0 ? null : field[r - 1][c - 1];
        Cell topRightCell = r == 0 || c == 9 ? null : field[r - 1][c + 1];
        Cell bottomCell = r == 9 ? null : field[r + 1][c];
        Cell bottomLeftCell = r == 9 || c == 0 ? null : field[r + 1][c - 1];
        Cell bottomRightCell = r == 9 || c == 9 ? null : field[r + 1][c + 1];
        Cell leftCell = c == 0 ? null : field[r][c - 1];
        Cell rightCell = c == 9 ? null : field[r][c + 1];
        return Stream.of(topCell, bottomCell, leftCell, rightCell,
                topLeftCell, topRightCell, bottomLeftCell, bottomRightCell)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public void print(boolean hideShips) {
        if (hideShips) {
            System.out.print(RED_COLOUR);
        } else {
            System.out.print(GREEN_COLOUR);
        }
        System.out.println(letters());
        for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE + 1; j++) {
                    if (j == 0) {
                        System.out.printf("%2s", i + 1);
                    } else {
                        Cell cell = field[i][j - 1];
                        boolean isSecret = hideShips && cell.checkState(CellState.DECK);
                        String allowed = isSecret ? CellState.EMPTY.toString() : cell.toString();
                        System.out.printf(" %s", allowed);
                    }
                }
            System.out.println();
        }
        System.out.println(RESET_COLOUR);
    }

    private String letters() {
        StringBuilder sb = new StringBuilder("  ");
        for (int i = 0; i < SIZE; i++) {
            sb.append(" ").append((char) (65 + i));
        }
        return sb.toString();
    }
}
