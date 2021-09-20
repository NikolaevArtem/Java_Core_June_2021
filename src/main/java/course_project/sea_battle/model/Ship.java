package course_project.sea_battle.model;

import java.util.List;

public class Ship {
    private final List<Point> coordinates;
    private int lives;
    private boolean isAlive;

    public Ship(List<Point> coordinates) {
        this.coordinates = coordinates;
        this.lives = coordinates.size();
        this.isAlive = true;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public boolean isAlive() {
        return lives > 0;
    }

    public void setAlive(boolean alive) {
        this.isAlive = alive;
    }

    public List<Point> getCoordinates() {
        return coordinates;
    }

}
