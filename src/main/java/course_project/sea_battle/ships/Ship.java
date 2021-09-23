package course_project.sea_battle.ships;

import course_project.sea_battle.playground.CellData;
import course_project.sea_battle.playground.CellStatus;
import course_project.sea_battle.playground.Playground;
import lombok.Getter;

import java.util.ArrayList;

@Getter
public class Ship {
    private ShipType shipType;
    private boolean isKilled;
    private int length;
    private int hitCells;
    private ArrayList<CellData> cells;
    private Playground playground;

    public Ship(ShipType shipType, Playground playground) {
        this.shipType = shipType;
        this.isKilled = false;
        this.length = shipType.getLength();
        this.hitCells = 0;
        cells = new ArrayList<>(length);
        this.playground = playground;
    }

    public void hit() {
        hitCells++;
        if (hitCells == length) {
            kill();
        }
    }

    public void setCell(CellData cellData) {
        cells.add(cellData);
    }

    private void kill() {
        isKilled = true;
        cells.forEach(cellData -> playground.getCell(cellData).setStatus(CellStatus.KILLED));
        playground.killShip();
    }
}
