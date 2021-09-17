package course_project.util.user_input_reader;

import course_project.components.Coordinate;

import java.util.Scanner;

public abstract class UserInputReader {

    protected Scanner scanner;
    protected int x;
    protected int y;

    public abstract Coordinate getPointFromInput();

    protected void resetState() {
        x = -1;         // reset state of a reader
        y = -1;         // to receive next input
    }

    protected boolean outOfRange(int x, int y) {
        return (x < 0 || x > 9) || (y < 0 || y > 9);
    }
}
