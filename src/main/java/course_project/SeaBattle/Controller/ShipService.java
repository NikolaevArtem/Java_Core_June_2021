package course_project.SeaBattle.Controller;

import course_project.SeaBattle.Models.Ship;
import course_project.SeaBattle.Models.Square;
import course_project.SeaBattle.Utility.SquareStatus;

import java.util.List;

public class ShipService {

    public static void setShipSquares(Ship ship, int direction) {

        List<Square> shipSquares = ship.getShipSquares();

        int initialX = shipSquares.get(0).getX();
        int initialY = shipSquares.get(0).getY();

        for (int i = 1; i < ship.getShipType().getSize(); i++) {
            if (direction == 1){
                shipSquares.add(new Square(initialX, initialY + i, SquareStatus.SHIP));
            }
            else {
                shipSquares.add(new Square(initialX + i, initialY, SquareStatus.SHIP));
            }
        }
    }

}
