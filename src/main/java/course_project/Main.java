package course_project;

import course_project.Utils.ConsoleHandling.Printer;
import course_project.Utils.ShipPlacers.ComputerShipPlacer;
import course_project.components.Coordinates;
import course_project.components.Field;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        Printer printer = new Printer();
//        ComputerShipPlacer placer = new ComputerShipPlacer();
//        Field testField = placer.placeShips();
//        printer.printYouField(testField);
//        List<Coordinates> coords;
//        coords = placer.getAllShipsCoordinates();
//        System.out.println(coords);
//
//        while (true){
//            new SeaBattle().playerMove(testField, coords);
//            printer.printYouField(testField);
//        }



       new SeaBattle().play();
    }







}
