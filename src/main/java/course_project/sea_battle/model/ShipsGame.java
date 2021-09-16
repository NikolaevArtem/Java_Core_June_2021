package course_project.sea_battle.model;

import course_project.sea_battle.model.Ships;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShipsGame {

    private List<Ships> allShips;
    Map<Integer, Integer> inListSizeShip;

    public ShipsGame() {
        allShips = new ArrayList<>();
        inListSizeShip = new HashMap<>();
        inListSizeShip.put(1, 4);
        inListSizeShip.put(2, 3);
        inListSizeShip.put(3, 2);
        inListSizeShip.put(4, 1);
    }

    public List<Ships> getAllShips() {
        return allShips;
    }

    public boolean ready() {
        return allShips.size() >= 10;
    }

    public boolean addShip(Ship ship){
            int key = ship.getSize();
            int value = inListSizeShip.get(ship.getSize()) - 1;
            inListSizeShip.put(key, value);
            return allShips.add(ship);
    }

    public boolean shipsDead() {
        int dead = 0;
        for(Ships ship: allShips) {
            if(ship.isDead()) {
                dead++;
            }
        }
        return dead==allShips.size();
    }

    public boolean canAddThisSize(int size) {
        return inListSizeShip.get(size)>0;
    }

    @Override
    public String toString() {
        return "ShipsGame{" +
                "allShips=" + allShips +
                ", inListSizeShip=" + inListSizeShip +
                '}';
    }
}
