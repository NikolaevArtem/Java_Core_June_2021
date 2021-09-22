package course_project;

import course_project.models.Player;
import course_project.models.Ship;
import course_project.engine.ShipPlacer;
import course_project.engine.Shooter;

import java.io.IOException;
import java.util.ArrayList;

public class Battle {

    public static void run() throws IOException {
        Player player1 = new Player();
        Player player2 = new Player();

        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);

        Player currentPlayer;
        for (Player player : players) { // preparing both players battlefields
            currentPlayer = player;

            System.out.println("\n \n" + currentPlayer.name() + ", welcome to the Sea Battle. \n \n" +
                    "It`s time to place your ships. Remember the main rule: ships must not touch each other.\n" + "To place a ship you basically need to type coordinate and then choose mode. \n" +
                    "There are two ways to place your ships from starting coordinate: from left to right (key \"h\") & from up to down (key \"v\")\n" +
                    "If there is only one possible way, it will be chosen automatically, if it`s impossible to place ship from this coordinate, you will have to choose another one.\n");

            System.out.println("Let`s begin with Carrier - huge battleship with size 4. \n");
            ShipPlacer.placement(new Ship("Carrier", 4), currentPlayer);

            System.out.println("Now place 2 Cruisers of size 3");
            for (int i = 0; i < 2; i++) {
                ShipPlacer.placement(new Ship("Cruiser", 3), currentPlayer);
            }
            System.out.println("Now place 3 Destroyers of size 2");
            for (int i = 0; i < 3; i++) {
                ShipPlacer.placement(new Ship("Destroyer", 2), currentPlayer);
            }
            System.out.println("And finally place 4 Scout ships of size 1");
            for (int i = 0; i < 4; i++) {
                ShipPlacer.placement(new Ship("Scout", 1), currentPlayer);
            }

        }

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");

        while (player1.hp() > 0 && player2.hp() > 0) {
            Shooter.Shoot(player1, player2);
            if (player2.hp() == 0) {
                break;
            }
            Shooter.Shoot(player2, player1);
        }
    }
}
