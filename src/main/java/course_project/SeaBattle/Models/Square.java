package course_project.SeaBattle.Models;

import course_project.SeaBattle.Utility.SquareStatus;

public class Square {
    private final int x;
    private final int y;
    private SquareStatus squareStatus;

    public Square(int x, int y, SquareStatus squareStatus) {
        this.x = x;
        this.y = y;
        this.squareStatus = squareStatus;
    }

    public void setSquareStatus(SquareStatus squareStatus) {
        this.squareStatus = squareStatus;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public SquareStatus getSquareStatus() {
        return squareStatus;
    }

    public char print() {
        char result = ' ';
        switch (squareStatus) {

            case HIT:
                result = 'X';
                break;
            case SHIP:
                result = '\u272D';
                break;
            case OCEAN:
                result = '.';
                break;
            case MISSED:
                result = 'o';
                break;
        }
        return result;
    }
}
