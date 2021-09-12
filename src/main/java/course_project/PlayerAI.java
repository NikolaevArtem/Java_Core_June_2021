package course_project;

import java.util.List;
import java.util.Random;

public class PlayerAI {

    private int difficulty;
    private Coordinate previousShot;

    PlayerAI(int difficulty) {
        this.difficulty = difficulty;
    }

    public Coordinate move(Field foeField) {
        if (difficulty == 0) {
            return randomMove(foeField);
        } else if (difficulty == 1) {
            return normalMove(foeField);
        } else {
            return smartMove(foeField);
        }
    }

    public void changeDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    private Coordinate randomMove(Field foeField) {
        while (true) {
            Coordinate randomShot = randomCoordinate();
            Cell aim = foeField.getCell(randomShot);
            if (!aim.getState().equals(CellState.HIT) &&
                    !aim.getState().equals(CellState.MISS)) {
                return randomShot;
            }
        }
    }

    private Coordinate normalMove(Field foeField) {
        int r = 0;
        int c = 0;
        while(true) {
            Cell cell = foeField.getCell(r, c);
            CellState state = cell.getState();
            if (state.equals(CellState.HIT) && isNotDestroyed(foeField, cell)) {


            }
        }
    }

    private Coordinate randomCoordinate() {
        Random random = new Random(System.currentTimeMillis());
        return new Coordinate(random.nextInt(10), random.nextInt(10));
    }

    private boolean isNotDestroyed(Field foeField, Cell cell) {
        List<Cell> neighbourCells = foeField.getNeighbourCells(cell.getCoordinate());
        long emptyCells = neighbourCells.stream()
                .filter(c -> c.getState().equals(CellState.MISS))
                .count();
        if (emptyCells + cell.getCoordinate().bordersNear == 4) { //for one deck ships
            return true;
        }

        if (neighbourCells.stream().anyMatch(c -> c.getState().equals(CellState.HIT))) {

        }
        return true;
    }

    private Coordinate smartMove(Field foeField) {
        return new Coordinate(0,0);
    }
}
