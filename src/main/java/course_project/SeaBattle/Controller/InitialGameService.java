package course_project.SeaBattle.Controller;

import course_project.SeaBattle.Models.Player;
import course_project.SeaBattle.Models.Ship;
import course_project.SeaBattle.Models.Square;
import course_project.SeaBattle.Utility.ShipType;

import java.util.ArrayList;
import java.util.List;

import static course_project.SeaBattle.Controller.ShipService.setShipSquares;
import static course_project.SeaBattle.Utility.Input.*;

public class InitialGameService {


    public List<Player> getListPlayers() {

     return createPlayers(1);

    }

    private List<Player> createPlayers(int mod) {
        List<Player> playerList = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            Player player = new Player();
            System.out.println("playerName");
            player.setName(getPlayerName());
            playerList.add(player);
            System.out.println("ships arrange");
            arrangeShips(player);
        }

        return playerList;
    }

    private void arrangeShips(Player player) {
        List<Ship> shipList = createShipList();

        for (int s = 0; s < shipList.size() ; s++) {
            System.out.println("ships " + shipList.get(s).getShipType().toString());
            Square initialSquare = getSquare();
            int direction = getShipDirection();
            Ship ship = shipList.get(s);
            List<Square> shipSquares = ship.getShipSquares();
            shipSquares.add(initialSquare);
            setShipSquares(ship, direction);
            player.setShipList(shipList);
            System.out.println(player.getShipList().toString());
        }


    }

    private List<Ship> createShipList() {
        List<Ship> shipList = new ArrayList<>();

        shipList.add(new Ship(new ArrayList<>(), ShipType.BATTLESHIP));
//        shipList.add(new Ship(new ArrayList<>(), ShipType.CRUISER));
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
