package course_project.SeaBattle.Models;

import course_project.SeaBattle.Utility.ShipType;

import java.util.List;

public class Ship {

    private List<Square> shipSquares;
    private ShipType shipType;

    public Ship(List<Square> squares, ShipType shipType) {
        this.shipSquares = squares;
        this.shipType = shipType;
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


}
