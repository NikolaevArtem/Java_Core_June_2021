package course_project.ship.models;

import course_project.ship.abstracts.ShipStatus;
import course_project.ship.abstracts.SinglePartShip;
import course_project.ship.abstracts.ShipType;

import java.util.*;
import java.util.stream.Stream;

public class Player {

    private String name;
    private final Map<String, List<Ship>> ships = new HashMap<>();
    private final Map<Boolean, List<SinglePartShip>> hitsMap = new HashMap<>();
    private final List<SinglePartShip> damageList = new ArrayList<>();

    public Player(String name) {
        this.name = name;
        ships.put(ShipType.SINGLE_DECK.getType(), new ArrayList<>());
        ships.put(ShipType.DOUBLE_DECK.getType(),new ArrayList<>());
        ships.put(ShipType.THREE_DECK.getType(), new ArrayList<>());
        ships.put(ShipType.FOUR_DECK.getType(), new ArrayList<>());

        hitsMap.put(Boolean.TRUE, new ArrayList<>());
        hitsMap.put(Boolean.FALSE, new ArrayList<>());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SinglePartShip> getDamageList() {
        return damageList;
    }

    public Map<String, List<Ship>> getMapShips() {
        return ships;
    }

    public Map<Boolean, List<SinglePartShip>> getHitsMap() {
        return hitsMap;
    }

    public Ship getShip(SinglePartShip partShip) {
        Collection<List<Ship>> values = ships.values();
        for (List<Ship> shipList : values) {
            for (Ship ship : shipList) {
                if (ship.contains(partShip)) {
                    return ship;
                }
            }
        }
        return null;
    }

    public boolean containsShip(SinglePartShip singlePartShip) {
        Stream<SinglePartShip> singlePartShipStream = ships
                .values()
                .stream()
                .flatMap(elem -> elem
                        .stream()
                        .flatMap(l -> l.getList().stream()));
        return singlePartShipStream.anyMatch(elem -> elem.equals(singlePartShip));
    }

    public boolean isEmptyHealthShips() {
        Stream<SinglePartShip> singlePartShipStream = ships
                .values()
                .stream()
                .flatMap(elem -> elem
                        .stream()
                        .flatMap(l -> l.getList().stream()));
        return singlePartShipStream.noneMatch(elem -> elem.getStatus().equals(ShipStatus.HEALTHY));
    }
}
