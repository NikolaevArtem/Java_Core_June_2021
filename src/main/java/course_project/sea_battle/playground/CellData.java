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

    public CellData generateCellData() {
        return new CellData((char) (getRandomPosition() + 65), getRandomPosition() + 1);
    }

    private int getRandomPosition() {
        return RandomGenerator.getRandomInRange(Playground.getFieldSize() - 1, 0);
    }
}
