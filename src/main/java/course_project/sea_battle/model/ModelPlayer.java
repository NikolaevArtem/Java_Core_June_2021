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
        if(playerField.canAddThisSize(ship.getSize())) {
            if (playerField.addShip(ship)) {
                return "Correct";
            }
        }
        return "coordinateFalse";
    }

    public boolean readyToGame() {
        return playerField.readyToGame();
    }

    public int getFieldSize() {
        return playerField.getSize();
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
}
