package course_project.sea_battle.ships;

public class Ship {
    private ShipType shipType;
    private boolean isKilled;

    public boolean isKilled() {
        return isKilled;
    }

    public void setKilled(boolean killed) {
        isKilled = killed;
    }

    public Ship(ShipType shipType) {
        this.shipType = shipType;
        this.isKilled = false;
    }

    public ShipType getShipType() {
        return shipType;
    }
}
