/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course_project.service;


import course_project.models.Cell;
import course_project.models.Ship;

public class Strike {
    private Ship ship;

    public Strike(Ship ship) {
        this.ship = ship;
    }

    public String getStrike(Cell strikedCell) {
        for (Cell cell : ship.getShipCells()) {
            if (cell.equals(strikedCell)) {
                if (cell.isBeaten()) {
                    return "It was already beaten";
                }
                cell.setBeaten(true);
                if (shipDown()) {
                    return "Ship is sunked!";
                }

                return "Bingo!";
            }
        }
        return "Miss!";
    }
    
    private boolean shipDown() {
        for (Cell cell : ship.getShipCells()) {
            if (cell.isBeaten() == false) {
                return false;
            }
        }
        return true;
    }
}
