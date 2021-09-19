/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course_project.service;
import course_project.SeaBattle;
import course_project.models.Cell;
import course_project.models.Ship;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShipCreator {

    private final List<Cell> inaccessibleCells = new ArrayList<>();
    private final List<Cell> shipCells = new ArrayList<>();
    private final Random random = new Random();

    public Ship createShip(int shipLength) {

        Ship ship= new Ship(shipLength);
        boolean added;
        do {
            Cell cell = new Cell();
            do {
                cell.setDigit(getNextNumber());
                cell.setLetter(getNextChar());

            } while(!ship.checkIfEligible(cell) || inaccessibleCells.contains(cell));

            added = ship.addCell(cell);
            if (added) {
                inaccessibleCells.add(cell);
                shipCells.add(cell);
            }
        } while(added);

        for (Cell shipCell : ship.getShipCells()) {
            int digit = shipCell.getDigit();
            int letter = shipCell.getLetter();

            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    Cell tempCell = new Cell((char) (letter+i), digit + j);
                    if (!shipCells.contains(tempCell)) {
                        inaccessibleCells.add(tempCell);
                    }
                }
            }
        }

        return ship;
    }

    private int getNextNumber() {
        return random.nextInt(SeaBattle.FIELD_SIZE);
   }
    
    private char getNextChar() {
        return (char)(random.nextInt(SeaBattle.FIELD_SIZE) + 'a');
    }    
}
