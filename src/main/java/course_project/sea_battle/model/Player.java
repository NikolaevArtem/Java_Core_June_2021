package course_project.sea_battle.model;

public class Player {

    String name;
    Field playerFild;

    public Player(String name, Field playerFild) {
        this.name = name;
        this.playerFild = playerFild;
    }

    public String getName() {
        return name;
    }

    public Field getPlayerFild() {
        return playerFild;
    }

    public boolean addShip(Ship ship){
        return playerFild.addShip(ship);
    }

}
