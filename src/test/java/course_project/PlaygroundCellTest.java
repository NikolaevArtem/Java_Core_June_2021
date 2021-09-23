package course_project;

import course_project.sea_battle.playground.CellStatus;
import course_project.sea_battle.playground.Playground;
import course_project.sea_battle.playground.PlaygroundCell;
import course_project.sea_battle.ships.Ship;
import course_project.sea_battle.ships.ShipType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlaygroundCellTest {

    @Test
    void whenHitCell_thenStatusIsHit() {
        PlaygroundCell playgroundCell = new PlaygroundCell();
        playgroundCell.setShip(new Ship(ShipType.SUBMARINE, new Playground()));

        playgroundCell.setHit();

        assertSame(playgroundCell.getStatus(), CellStatus.HIT);
    }

    @Test
    void whenHitLastCellOfShip_thenStatusIsKilledBothCellAndShip() {
        PlaygroundCell playgroundCell = new PlaygroundCell();
        PlaygroundCell playgroundCell1 = new PlaygroundCell();
        PlaygroundCell playgroundCell2 = new PlaygroundCell();

        Ship ship = new Ship(ShipType.SUBMARINE, new Playground());
        playgroundCell.setShip(ship);
        playgroundCell1.setShip(ship);
        playgroundCell2.setShip(ship);

        playgroundCell.setHit();
        playgroundCell1.setHit();
        playgroundCell2.setHit();

        assertSame(playgroundCell2.getStatus(), CellStatus.KILLED);
        assertTrue(playgroundCell.getShip().isKilled());

    }
}
