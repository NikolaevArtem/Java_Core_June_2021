/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course_project.service;


import course_project.models.Cell;
import course_project.models.Ship;

import java.util.ArrayList;
import java.util.List;

public class Strike {
    private final List<Cell> strikes = new ArrayList<>();

    public List<Cell> getStrikes() {
        return strikes;
    }

    boolean makeStrike(int y, char x, List<Ship> ships) {

        String strStrike = "Miss";
        Cell tmpUserCell = new Cell();
        tmpUserCell.setDigit(y);
        tmpUserCell.setLetter(x);

        if (!strikes.contains(tmpUserCell)) {
            for (Ship ship : ships) {
                if (ship.getShipCells().contains(tmpUserCell)) {
                    strStrike = makeCellStrike(ship, tmpUserCell);
                    break;
                }
            }

            System.out.println(strStrike);
            strikes.add(tmpUserCell);
            return true;
        } else {
            System.out.println("You have already striked this cell.");
            return false;
        }
    }

    public String makeCellStrike(Ship ship, Cell strikedCell) {

        for (Cell cell : ship.getShipCells()) {
            if (cell.equals(strikedCell)) {
                if (cell.isBeaten()) {
                    return "It was already beaten";
                }
                cell.setBeaten(true);
                if (shipDown(ship)) {
                    return "Ship is sunked!";
                }

                return "Bingo!";
            }
        }
        return "Miss!";
    }

    private boolean shipDown(Ship ship) {
        for (Cell cell : ship.getShipCells()) {
            if (cell.isBeaten() == false) {
                return false;
            }
        }
        return true;
    }
}
