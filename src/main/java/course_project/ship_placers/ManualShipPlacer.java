package course_project.ship_placers;

import course_project.enums.CellState;
import course_project.enums.ShipKind;
import course_project.field_components.Cell;
import course_project.field_components.Coordinate;
import course_project.input_readers.InputReader;
import course_project.players.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ManualShipPlacer extends ShipPlacer {

    private final InputReader reader;

    public ManualShipPlacer(Player player, InputReader reader) {
        super(player);
        this.reader = reader;
    }

    @Override
    public void placeShips() {
        field.print(false);
        for (ShipKind sk : ShipKind.values()) {
            int count = sk.getCount();
            String shipType = count > 1 ? sk.getType() + "s" : sk.getType();
            System.out.printf("You need to place %d %s\n", count, shipType);
            while (count > 0) {
                place(sk);
                System.out.println("\033[H\033[2J");
                count--;
                field.print(false);
                if (count > 0) {
                    System.out.printf("%s placed, %d left\n", sk.getType(), count);
                }
            }
        }
    }

    @Override
    void place(ShipKind kind) {
        int lengthOfShip = kind.getLength();
        String inputLength = lengthOfShip == 1 ? "one coordinate" : "two coordinates";
        while(true) {
            System.out.printf("Input %s for %s: ", inputLength, kind.getType());
            String[] coordinates = reader.takeInput().trim().split("\\s+");
            if (placeAnyDeck(coordinates, kind)) {
                break;
            } else {
                System.out.println("Invalid format or count of coordinates." +
                        " A ship must be placed in a line. " +
                        "Try again. Examples: A7 A10 or B1");
            }
        }
    }

    private boolean placeAnyDeck(String[] coordinates, ShipKind kind) {
        if (kind.getLength() == 1 && coordinates.length != 1) {
            return false;
        }
        if (kind.getLength() > 1 && coordinates.length != 2) {
            return false;
        }
        if (cellHandler.isLine(coordinates) &&
                cellHandler.cellCount(coordinates) == kind.getLength() - 1) {
            boolean tooClose = Arrays.stream(coordinates).anyMatch(this::tooClose);
            if (tooClose) {
                System.out.println("Too close to another ship. Choose another place.");
                return false;
            }
            return isFit(coordinates, kind);
        }
        return false;
    }

    private List<Cell> lineToCells(String[] coordinates) {
        List<Cell> cells = new ArrayList<>();
        for (int i = 0; i <= cellHandler.cellCount(coordinates); i++) {
            Coordinate temp = new Coordinate(coordinates[0]);
            if (cellHandler.sameLine(coordinates, true)) {
                cells.add(field.getCell(temp.row, temp.column + i));
            } else {
                cells.add(field.getCell(temp.row + i, temp.column));
            }
        }
        return cells;
    }

    private boolean isFit(String[] coordinates, ShipKind kind) {
        Arrays.sort(coordinates, (o1, o2) -> {
            if (o1.charAt(0) == o2.charAt(0)) {
                return Integer.compare(Integer.parseInt(o1.substring(1)),
                        Integer.parseInt(o2.substring(1)));
            } else {
                return o1.compareTo(o2);
            }
        });
        List<Cell> cells = lineToCells(coordinates);
        boolean free = cells
                .stream()
                .allMatch(c -> c.getState().equals(CellState.EMPTY));
        if (free) {
            cells.forEach(c -> c.setState(CellState.DECK));
            playerShips.add(new Ship(kind, cells));
            return true;
        } else {
            System.out.println("Chosen cells are unavailable. Please, choose another.");
            return false;
        }
    }

    private boolean tooClose(String coordinate) {
        return field
                .getNeighbourCells(coordinate)
                .stream()
                .anyMatch(c -> c.getState().equals(CellState.DECK));
    }
}
