package course_project.SeaBattle.models;

import course_project.SeaBattle.utility.ShipType;

import java.util.ArrayList;
import java.util.List;

public class Ship {

    private final List<Square> shipSquares;
    private List<Square> boundedSquare;
    private final ShipType shipType;
    private int shipHeal;

    public Ship(List<Square> squares, ShipType shipType) {
        this.shipSquares = squares;
        this.shipType = shipType;
        this.shipHeal = shipType.getSize();
        this.boundedSquare = new ArrayList<>();
    }

    public List<Square> getShipSquares() {
        return shipSquares;
    }

    public ShipType getShipType() {
        return shipType;
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
