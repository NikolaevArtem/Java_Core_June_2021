package course_project.sea_battle.model;

import course_project.sea_battle.model.Ships;

import java.util.ArrayList;
import java.util.List;

public class ShipsGame {

    private List<Ships> allShips;
    private final int shipOne = 4;
    private final int shipTwo = 3;
    private final int shipTree = 2;
    private final int shipFore = 1;

    public ShipsGame() {
        allShips = new ArrayList<>();
    }

    public List<Ships> getAllShips() {
        return allShips;
    }

    public boolean ready() {
        return allShips.size() >= 10;
    }
    public void addShip(Ship ship){

        allShips.add(ship);
    }

    public boolean getShipInSize(int size){
        int a = 0;
        for(Ships ships: allShips){
            if(ships.getSize()==size){
                a++;
            }
        }
        switch (size){
             case 1: return a<shipOne;
             case 2: return a<shipTwo;
             case 3: return a<shipTree;
            default: return a<shipFore;
        }
    }
}
