package course_project.sea_battle.model;

public class Player {

    String name;
    Field playerField;

    public Player(String name, Field playerFild) {
        this.name = name;
        this.playerField = playerFild;
    }

    public String getName() {
        return name;
    }

    public Field getPlayerField() {
        return playerField;
    }

    public String addShip(Ship ship) {
        if(ship==null) {
            return "Fail Ship null";
        }
        if(!playerField.checkShipsSize(ship)){
            return "you can't add a ship of this length anymore";
        }
        if (playerField.addShip(ship)) {
            return "Correct";
        }
        return "Fail Position Not Correct";
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

}
