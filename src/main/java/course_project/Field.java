package course_project;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Field {
    private static final int SIZE = SeaBattle.FIELD_SIZE;
    private final Cell[][] field = new Cell[SIZE][SIZE];

    public Field() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                field[i][j] = new Cell(i, j);
            }
        }
    }

    public CellState getCellState(Coordinate coordinate) {
        return getCell(coordinate).getState();
    }

    public void setCellState(Coordinate point, CellState newState) {
        getCell(point).setState(newState);
    }

    public Cell getCell(String coordinate) {
        return getCell(new Coordinate(coordinate));
    }

    public Cell getCell(Coordinate coordinate) {
        return getCell(coordinate.row,coordinate.column);
    }

    public Cell getCell(int r, int c) {
        return field[r][c];
    }

    public List<Cell> getNeighbourCells(String coordinate) {
        return getNeighbourCells(new Coordinate(coordinate));
    }

    public List<Cell> getNeighbourCells(Coordinate coordinate) {
        return getNeighbourCells(coordinate.row, coordinate.column);
    }

    public List<Cell> getNeighbourCells(int r, int c) {
        Cell topCell = r == 0 ? null : field[r - 1][c];
        Cell bottomCell = r == 9 ? null : field[r + 1][c];
        Cell leftCell = c == 0 ? null : field[r][c - 1];
        Cell rightCell = c == 9 ? null : field[r][c + 1];
        return Stream.of(topCell, bottomCell, leftCell, rightCell)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
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
