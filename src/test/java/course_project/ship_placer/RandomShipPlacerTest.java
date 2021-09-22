package course_project.ship_placer;

import base.UnitBase;
import course_project.enums.ShipKind;
import course_project.input_readers.ConsoleInputReader;
import course_project.players.Human;
import course_project.players.Player;
import course_project.ship_placers.RandomShipPlacer;
import course_project.field_components.Ship;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RandomShipPlacerTest extends UnitBase {

    @Test
    void givenNewRandomPlacer_whenPlaceShips_thenShipPlaced() {
        Player player = new Human(new ConsoleInputReader());
        new RandomShipPlacer(player).placeShips();
        List<Ship> allShips = player.getPlayerShips();
        List<Ship> oneDeck = collectShips(allShips, ShipKind.ONE_DECK_SHIP);
        List<Ship> twoDeck = collectShips(allShips, ShipKind.TWO_DECK_SHIP);
        List<Ship> threeDeck = collectShips(allShips, ShipKind.THREE_DECK_SHIP);
        List<Ship> fourDeck = collectShips(allShips, ShipKind.FOUR_DECK_SHIP);
        assertEquals(10, allShips.size());
        assertEquals(4, oneDeck.size());
        assertEquals(3, twoDeck.size());
        assertEquals(2, threeDeck.size());
        assertEquals(1, fourDeck.size());
    }

    private List<Ship> collectShips(List<Ship> playerShips, ShipKind kind) {
        return playerShips
                .stream()
                .filter(s -> s.getCells().size() == kind.getLength())
                .collect(Collectors.toList());
    }


}
