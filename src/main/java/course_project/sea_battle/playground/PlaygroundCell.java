package course_project.sea_battle.playground;

import course_project.sea_battle.ships.Ship;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PlaygroundCell {
    private boolean isOccupied;
    private boolean isHit;
    private boolean isMissed;

    private Ship ship;

    public PlaygroundCell() {
        this.isOccupied = false;
        this.isHit = false;
        this.isMissed = false;
        this.ship = null;
    }
}
