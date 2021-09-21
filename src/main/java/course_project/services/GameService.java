package course_project.services;

import course_project.Game;
import course_project.ship.abstracts.TypeShip;
import course_project.ship.models.Player;
import course_project.ship.abstracts.SinglePartShip;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.*;

public final class GameService {

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

    public static boolean playersHit(Player aim, Player attacker) {
        String coordinates = getNewCoordinates(attacker.getName());
        SinglePartShip partShip = new SinglePartShip(coordinates.charAt(0) - 64, new Integer(coordinates.substring(1)));
        attacker.getHitsMap().get(aim.containsShip(partShip)).add(partShip);
        if (aim.containsShip(partShip)) {
            PlayerController.destroyPartShip(aim, partShip);
            return true;
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
            System.out.printf(name + ": введите координаты цели([A-J][1-10]): ");
            coordinates = Game.scanner.nextLine().trim().toUpperCase(Locale.ROOT);
        }
        return coordinates;
    }

    public static String getNewCoordinates(int numberOfShip, int numberOfShipDeck) {
        System.out.printf("Введите координаты и положение %1$s-ого %2$s-палубного корабля([A-J][1-10] [v|h]): ", numberOfShip, numberOfShipDeck);
        String coordinates = Game.scanner.nextLine().trim().toUpperCase(Locale.ROOT);
        while (!isValidCoordinatesForShip(coordinates)) {
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
                        !PlayerController.addToList(tempPlayer, TypeShip.getType(i + 1), coordinates, location, i + 1)) {
                    coordinates = getRandomCoordinates();
                    location = rand.nextBoolean() ? "V" : "H";
                    partShip = new SinglePartShip(coordinates.charAt(0) - 64, new Integer(coordinates.substring(1)));
                }
            }
        }

        return tempPlayer;
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
