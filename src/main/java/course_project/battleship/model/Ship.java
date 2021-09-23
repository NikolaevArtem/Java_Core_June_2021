package course_project.battleship.model;

public class Ship {
    private int deck;
    private boolean isAlive;

    private int countHits = 1;

    public Ship(int deck) {
        this.isAlive = true;
        this.deck = deck;
    }

    public boolean getDamage() {
        if (countHits != deck) {
            countHits++;
            return true;
        }
        isAlive = false;
        return false;
    }

    public int getDeck() {
        return deck;
    }

    public void setDeck(int deck) {
        this.deck = deck;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public int getCountHits() {
        return countHits;
    }

    public void setCountHits(int countHits) {
        this.countHits = countHits;
    }
}
