package course_project.SeaBattle.service;

import course_project.SeaBattle.model.Player;
import course_project.SeaBattle.model.Ship;
import course_project.SeaBattle.model.Square;
import course_project.SeaBattle.model.SquareType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShipService {

    public static void processFire(Player enemy, Square square) {
        List<Ship> shipList = enemy.getShipList();
        for (Ship ship : shipList) {
            if (ship.getShipSquares().contains(square)) {
                ship.setShipHeal(ship.getShipHeal() - 1);
                DisplayService.showHitMsg(enemy.getEnemy());
            }
            if (ship.getShipHeal() == 0) {
                showBordersSquareWhenShipSank(ship);
            }
        }
    }

    public static boolean canArrangeShipOnGrid(List<Ship> shipList, Ship ship, Square initialSquare, int direction) {

        if (!isShipInsideTheGrid(ship, initialSquare, direction)) {
            return false;
        }
        return isSupposeSquareIntersect(shipList, ship, initialSquare, direction);
    }

    public static void setShipSquares(Ship ship, int direction) {

        List<Square> shipSquares = ship.getShipSquares();
        List<Square> shipBoardSquares = ship.getBoundedSquare();

        int initialX = shipSquares.get(0).getX();
        int initialY = shipSquares.get(0).getY();
        int shipSize = ship.getShipType().getSize();

        for (int i = 0; i < shipSize; i++) {
            if (direction == 1) {
                shipSquares.add(new Square(initialX, initialY + i, SquareType.SHIP));
                if (i == 0) {
                    shipBoardSquares.add(new Square(initialX, initialY - 1, SquareType.BOARD));
                    shipBoardSquares.add(new Square(initialX - 1, initialY - 1, SquareType.BOARD));
                    shipBoardSquares.add(new Square(initialX + 1, initialY - 1, SquareType.BOARD));
                }
                shipBoardSquares.add(new Square(initialX + 1, initialY + i, SquareType.BOARD));
                shipBoardSquares.add(new Square(initialX - 1, initialY + i, SquareType.BOARD));
                if (i == shipSize - 1) {
                    shipBoardSquares.add(new Square(initialX, initialY + i + 1, SquareType.BOARD));
                    shipBoardSquares.add(new Square(initialX - 1, initialY + i + 1, SquareType.BOARD));
                    shipBoardSquares.add(new Square(initialX + 1, initialY + i + 1, SquareType.BOARD));
                }
            } else {
                shipSquares.add(new Square(initialX + i, initialY, SquareType.SHIP));
                if (i == 0) {
                    shipBoardSquares.add(new Square(initialX - 1, initialY, SquareType.BOARD));
                    shipBoardSquares.add(new Square(initialX - 1, initialY - 1, SquareType.BOARD));
                    shipBoardSquares.add(new Square(initialX - 1, initialY + 1, SquareType.BOARD));
                }
                shipBoardSquares.add(new Square(initialX + i, initialY + 1, SquareType.BOARD));
                shipBoardSquares.add(new Square(initialX + i, initialY - 1, SquareType.BOARD));
                if (i == shipSize - 1) {
                    shipBoardSquares.add(new Square(initialX + i + 1, initialY, SquareType.BOARD));
                    shipBoardSquares.add(new Square(initialX + i + 1, initialY - 1, SquareType.BOARD));
                    shipBoardSquares.add(new Square(initialX + i + 1, initialY + 1, SquareType.BOARD));
                }
            }
        }

        List<Square> legalBoardSquare = ship.getBoundedSquare()
                .stream()
                .filter(ShipService::isLegalSquare)
                .collect(Collectors.toList());

        ship.setBoundedSquare(legalBoardSquare);
    }

    private static boolean isSupposeSquareIntersect(List<Ship> shipList,
                                                    Ship ship,
                                                    Square initialSquare,
                                                    int direction) {

        List<Square> tmpShipSquare = new ArrayList<>();
        tmpShipSquare.add(initialSquare);
        int initialX = initialSquare.getX();
        int initialY = initialSquare.getY();
        int shipSize = ship.getShipType().getSize();

        for (int i = 1; i < shipSize; i++) {
            if (direction == 1) {
                tmpShipSquare.add(new Square(initialX, initialY + i, SquareType.SHIP));
            } else {
                tmpShipSquare.add(new Square(initialX + i, initialY, SquareType.SHIP));
            }
        }

        List<Square> collect = shipList.stream()
                .map(Ship::getShipSquares)
                .flatMap(List::stream)
                .collect(Collectors.toList());
        List<Square> collect1 = shipList.stream()
                .map(Ship::getBoundedSquare)
                .flatMap(List::stream)
                .filter(ShipService::isLegalSquare)
                .collect(Collectors.toList());

        collect.addAll(collect1);

        for (Square square : tmpShipSquare) {
            if (collect.contains(square)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isShipInsideTheGrid(Ship ship, Square initialSquare, int direction) {
        int initialX = initialSquare.getX();
        int initialY = initialSquare.getY();
        int shipSize = ship.getShipType().getSize();

        if (direction == 0) {
            return initialX + shipSize - 1 <= 9;
        } else {
            return initialY + shipSize - 1 <= 9;
        }
    }

    private static boolean isLegalSquare(Square square) {
        int x = square.getX();
        int y = square.getY();
        return (0 <= x && x <= 9) && (0 <= y && y <= 9);
    }

    private static void showBordersSquareWhenShipSank(Ship ship) {
        for (Square square : ship.getBoundedSquare()) {
            square.setSquareStatus(SquareType.MISSED);
        }
    }
}
