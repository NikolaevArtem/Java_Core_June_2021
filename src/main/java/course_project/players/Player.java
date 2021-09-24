package course_project.players;

import course_project.engine.GameMap;

public abstract class Player {

    private String name;
    public GameMap playerGameMap;


    public Player(String name){
        this.name = name;
        playerGameMap = new GameMap();
    }
    public void shoot(String[][] playerOneMap, String[][] computerMap, String name){

    }
    public String getName(){
        return this.name;
    }

}