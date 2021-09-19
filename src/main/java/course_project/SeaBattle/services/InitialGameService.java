package course_project.SeaBattle.services;

import course_project.SeaBattle.models.Player;
import course_project.SeaBattle.models.Ship;
import course_project.SeaBattle.models.Square;
import course_project.SeaBattle.utility.Computer;
import course_project.SeaBattle.utility.Input;
import course_project.SeaBattle.utility.ShipType;

import java.util.ArrayList;
import java.util.List;

public class InitialGameService {

    private static List<Player> playerList = new ArrayList<>();

    public static void createGame() {
        int mod = Input.getMod();

        if (mod == 1) {
            createPlayer();
            createPlayer();
        }
        if (mod == 0) {
            createPlayer();
            createComputer();
        }
        PlayerService.setEnemyPlayers(playerList);
        PlayerService.setMod(mod);
    }

    private static void createComputer() {
        Player computer = new Computer(); // v1.0
        computer.setName("Computer Jerry");
        computer.setComputer(true);
        GridService.createGrid(computer);
        playerList.add(computer);
        arrangeAutomaticallyShips(computer);
        PlayerService.setRemainingAliveSquares(computer);
    }

    private static void createPlayer() {
        Player player = new Player();

        DisplayService.showEnterNameScreen();
        player.setName(Input.getPlayerName());

        GridService.createGrid(player);
        playerList.add(player);

        DisplayService.showChooseShipArrangeModScreen();
        int automaticallyArrange = Input.getMod();
        if (automaticallyArrange == 1) {
            arrangeManuallyShips(player);
        } else {
            arrangeAutomaticallyShips(player);
        }
        PlayerService.setRemainingAliveSquares(player);
    }

    private static void arrangeAutomaticallyShips(Player player) {

        List<Ship> shipList = createShipListByRule();
        player.setShipList(shipList);

        for (int s = 0; s < shipList.size(); s++) {
            Ship ship = shipList.get(s);
            List<Square> shipSquares = ship.getShipSquares();
            Square initialSquare = Computer.giveSquare();
            int direction = Computer.giveDirection();

            while (ShipService.canArrangeShipOnGrid(shipList, ship, initialSquare, direction)) {
                initialSquare = Computer.giveSquare();
                direction = Computer.giveDirection();
            }

            shipSquares.add(initialSquare);
            ShipService.setShipSquares(ship, direction);
            GridService.addShipsToGrid(player.getGrid(), shipList);
        }
    }


    private static void arrangeManuallyShips(Player player) {
        List<Ship> shipList = createShipListByRule();
        player.setShipList(shipList);

        for (int s = 0; s < shipList.size(); s++) {

            Ship ship = shipList.get(s);
            List<Square> shipSquares = ship.getShipSquares();
            DisplayService.showPrepareBattleScreen(player);

            DisplayService.showPrepareShipMessage(ship);
            Square initialSquare = Input.getSquare();

            DisplayService.getShipDirection();
            int direction = Input.getShipDirection();

            while (ShipService.canArrangeShipOnGrid(shipList, ship, initialSquare, direction)) {
                DisplayService.errorArrangeShip();

                initialSquare = Input.getSquare();
                direction = Input.getShipDirection();
            }

            shipSquares.add(initialSquare);
            ShipService.setShipSquares(ship, direction);
            GridService.addShipsToGrid(player.getGrid(), shipList);
        }
        DisplayService.showPrepareBattleScreen(player);
    }

    private static List<Ship> createShipListByRule() { // blank for creating a list of ships according to different rules
        List<Ship> shipList = new ArrayList<>();

        shipList.add(new Ship(new ArrayList<>(), ShipType.BATTLESHIP));
        shipList.add(new Ship(new ArrayList<>(), ShipType.CRUISER));
        shipList.add(new Ship(new ArrayList<>(), ShipType.CRUISER));
        shipList.add(new Ship(new ArrayList<>(), ShipType.DESTROYER));
        shipList.add(new Ship(new ArrayList<>(), ShipType.DESTROYER));
        shipList.add(new Ship(new ArrayList<>(), ShipType.DESTROYER));
        shipList.add(new Ship(new ArrayList<>(), ShipType.BOAT));
        shipList.add(new Ship(new ArrayList<>(), ShipType.BOAT));
        shipList.add(new Ship(new ArrayList<>(), ShipType.BOAT));
        shipList.add(new Ship(new ArrayList<>(), ShipType.BOAT));

        return shipList;
    }
}
