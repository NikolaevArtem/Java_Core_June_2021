package course_project.ship.models;

import course_project.ship.abstracts.SinglePartShip;

import java.util.ArrayList;
import java.util.List;

public class Ship {

    private final List<SinglePartShip> list = new ArrayList<>();

    public Ship() {
    }

    public Ship(List<SinglePartShip> list) {
        this.list.addAll(list);
    }

    public boolean contains(SinglePartShip singlePartShip) {
        return list.contains(singlePartShip);
    }

    public List<SinglePartShip> getList() {
        return list;
    }
}
