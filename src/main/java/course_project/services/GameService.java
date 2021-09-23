package course_project.services;

import course_project.Game;
import course_project.ship.abstracts.ShipType;
import course_project.ship.models.Player;
import course_project.ship.abstracts.SinglePartShip;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.*;

public final class GameService {

    private static final String SHIP_SANK = "Вражеский корабль потоплен!";
    private static final String SHIP_DAMAGED = "Вражеский корабль подбит";
    private static final String MISS = "Промах. В следующий раз повезет";
    private static final String INVALID_IN = "Неверные координаты цели, попробуйте еще раз!";
    private static final String EXIST_HIT = "Вы уже стреляли по цели с такими координатами!";
    private static final String ANSI_RESET = "\033[0m";
    private static final String ANSI_RED = "\u001B[31m";

    private static Random rand;

    static {
        try {
            rand = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private GameService() {
        throw new IllegalStateException("Utility class");
    }

    public static String playersHit(Player aim, Player attacker) {
        String coordinates = getNewCoordinates(attacker.getName());
        SinglePartShip partShip = new SinglePartShip(coordinates.charAt(0) - 64, new Integer(coordinates.substring(1)));
        while (containsHit(aim, partShip)) {
            System.out.println(ANSI_RED + EXIST_HIT + ANSI_RESET);
            coordinates = getNewCoordinates(attacker.getName());
            partShip = new SinglePartShip(coordinates.charAt(0) - 64, new Integer(coordinates.substring(1)));
        }
        aim.getDamageList().add(partShip);
        attacker.getHitsMap().get(aim.containsShip(partShip)).add(partShip);
        if (aim.containsShip(partShip)) {
            if (PlayerController.destroyPartShip(aim, partShip)) {
                markSunkShip(attacker, aim, partShip);
                return SHIP_SANK;
            } else {
                return SHIP_DAMAGED;
            }
        }
        return MISS;
    }

    public static boolean markSunkShip(Player attacker, Player aim, SinglePartShip partShip) {
        List<SinglePartShip> marks = new ArrayList<>();

        List<SinglePartShip> ship = aim.getShip(partShip).getList();
        List<SinglePartShip> damageList = aim.getDamageList();
        if (ship.size() < 2 || ship.get(0).getY().equals(ship.get(1).getY())) {
            marks.addAll(markSunkHorizontalShip(ship));
        } else {
            marks.addAll(markSunkVerticalShip(ship));
        }
        return attacker.getHitsMap().get(Boolean.FALSE).addAll(marks) && damageList.addAll(marks);
    }

    private static Set<SinglePartShip> markSunkVerticalShip(List<SinglePartShip> list) {
        Set<SinglePartShip> hitsSet = new HashSet<>();
        SinglePartShip headerShip = list.get(0);
        addToList(hitsSet, new SinglePartShip(headerShip.getX() - 1, headerShip.getY() - 1));
        addToList(hitsSet, new SinglePartShip(headerShip.getX(), headerShip.getY() - 1));
        addToList(hitsSet, new SinglePartShip(headerShip.getX() + 1, headerShip.getY() - 1));
        for (SinglePartShip s : list) {
            addToList(hitsSet, new SinglePartShip(s.getX() - 1, s.getY()));
            addToList(hitsSet, new SinglePartShip(s.getX() + 1, s.getY()));
        }
        SinglePartShip lastShip = list.get(list.size() - 1);
        addToList(hitsSet, new SinglePartShip(lastShip.getX() - 1, lastShip.getY() + 1));
        addToList(hitsSet, new SinglePartShip(lastShip.getX(), lastShip.getY() + 1));
        addToList(hitsSet, new SinglePartShip(lastShip.getX() + 1, lastShip.getY() + 1));
        return hitsSet;
    }

    private static Set<SinglePartShip> markSunkHorizontalShip(List<SinglePartShip> list) {
        Set<SinglePartShip> hitsList = new HashSet<>();
        SinglePartShip headerShip = list.get(0);
        addToList(hitsList, new SinglePartShip(headerShip.getX() - 1, headerShip.getY() - 1));
        addToList(hitsList, new SinglePartShip(headerShip.getX() - 1, headerShip.getY()));
        addToList(hitsList, new SinglePartShip(headerShip.getX() - 1, headerShip.getY() + 1));
        for (SinglePartShip s : list) {
            addToList(hitsList, new SinglePartShip(s.getX(), s.getY() - 1));
            addToList(hitsList, new SinglePartShip(s.getX(), s.getY() + 1));
        }
        SinglePartShip lastShip = list.get(list.size() - 1);
        addToList(hitsList, new SinglePartShip(lastShip.getX() + 1, lastShip.getY() - 1));
        addToList(hitsList, new SinglePartShip(lastShip.getX() + 1, lastShip.getY()));
        addToList(hitsList, new SinglePartShip(lastShip.getX() + 1, lastShip.getY() + 1));

        return hitsList;
    }

    private static boolean addToList(Set<SinglePartShip> hitsList, SinglePartShip partShip) {
        if ((0 < partShip.getX() && partShip.getX() < 11) && (0 < partShip.getY() && partShip.getY() < 11)) {
            return hitsList.add(partShip);
        }
        return false;
    }

    public static boolean isVerticalNeighbor(Player gamer, SinglePartShip partShip) {
        int x = partShip.getX();
        int y = partShip.getY();
        return gamer.containsShip(partShip.setX(x - 1)) ||//-x
                gamer.containsShip(partShip.setX(x - 1).setY(y + 1)) ||//-x +y
                gamer.containsShip(partShip.setY(y + 1)) ||//+y
                gamer.containsShip(partShip.setX(x + 1).setY(y + 1)) ||//+x +y
                gamer.containsShip(partShip.setX(x + 1));//+x
    }

    public static boolean isHorizontalNeighbor(Player gamer, SinglePartShip partShip) {
        int x = partShip.getX();
        int y = partShip.getY();
        return gamer.containsShip(partShip.setY(y - 1)) ||//-y
                gamer.containsShip(partShip.setX(x + 1).setY(y - 1)) ||//+x -y
                gamer.containsShip(partShip.setX(x + 1)) ||//+x
                gamer.containsShip(partShip.setX(x + 1).setY(y + 1)) ||//+x +y
                gamer.containsShip(partShip.setY(y + 1));//+y
    }


    public static boolean isHeaderNeighbor(Player gamer, SinglePartShip partShip) {
        int x = partShip.getX();
        int y = partShip.getY();

        return gamer.containsShip(partShip.setX(x - 1).setY(y - 1)) ||//-x -y
                gamer.containsShip(partShip.setY(y - 1)) ||//-y
                gamer.containsShip(partShip.setX(x + 1).setY(y - 1)) ||//+x -y
                gamer.containsShip(partShip.setX(x - 1)) ||//-x
                gamer.containsShip(partShip.setX(x + 1)) ||//+x
                gamer.containsShip(partShip.setX(x - 1).setY(y + 1)) ||//-x +y
                gamer.containsShip(partShip.setY(y + 1)) ||//+y
                gamer.containsShip(partShip.setX(x + 1).setY(y + 1));//+x +y
    }

    public static String getNewCoordinates(String name) {
        System.out.printf(name + ": введите координаты цели([A-J][1-10]): ");
        String coordinates = Game.scanner.nextLine().trim().toUpperCase(Locale.ROOT);
        while (!isValidCoordinatesForShot(coordinates)) {
            System.out.println(ANSI_RED + INVALID_IN + ANSI_RESET);
            System.out.printf(name + ": введите координаты цели([A-J][1-10]): ");
            coordinates = Game.scanner.nextLine().trim().toUpperCase(Locale.ROOT);
        }
        return coordinates;
    }

    public static String getNewCoordinates(int numberOfShip, int numberOfShipDeck) {
        System.out.printf("Введите координаты и положение %1$s-ого %2$s-палубного корабля([A-J][1-10] [v|h]): ", numberOfShip, numberOfShipDeck);
        String coordinates = Game.scanner.nextLine().trim().toUpperCase(Locale.ROOT);
        while (!isValidCoordinatesForShip(coordinates)) {
            System.out.println(ANSI_RED + INVALID_IN + ANSI_RESET);
            System.out.printf("Введите координаты и положение %1$s-ого %2$s-палубного корабля([A-J][1-10] [v|h]): ", numberOfShip, numberOfShipDeck);
            coordinates = Game.scanner.nextLine().trim().toUpperCase(Locale.ROOT);
        }
        return coordinates;
    }

    public static Player getNewPlayerWithRandomShips(String name) {
        Player tempPlayer = new Player(name);

        for (int i = 0; i < 4; i++) {

            for (int j = i; j < 4; j++) {

                String coordinates = getRandomCoordinates();
                String location = rand.nextBoolean() ? "V" : "H";

                SinglePartShip partShip = new SinglePartShip(coordinates.charAt(0) - 64, new Integer(coordinates.substring(1)));
                while (tempPlayer.containsShip(partShip) ||
                        !PlayerController.addToList(tempPlayer, ShipType.getType(i + 1), coordinates, location, i + 1)) {
                    coordinates = getRandomCoordinates();
                    location = rand.nextBoolean() ? "V" : "H";
                    partShip = new SinglePartShip(coordinates.charAt(0) - 64, new Integer(coordinates.substring(1)));
                }
            }
        }

        return tempPlayer;
    }

    private static boolean containsHit(Player gamer, SinglePartShip partShip) {
        return gamer.getDamageList().contains(partShip);
    }

    private static boolean isValidCoordinatesForShot(String... arg) {
        if (arg[0].split("\\s").length > 1) {
            return false;
        }
        return arg[0].matches("[A-J][1-9][0]*");
    }

    private static boolean isValidCoordinatesForShip(String... arg) {
        if (arg[0].split("\\s").length != 2) {
            return false;
        }
        String[] split = arg[0].split("\\s");
        return split[0].matches("[A-J]([1-9]|10)") && split[1].matches("[VH]");
    }

    private static String getRandomCoordinates() {
        return (char) (65 + rand.nextInt(10)) + String.valueOf(rand.nextInt(10) + 1);
    }
}
