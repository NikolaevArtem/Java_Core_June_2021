package course_project.Utils.GameHandler;

import course_project.Utils.ConsoleHandling.InReader;
import course_project.Utils.ConsoleHandling.Printer;
import course_project.Utils.ShipPlacers.ComputerShipPlacer;
import course_project.Utils.ShipPlacers.PlayerShipPlacer;
import course_project.components.Field;

public class Handler {
    private Field playerField = new Field();
    private Field computerField = new Field();
    private final Printer printer = new Printer();
    ComputerShipPlacer cPlacer = new ComputerShipPlacer();
    PlayerShipPlacer plPacer = new PlayerShipPlacer();
    InReader reader = new InReader();

    public void start() {
        printer.printAskHowFill();
        boolean auto = reader.getMode();
        if(!auto){
           playerField = plPacer.placeShips(reader);
        }  else {
            playerField = cPlacer.placeShips();         //places Ship with ComputerShipPlacer automatically
        }
        computerField = plPacer.placeShips();
        printer.printYouField(playerField);
        printer.printEnemyField(computerField);
    }

    public void makeMoves() {

    }

    public boolean endOfGame() {
    return false;
    }
}
