package course_project.battleship.player;


import course_project.battleship.model.Ship;
import course_project.battleship.utils.Coordinate;

public class Computer extends Player {

    public Computer() {
        super("Computer");
    }

    @Override
    public boolean makeTurn(Player enemy, Coordinate coordinate) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void placeShip(Coordinate coordinate, Ship ship, int direction) {
        throw new UnsupportedOperationException();
    }
}
