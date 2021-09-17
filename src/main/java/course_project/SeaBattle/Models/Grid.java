package course_project.SeaBattle.Models;

public class Grid {
    Square[][] squares;

    public void setSquares(Square[][] squares) {
        this.squares = squares;
    }

    public Square[][] getSquares() {
        return squares;
    }

    public Square getSquare(int x, int y) {
        return squares[x][y];
    }

    public void setSquare(int x, int y, Square square) {
        squares[x][y] = square;
    }


}
