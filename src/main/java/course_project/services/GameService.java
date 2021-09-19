package course_project.services;

import course_project.Game;
import course_project.ship.models.Player;
import course_project.ship.abstracts.SinglePartShip;

import java.util.Locale;

public final class GameService {

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

    public static boolean isNeighbor(Player gamer, SinglePartShip partShip) {
        int x = partShip.getX();
        int y = partShip.getY();
        return gamer.containsShip(partShip.setX(x - 1)) ||//-x
                gamer.containsShip(partShip.setX(x - 1).setY(y + 1)) ||//-x +y
                gamer.containsShip(partShip.setY(y + 1)) ||//+y
                gamer.containsShip(partShip.setX(x + 1).setY(y + 1)) ||//+x +y
                gamer.containsShip(partShip.setX(x + 1));//+x
    }

    public static boolean isHeaderNeighbor(Player gamer, SinglePartShip partShip) {
        int x = partShip.getX();
        int y = partShip.getY();

        return gamer.containsShip(partShip.setX(x - 1).setY(y - 1)) ||//-x -y
                gamer.containsShip(partShip.setY(y - 1)) ||//-y
                gamer.containsShip(partShip.setX(x + 1).setY(y - 1));//+x -y
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
}
