package course_project.battleship.utils;


import course_project.battleship.model.Ship;

public class Position {
    private Ship ship;
    private State state;

    public enum State {
        EMPTY,
        SHIP,
        HIT,
        MISS,
        POINT
    }

    public Position() {
        state = State.EMPTY;
    }

    public Position(Ship ship) {
        this.ship = ship;
        this.state = State.SHIP;
    }

    public void addShip(Ship ship) {
        this.ship = ship;
        state = State.SHIP;
    }

    public Ship getShip() {
        return ship;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
