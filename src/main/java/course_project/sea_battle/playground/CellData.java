package course_project.sea_battle.playground;

import course_project.sea_battle.utils.RandomGenerator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CellData {
    private char line;
    private int col;
    private int row;

    public CellData(char line, int col) {
        this.line = line;
        this.col = col;
        this.row = line - 65;
    }

    public CellData(int row, int col) {
        this.row = row - 1;
        this.col = col;
        this.line = (char) (row + 65 - 1);
    }

    public static CellData generateCellData() {
        return new CellData((char) (getRandomPosition() + 65), getRandomPosition() + 1);
    }

    private static int getRandomPosition() {
        return RandomGenerator.getRandomInRange(Playground.getFieldSize() - 1, 0);
    }

    @Override
    public String toString() {
        return line + "-" + col;
    }
}
