package course_project.battleship.player;


import course_project.battleship.model.Field;
import course_project.battleship.model.Ship;
import course_project.battleship.utils.Coordinate;

public abstract class Player {
    private String name;
    private Field battlefield;
    private Field monitorField;


    public Player(String name) {
        this.name = name;
        battlefield = new Field();
        monitorField = new Field();
    }

    public abstract boolean makeTurn(Player enemy, Coordinate coordinate);

    public abstract void placeShip(Coordinate coordinate, Ship ship, int direction);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Field getBattlefield() {
        return battlefield;
    }

    public void setBattlefield(Field battlefield) {
        this.battlefield = battlefield;
    }

    public Field getMonitorField() {
        return monitorField;
    }

    public void setMonitorField(Field monitorField) {
        this.monitorField = monitorField;
    }
}
