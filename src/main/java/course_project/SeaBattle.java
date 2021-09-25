package course_project;

import course_project.Utils.ConsoleHandling.InReader;
import course_project.Utils.ConsoleHandling.Printer;
import course_project.Utils.ShipPlacers.ComputerShipPlacer;
import course_project.Utils.ShipPlacers.PlayerShipPlacer;
import course_project.components.Coordinates;
import course_project.components.Field;
import course_project.components.Ship;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SeaBattle {
    final Printer printer = new Printer();
    private final Random random = new Random();
    private final ComputerShipPlacer cPlacer = new ComputerShipPlacer();
    private final PlayerShipPlacer plPlacer = new PlayerShipPlacer();
    private Field playerField = new Field();
    private Field computerField = new Field();
    private List<Ship> playerShips;
    private List<Ship> compShips;
    private List<Coordinates> playersShipsCoordinates;
    private List<Coordinates> computerShipsCoordinates;
    private final InReader reader = new InReader();
    private final List<Coordinates> allCompShoots = new ArrayList<>();

    public void play(){
        printer.printGreeting();

        start();
        while (!shipsDestroyed(playerShips, compShips)) {
            makeMoves();
        }

        printer.printGoodbye();
    }

    public void start() {
        printer.printAskHowFill();
        boolean auto = reader.getMode();
        if(!auto){
            playerField = plPlacer.placeShips(reader);
        }  else {
            playerField = plPlacer.placeShips(); //this line does place Ships with ComputerShipPlacer automatically
        }

        computerField = cPlacer.placeShips();

        //Coordinates and ships fields initialization after placing
        playerShips = plPlacer.getAllShips();
        compShips = cPlacer.getAllShips();
        playersShipsCoordinates = plPlacer.getAllShipsCoordinates();
        computerShipsCoordinates = cPlacer.getAllShipsCoordinates();

        System.out.println("Here is yours Playing field :");
        printer.printOpenField(playerField);
        System.out.println("And here is yours opponent Playing field :");
        printer.printOpenField(computerField);
    }

    private void makeMoves(
    ) {
            playerMove(computerField, computerShipsCoordinates);
            dealWithShips(compShips);
        System.out.println("And here is yours opponent Playing field :");
        printer.printOpenField(computerField);
        System.out.println(compShips.size());

        computerMove(playerField, playersShipsCoordinates);
        dealWithShips(playerShips);
        System.out.println("Here is yours Playing field :");
            printer.printOpenField(playerField);
        System.out.println(playerShips.size());


    }

    public void playerMove(Field computerField, List<Coordinates> computerShipsCoordinates) {
        printer.playerMoves();
        printer.askWhereToShoot();
        Coordinates playerShoot = reader.readCoordinates();
        if (computerShipsCoordinates.contains(playerShoot)){
            computerField.placeHit(playerShoot);
            for (Ship compShip : compShips
            ) {
                if (compShip.getCoordinates().contains(playerShoot)) {
                    compShip.gotShot();
                }
            }
        } else {
            computerField.placeMiss(playerShoot);
        }
    }

    private void computerMove(Field playerField, List<Coordinates> playersShipsCoordinates) {
        printer.compMoves();

        Coordinates compShoot = getCompShot();

        if (!allCompShoots.contains(compShoot)){        //not to shot same coordinate again
            allCompShoots.add(compShoot);
        } else {
            compShoot = getCompShot();
        }
        System.out.println((char)(compShoot.getX() + 65) + "" + (compShoot.getY() + 1));
        if (playersShipsCoordinates.contains(compShoot)){

            playerField.placeHit(compShoot);
            for (Ship plShip : playerShips
            ) {
                if (plShip.getCoordinates().contains(compShoot)){   // todo pull out ship by coordinates
                    plShip.gotShot();                               //todo next shot logic
                }
            }
        } else {
            playerField.placeMiss(compShoot);
        }
    }

    private void dealWithShips(List<Ship> ships) {
        ships.removeIf(ship -> !ship.isAlive());
        for (Ship s:ships
             ) {
            System.out.print(s.getHealth() + " ");
        }
    }

    private boolean shipsDestroyed(List<Ship> playerShips, List<Ship> compShips) {
        if (playerShips.isEmpty()){
            printer.printLose();
            return true;
        }
        if (compShips.isEmpty()){
            printer.printWin();
            return true;
        }
        return false;
    }

    private Coordinates getCompShot (){
        int x = random.nextInt(10);
        int y = random.nextInt(10);
        return new Coordinates(x,y);
    }

}
