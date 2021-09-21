package course_project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class SeaBattleMap {

    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_BLACK = "\u001B[0m";

    private final Point[][] field;
    private final int size;

    String getPlayerName() {
        return playerName;
    }

    private final String playerName;
    private final List<Ship> ships = new ArrayList<>();

    SeaBattleMap(int size, String playerName) {

        this.size = size;
        this.playerName = playerName;

        field = new Point[size][size];
        for (int i = 0, offsetX = 0; i < size; i++, offsetX++) {
            for (int j = 0, offsetY = 0; j < size; j++, offsetY++) {
                field[i][j] = new Point(offsetX, offsetY, MapPointType.Emty);
            }
        }
    }

    void addShip(Point entry, int size, ShipLocationType type) throws IllegalArgumentException {
        Ship ship = new Ship(field, entry, size, type);
        ships.add(ship);
    }

    int getNSizedShipsCount(int size) {
        return ((Long) ships.stream()
                .filter(s -> s.getSize() == size).count()).intValue();

    }

    boolean shoot(Point point) {
        Point fieldPoint = field[point.getX()][point.getY()];
        if (fieldPoint.getType() == MapPointType.Ship) {
            fieldPoint.setType(MapPointType.FiredShip);
            ships.removeIf(Ship::IsDestroyed);
            System.out.println("Well done!");
            return true;
        } else if (fieldPoint.getType() == MapPointType.FiredShip) {
            System.out.println("It's already fired target, take a new one!");
            return true;
        }
        else {
            fieldPoint.setType(MapPointType.Fired);
            System.out.println("Bad luck! Move goes to another player");
            return false;
        }
    }

    List<Ship> getShips() {
        return ships;
    }

    private int getX_Offset() {
        return field[size - 1][size - 1].getX() + 1;
    }

    private int getY_Offset() {
        return field[size - 1][size - 1].getY() + 1;
    }

    ArrayList<String> getView(GameStatus status) {

        ArrayListImpl battleMapView = new ArrayListImpl();

        battleMapView.add(playerName);

        String headerNumsEnumeration = Stream.iterate(1, i -> i + 1)
                .limit(getX_Offset())
                .map(String::valueOf)
                .collect(Collectors.joining(" "));

        battleMapView.add(headerNumsEnumeration);
        battleMapView.add(
                getLineString(headerNumsEnumeration)
        );

        for (int y = 0, charIndex = 65; y < getY_Offset(); y++, charIndex++) {
            StringBuilder sb = new StringBuilder();
            sb.append((char) charIndex);
            sb.append("|");
            for (int x = 0; x < getX_Offset(); x++) {
                sb.append(
                        field[x][y].getView(status)
                );
            }
            sb.append("|");
            battleMapView.add(sb.toString());
        }

        battleMapView.add(
                getLineString(headerNumsEnumeration)
        );

        //center align
        for (int i = 0; i < battleMapView.size(); i++) {
            String s = battleMapView.get(i);
            int maxStringLength = battleMapView.getMaxStringLength();
            int minLength = (int) Math.ceil((double) (maxStringLength - s.length()) / 2 + s.length());
            String fString = String.format("%%%ds", minLength);
            if (minLength < maxStringLength) {
                fString = String.format("%%%ds%%%ds", minLength, maxStringLength - minLength);
            }
            battleMapView.set(i, String.format(fString, s, " "));
        }

        //color ships marks after Formatter usage as Java's APIs don't natively understand ANSI color escape codes
        for (int i = 0; i < battleMapView.size(); i++) {
            String s = battleMapView.get(i);
            if (s.contains("\u2713") || s.contains("\u00D7")) {
                String coloredString = Arrays.stream(s.split(""))
                        .map(ss -> {
                            if (ss.contains("\u2713")) {
                                ss = ANSI_GREEN + ss + ANSI_BLACK;
                            } else if (ss.contains("\u00D7")) {
                                ss = ANSI_RED + ss + ANSI_BLACK;
                            }
                            return ss;
                        })
                        .collect(Collectors.joining());

                battleMapView.set(i, String.format(coloredString, s, " "));
            }
        }

        return battleMapView;
    }

    private String getLineString(String headerNumsEnumeration) {
        return "+" + String.join("", Collections.nCopies(headerNumsEnumeration.length(), "-")) + "+";
    }

    private class ArrayListImpl extends ArrayList<String> {
        private int maxStringLength = 0;

        @Override
        public boolean add(String s) {
            maxStringLength = Math.max(maxStringLength, s.length());
            return super.add(s);
        }

        public int getMaxStringLength() {
            return maxStringLength;
        }
    }
}
