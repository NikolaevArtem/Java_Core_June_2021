package course_project.battleship.utils;

import course_project.battleship.model.Ship;
import course_project.battleship.player.Player;

import java.util.Random;

public class RandomShipPlacement implements ShipPlacement {
    private final Random random = new Random();

    @Override
    public void placeShips(Player player) {
        int deck = 4;
        int counter = 1;
        for (int i = 1; i <= 4; i++) {
            while (counter <= i) {
                int x = random.nextInt(10);
                int y = random.nextInt(10);
                Coordinate coordinate = new Coordinate(x, y);

                int direction = random.nextInt(2) + 1;

                if (!Validator.isAvailable(coordinate, deck, direction, player.getBattlefield())) {
                    continue;
                }

                Ship ship = new Ship(deck);
                player.placeShip(coordinate, ship, direction);

                counter++;
            }
            deck--;
            counter = 1;
        }
    }
}
