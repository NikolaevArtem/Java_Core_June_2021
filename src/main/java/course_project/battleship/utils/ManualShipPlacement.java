package course_project.battleship.utils;

import course_project.battleship.model.Ship;
import course_project.battleship.player.Player;

public class ManualShipPlacement implements ShipPlacement {

    @Override
    public void placeShips(Player player) {
        int deck = 4;
        int counter = 1;
        for (int i = 1; i <= 4; i++) {
            while (counter <= i) {
                System.out.println(player.getName() + ", place your " + deck + "-deck ship on the field:");
                Display.drawField(player.getBattlefield());

                Coordinate coordinate = Menu.createCoordinate();
                if (coordinate == null || !Validator.isValidCoordinate(coordinate)) {
                    System.out.println("\nEntered Invalid coordinate!\n");
                    continue;
                }

                int direction = Menu.createDirection();
                if (!Validator.isValidDirection(direction)) {
                    System.out.println("\nEntered Invalid value for direction!\n");
                    continue;
                }

                if (!Validator.isAvailable(coordinate, deck, direction, player.getBattlefield())) {
                    System.out.println("Wrong coordinates or direction!");
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
