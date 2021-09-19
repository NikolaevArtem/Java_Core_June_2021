package course_project.SeaBattle.service;

import course_project.SeaBattle.model.Grid;
import course_project.SeaBattle.model.Player;
import course_project.SeaBattle.model.Ship;
import course_project.SeaBattle.model.Square;
import course_project.SeaBattle.model.SquareType;

import java.util.List;

public class GridService {

    public static void createGrid(Player player) {
        Grid grid = new Grid();
        Square[][] squares = new Square[10][10];
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                squares[y][x] = new Square(x, y, SquareType.OCEAN);
            }
        }
        grid.setSquares(squares);
        player.setGrid(grid);

    }

    public static void addShipsToGrid(Grid grid, List<Ship> shipList) {
        for (Ship ship : shipList) {
            for (Square square : ship.getShipSquares()) {
                int x = square.getX();
                int y = square.getY();
                grid.setSquare(x, y, square);
            }
            for (Square square : ship.getBoundedSquare()) {

                int x = square.getX();
                int y = square.getY();
                if (square.getSquareStatus().equals(grid.getSquare(x, y).getSquareStatus())) {
                    int index = ship.getBoundedSquare().indexOf(square);
                    ship.getBoundedSquare().set(index, grid.getSquare(x, y));
                } else
                    grid.setSquare(x, y, square);
            }
        }

    }

}
