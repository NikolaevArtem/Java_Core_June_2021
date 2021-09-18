package course_project.SeaBattle.Services;

import course_project.SeaBattle.Models.Player;
import course_project.SeaBattle.Models.Ship;
import course_project.SeaBattle.Models.Square;
import course_project.SeaBattle.Utility.ShipType;

import java.util.ArrayList;
import java.util.List;


import static course_project.SeaBattle.Services.GridService.addShipsToGrid;
import static course_project.SeaBattle.Services.GridService.createGrid;
import static course_project.SeaBattle.Services.PlayerService.setPlayers;
import static course_project.SeaBattle.Services.ShipService.*;
import static course_project.SeaBattle.Utility.Input.*;

public class InitialGameService {


    public static void createPlayers(int mod) {
        List<Player> playerList = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            Player player = new Player();
            System.out.println("playerName");
            player.setName(getPlayerName());
            createGrid(player);
            playerList.add(player);
            arrangeShips(player);
            PlayerService.setRemainingAliveSquares(player);
        }
        setPlayers(playerList);

    }


    private static void arrangeShips(Player player) {
        List<Ship> shipList = createShipListByRule();
        player.setShipList(shipList);

        for (int s = 0; s < shipList.size() ; s++) {
            DisplayService.prepareDisplay(player);
            System.out.println("ships " + shipList.get(s).getShipType().toString());

            Square initialSquare = getSquare();
            int direction = getShipDirection();

            Ship ship = shipList.get(s);
            List<Square> shipSquares = ship.getShipSquares();

            while (!canArrangeShipOnGrid(shipList, ship, initialSquare, direction)) {
                System.out.println("dont arrange");
                initialSquare = getSquare();
                direction = getShipDirection();
            }

            shipSquares.add(initialSquare);
            setShipSquares(ship, direction);
            addShipsToGrid(player.getGrid(), shipList);

        }
        DisplayService.prepareDisplay(player);

    }

    private static List<Ship> createShipListByRule() {
        List<Ship> shipList = new ArrayList<>();

        shipList.add(new Ship(new ArrayList<>(), ShipType.BATTLESHIP));
        shipList.add(new Ship(new ArrayList<>(), ShipType.CRUISER));
//        shipList.add(new Ship(new ArrayList<>(), ShipType.CRUISER));
//        shipList.add(new Ship(new ArrayList<>(), ShipType.DESTROYER));
//        shipList.add(new Ship(new ArrayList<>(), ShipType.DESTROYER));
//        shipList.add(new Ship(new ArrayList<>(), ShipType.DESTROYER));
//        shipList.add(new Ship(new ArrayList<>(), ShipType.BOAT));
//        shipList.add(new Ship(new ArrayList<>(), ShipType.BOAT));
//        shipList.add(new Ship(new ArrayList<>(), ShipType.BOAT));
//        shipList.add(new Ship(new ArrayList<>(), ShipType.BOAT));

        return shipList;
    }



}
