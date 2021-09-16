package course_project.sea_battle.model;

public class ModelPlayer {

    String name;
    Field playerField;

    public ModelPlayer(String name, Field playerField) {
        this.name = name;
        this.playerField = playerField;
    }

    public String getName() {
        return name;
    }

    public Field getPlayerField() {
        return playerField;
    }

    public String addShip(Ship ship) {
        return playerField.addShip(ship);
    }

    public boolean readyToGame() {
        return playerField.readyToGame();
    }

    public String shot(String shot){
       return playerField.shot(shot);
    }

    public boolean lose() {
        return playerField.shipsDead();
    }

    public void autoGenerateShips() {
        playerField.autoGenerateShips();
    }

    public String autoShot(){
        return playerField.autoShot();
    }

    @Override
    public String toString() {
        return "ModelPlayer{" +
                "name='" + name + '\'' +
                ", playerField=" + playerField +
                '}';
    }
}
