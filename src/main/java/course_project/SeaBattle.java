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

    public void play() {
        printer.printGreeting();

        start();
        while (!shipsDestroyed(playerShips, compShips)) {
            makeMoves();
        }

        printer.printAskContinue();
        boolean exitGame = reader.getMode();
        if (exitGame) {
            printer.printGoodbye();
        }
        else {

            new SeaBattle().play();
        }
    }

    public void start() {
        printer.printAskHowFill();
        boolean auto = reader.getMode();
        if (!auto) {
            playerField = plPlacer.placeShips(reader);
        } else {
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
        printer.printHiddenField(computerField);
        printer.printSep();
        printer.printSep();
        printer.printSep();
        waitASecond();
    }

    private void makeMoves(
    ) {
        playerMove(computerField, computerShipsCoordinates);
        computerMove(playerField, playersShipsCoordinates);
    }

    public void playerMove(Field computerField, List<Coordinates> computerShipsCoordinates) {

        printer.playerMoves();
        System.out.println("And here is yours opponent Playing field :");
        printer.printHiddenField(computerField);

        printer.askWhereToShoot();
        Coordinates playerShoot = reader.readCoordinates();
        if (computerShipsCoordinates.contains(playerShoot)) {
            computerField.placeHit(playerShoot);
            for (Ship compShip : compShips
            ) {
                if (compShip.getCoordinates().contains(playerShoot)) {
                    compShip.gotShot();
                    printer.printYouHit();
                }
            }
            dealWithShips(compShips);
            playerMove(computerField, computerShipsCoordinates);      //one more turn after hit
        } else {
            computerField.placeMiss(playerShoot);
            printer.printYouMiss();
            printer.printSep();
        }

    }

    private void computerMove(Field playerField, List<Coordinates> playersShipsCoordinates) {
        printer.compMoves();
        waitASecond();
        System.out.println("Here is yours Playing field :");
        printer.printOpenField(playerField);

        Coordinates compShoot = getCompShot();

        if (!allCompShoots.contains(compShoot)) {        //not to shot same coordinate again
            allCompShoots.add(compShoot);
        } else {
            compShoot = getCompShot();
        }
        printer.printShoot();
        System.out.println((char) (compShoot.getX() + 65) + "" + (compShoot.getY() + 1));
        if (playersShipsCoordinates.contains(compShoot)) {

            playerField.placeHit(compShoot);
            for (Ship plShip : playerShips
            ) {
                if (plShip.getCoordinates().contains(compShoot)) {
                    plShip.gotShot();
                    printer.printYouWasHit();
                    waitASecond();

                }
            }
            dealWithShips(playerShips);
            waitASecond();
            computerMove(playerField, playersShipsCoordinates);         //one more turn after hit
        } else {
            playerField.placeMiss(compShoot);
            printer.printPCMiss();
            printer.printSep();
            waitASecond();
        }
    }

    private void waitASecond() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void dealWithShips(List<Ship> ships) {
        Ship destroyed = null;
        for (Ship ship : ships
        ) {
            if (!ship.isAlive()) {
                destroyed = ship;
            }
        }
        if (destroyed != null) {
            printer.printDestroyed(destroyed);
            ships.remove(destroyed);
        }

    }

    private boolean shipsDestroyed(List<Ship> playerShips, List<Ship> compShips) {
        if (playerShips.isEmpty()) {
            printer.printLose();
            return true;
        }
        if (compShips.isEmpty()) {
            printer.printWin();
            return true;
        }
        return false;
    }

    private Coordinates getCompShot() {
        int x = random.nextInt(10);
        int y = random.nextInt(10);
        return new Coordinates(x, y);
    }

}
