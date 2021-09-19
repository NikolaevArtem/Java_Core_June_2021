package course_project.ship.models;

import course_project.ship.models.Ship;
import course_project.ship.abstracts.SinglePartShip;
import course_project.ship.abstracts.TypeShip;

import java.util.*;
import java.util.stream.Stream;

public class Player {

    private String name;
    private final Map<String, List<Ship>> ships = new HashMap<>();
    private final Map<Boolean, List<SinglePartShip>> hitsList = new HashMap<>();

    public Player(String name) {
        this.name = name;
        ships.put(TypeShip.SINGLE_DECK.getType(), new ArrayList<>());
        ships.put(TypeShip.DOUBLE_DECK.getType(),new ArrayList<>());
        ships.put(TypeShip.THREE_DECK.getType(), new ArrayList<>());
        ships.put(TypeShip.FOUR_DECK.getType(), new ArrayList<>());

        hitsList.put(Boolean.TRUE, new ArrayList<>());
        hitsList.put(Boolean.FALSE, new ArrayList<>());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, List<Ship>> getShips() {
        return ships;
    }

    public Map<Boolean, List<SinglePartShip>> getHitsMap() {
        return hitsList;
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

    public boolean isEmptyShips() {
        Stream<SinglePartShip> singlePartShipStream = ships
                .values()
                .stream()
                .flatMap(elem -> elem
                        .stream()
                        .flatMap(l -> l.getList().stream()));
        return !singlePartShipStream.findAny().isPresent();
    }
}
