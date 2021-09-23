package course_project.services;

import course_project.ship.abstracts.ShipStatus;
import course_project.ship.abstracts.ShipType;
import course_project.ship.models.Player;
import course_project.ship.models.Ship;
import course_project.ship.abstracts.SinglePartShip;

import java.util.*;

import static course_project.services.GameService.*;

public final class PlayerController {

    private static final String ANSI_RESET = "\033[0m";
    private static final String ANSI_RED = "\u001B[31m";

    private PlayerController() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean destroyPartShip(Player player, SinglePartShip partShip) {
        Map<String, List<Ship>> ships = player.getMapShips();
        Collection<List<Ship>> values = ships.values();

        for (List<Ship> next : values) {
            for (Ship next1 : next) {
                if (next1.getList().contains(partShip)) {
                    List<SinglePartShip> list = next1.getList();
                    for (SinglePartShip singlePartShip : list) {
                        if (singlePartShip.equals(partShip)) {
                            singlePartShip.setStatus(ShipStatus.SANK);
                        }
                    }
                    return list.stream().noneMatch(elem -> elem.getStatus().equals(ShipStatus.HEALTHY));
                }
            }
        }
        return false;
    }

    public static void initShipLists(Player gamer, ShipType shipType, int countOfDeck) {
        for (int i = 0; i < countOfDeck; i++) {
            String coordinates = GameService.getNewCoordinates(i + 1, 5 - countOfDeck);
            if (!addToList(gamer, shipType, coordinates.split("\\s")[0], coordinates.split("\\s")[1], 5 - countOfDeck)) {
                System.out.println(ANSI_RED + "Что-то пошло не так, попробуйте еще раз" + ANSI_RESET);
                i--;
            }
        }
    }

    public static boolean addToList(Player gamer, ShipType shipType, String coordinates, String location, int countOfDeck) {
        List<SinglePartShip> tempList = new ArrayList<>();
        SinglePartShip partShip = new SinglePartShip(coordinates.charAt(0) - 64, new Integer(coordinates.substring(1)));
        for (int i = 0; i < countOfDeck; i++) {
            if (i == 0 && isHeaderNeighbor(gamer, partShip)) {
                return false;
            }
            if (gamer.containsShip(partShip)) {
                return false;
            }
            if ((partShip.getX() > 10 || partShip.getY() > 10)) {
                return false;
            }
            if (location.equals("V") ? isVerticalNeighbor(gamer, partShip) : isHorizontalNeighbor(gamer, partShip)) {
                return false;
            }
            tempList.add(partShip);
            if (location.equals("V")) {
                partShip = partShip.setY(partShip.getY() + 1);
            } else {
                partShip = partShip.setX(partShip.getX() + 1);
            }
        }
        gamer.getMapShips().get(shipType.getType()).add(new Ship(tempList));
        return true;
    }


}
