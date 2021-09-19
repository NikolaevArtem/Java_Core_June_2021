
package course_project;

import course_project.models.Ship;
import course_project.service.ComputerThread;
import course_project.service.ShipCreator;
import java.util.*;
import java.util.concurrent.Exchanger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import course_project.service.UserThread;

public class SeaBattle {
    public static final int FIELD_SIZE = 10;
    public static final String CELL_REGEX = "(\\d)([a-j])";
    public static boolean testMode = false;

    public void run(boolean testArg) {

        final List<Integer> vert = IntStream.iterate(0, i -> i + 1)
                .limit(FIELD_SIZE)
                .boxed()
                .collect(Collectors.toList());
        final List<Character> hor = IntStream.iterate(0, i -> i + 1)
                .limit(FIELD_SIZE)
                .boxed()
                .map(e -> (char) (e + 'a'))
                .collect(Collectors.toList());
        Map<Integer, Integer> rules = new HashMap<>();
        List<Ship> ships = new ArrayList<>();
        List<Ship> userShips = new ArrayList<>();
        Exchanger<String> ex = new Exchanger<>();
        StringBuilder builder = new StringBuilder();
        testMode = testArg;


        rules.put(4, 1);
        rules.put(3, 2);
        rules.put(2, 3);
        rules.put(1, 4);

        builder.append("Field:\n")
            .append("Integer coordinates: ")
            .append(vert)
            .append("\n")
            .append("Character coordinates: ")
            .append(hor)
            .append("\n");

        ShipCreator shipCreator = new ShipCreator();

        for (Map.Entry<Integer, Integer> entry : rules.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                ships.add(shipCreator.createShip(entry.getKey()));
            }
        }

        if (testMode) {
            builder.append("Computer ships:\n");

            for (Ship ship : ships) {
                builder.append(ship)
                        .append("\n");
            }
        }

        ShipCreator userShipCreator = new ShipCreator();

        for (Map.Entry<Integer, Integer> entry : rules.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                userShips.add(userShipCreator.createShip(entry.getKey()));
            }
        }

        builder.append("User ships:\n");

        for (Ship ship : userShips) {
            builder.append(ship)
                    .append("\n");
        }

        System.out.println(builder);

        new Thread(new ComputerThread(ex)).start();
        new Thread(new UserThread(ex, ships, userShips)).start();

    }

}
