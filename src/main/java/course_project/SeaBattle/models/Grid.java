package course_project.SeaBattle.models;

/*
The grid consists of squares
 */

public class Grid {

    Square[][] squares;

    public Square[][] getSquares() {
        return squares;
    }

    public void setSquares(Square[][] squares) {
        this.squares = squares;
    }

    public void setSquare(int x, int y, Square square) {
        squares[x][y] = square;
    }

    public Square getSquare(int x, int y) {
        return squares[x][y];
    }
}
