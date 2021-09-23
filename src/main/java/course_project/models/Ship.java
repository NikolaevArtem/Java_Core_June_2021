/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course_project.models;

import java.util.ArrayList;
import java.util.List;

public class Ship {
    private final List<Cell> shipCells = new ArrayList<>();
    private final int shipLength;

    public Ship(int shipLength) {
        this.shipLength = shipLength;
    }

    public List<Cell> getShipCells() {
        return shipCells;
    }

    public boolean checkIfEligible(Cell cell) {
        if (shipCells.isEmpty()) {
            return true;
        }

        if (shipCells.contains(cell)) {
            return false;
        }

        for (Cell shipCell : shipCells) {
            if (checkCell(cell, shipCell)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkCell(Cell cell, Cell shipCell) {

        return (shipCell.getDigit() == cell.getDigit()
                && Math.abs((int) shipCell.getLetter() - (int) cell.getLetter()) == 1)
                || (shipCell.getLetter() == cell.getLetter()
                && Math.abs(shipCell.getDigit() - cell.getDigit()) == 1);
    }

    public boolean addCell(Cell cell) {
        if (shipCells.size() == shipLength) {
            return false;
        }
        return shipCells.add(cell);
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        for (Cell shipCell : shipCells) {
            builder.append(shipCell.isBeaten() ? "\u001B[31m" : "")
                    .append('[')
                    .append(shipCell.getDigit())
                    .append(shipCell.getLetter())
                    .append(']')
                    .append(shipCell.isBeaten() ? "\u001B[0m" : "")
                    .append(',');
        }
        return '{' + builder.toString().substring(0, builder.toString().length() -1)  + '}';

    }


}
