package course_project;

import java.util.Random;

public class PlayerAI {

    private int difficulty;

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

    private Coordinate randomCoordinate() {
        Random random = new Random(System.currentTimeMillis());
        return new Coordinate(random.nextInt(10), random.nextInt(10));
    }
}
