package course_project.SeaBattle.Services;

import course_project.SeaBattle.Models.Grid;
import course_project.SeaBattle.Models.Player;
import course_project.SeaBattle.Models.Ship;
import course_project.SeaBattle.Models.Square;
import course_project.SeaBattle.Utility.SquareStatus;

import java.util.List;

public class GridService {


    public static void createGrid(Player player) {
        Grid grid = new Grid();
        Square[][] squares = new Square[10][10];
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                squares[y][x] = new Square(x, y, SquareStatus.OCEAN);
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
        }

    }


}
