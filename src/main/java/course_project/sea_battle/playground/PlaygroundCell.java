package course_project.sea_battle.playground;

import course_project.sea_battle.ships.Ship;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlaygroundCell {
    private CellStatus status;

    private Ship ship;

    public void setHit() {
        if (status == CellStatus.HIT) {
            return;
        }
        setStatus(CellStatus.HIT);
        ship.hit();
        if (ship.isKilled()) {
            status = CellStatus.KILLED;
        }
    }

    public PlaygroundCell() {
        status = CellStatus.FREE;

        this.ship = null;
    }
}
