package course_project.SeaBattle.Models;

import course_project.SeaBattle.Utility.SquareStatus;

public class Square {
    private final int x;
    private final int y;
    private SquareStatus squareStatus;

    private static final String ANSI_RED = "\u001b[31m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_GREEN = "\u001b[32m";
    private static final String ANSI_RESET = "\u001b[0m";

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

    public String print() {
        String result = " ";
        switch (squareStatus) {

            case HIT:
                result = ANSI_RED + 'X' + ANSI_RESET;
                break;
            case SHIP:
                result = ANSI_GREEN + 'W' + ANSI_RESET;
                break;
            case OCEAN:
            case BOARD:
                result = ANSI_BLUE + '.' + ANSI_RESET;
                break;
            case MISSED:
                result = ANSI_BLUE + 'o' + ANSI_RESET;
                break;
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return x == square.x && y == square.y;
    }

}
