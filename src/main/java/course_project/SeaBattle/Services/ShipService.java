package course_project.SeaBattle.Services;

import course_project.SeaBattle.Models.Ship;
import course_project.SeaBattle.Models.Square;
import course_project.SeaBattle.Utility.SquareStatus;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ShipService {

    public static void setShipSquares(Ship ship, int direction) {

        List<Square> shipSquares = ship.getShipSquares();
        List<Square> shipBoardSquares = ship.getBoundedSquare();

        int initialX = shipSquares.get(0).getX();
        int initialY = shipSquares.get(0).getY();
        int shipSize = ship.getShipType().getSize();

        for (int i = 0; i < shipSize; i++) {
            if (direction == 1) {
                shipSquares.add(new Square(initialX, initialY + i, SquareStatus.SHIP));
                shipBoardSquares.add(new Square(initialX + 1, initialY + i, SquareStatus.BOARD));
                shipBoardSquares.add(new Square(initialX - 1, initialY + i, SquareStatus.BOARD));
            } else {
                shipSquares.add(new Square(initialX + i, initialY, SquareStatus.SHIP));
                shipBoardSquares.add(new Square(initialX + i, initialY + 1, SquareStatus.BOARD));
                shipBoardSquares.add(new Square(initialX + i, initialY - i, SquareStatus.BOARD));
            }
        }


    }


    private static boolean isLegalSquare(Square square) {
        int x = square.getX();
        int y = square.getY();
        return (0 <= x && x <= 9) && (0 <= y && y <= 9);
    }

    public static boolean canArrangeShipOnGrid(List<Ship> shipList, Ship ship, Square initialSquare, int direction) {
        int shipSize = ship.getShipType().getSize();
        int initialX = initialSquare.getX();
        int initialY = initialSquare.getY();

        if (direction == 0) {
            if (initialX + shipSize - 1 > 9) {
                return false;
            }
        } else {
            if (initialY + shipSize - 1 > 9) {
                return false;
            }
        }

        List<Square> tmpShipSquare = new ArrayList<>();
        tmpShipSquare.add(initialSquare);

        for (int i = 1; i < ship.getShipType().getSize(); i++) {
            if (direction == 1) {
                tmpShipSquare.add(new Square(initialX, initialY + i, SquareStatus.SHIP));
            } else {
                tmpShipSquare.add(new Square(initialX + i, initialY, SquareStatus.SHIP));
            }
        }

        List<Square> collect = shipList.stream()
                .map(Ship::getShipSquares)
                .flatMap(List::stream)
                .collect(Collectors.toList());

        List<Square> collect1 = shipList.stream()
                .map(Ship::getBoundedSquare)
                .flatMap(List::stream)
                .filter(square -> isLegalSquare(square))
                .collect(Collectors.toList());

        collect.addAll(collect1);
        Set<Square> collect2 = new HashSet<>(collect);



        for (Square square : tmpShipSquare) {
            if (collect.contains(square)) {
                return false;
            }
        }
        return true;
    }

}
