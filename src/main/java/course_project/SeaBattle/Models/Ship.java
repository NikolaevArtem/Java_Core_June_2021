package course_project.SeaBattle.Models;

import course_project.SeaBattle.Utility.ShipType;

import java.util.ArrayList;
import java.util.List;

public class Ship {

    private List<Square> shipSquares;
    private List<Square> boundedSquare = new ArrayList<>();
    private ShipType shipType;
    private int shipHeal;

    public Ship(List<Square> squares, ShipType shipType) {
        this.shipSquares = squares;
        this.shipType = shipType;
        this.shipHeal = shipType.getSize();
    }

    public List<Square> getShipSquares() {
        return shipSquares;
    }

    public void setShipSquares(List<Square> shipSquares) {
        this.shipSquares = shipSquares;
    }

    public ShipType getShipType() {
        return shipType;
    }

    public void setShipType(ShipType shipType) {
        this.shipType = shipType;
    }

    public List<Square> getBoundedSquare() {
        return boundedSquare;
    }

    public void setBoundedSquare(List<Square> boundedSquare) {
        this.boundedSquare = boundedSquare;
    }

    public int getShipHeal() {
        return shipHeal;
    }

    public void setShipHeal(int shipHeal) {
        this.shipHeal = shipHeal;
    }
}
