package course_project;

import homework_2.ConsoleSafeReader;

public class Human extends Player {
    final static private String INVALID_INPUT = "Invalid format or count of coordinates." +
            " Try again. Examples: A7 A10 or B1";

    @Override
    public void placeShips() {
        for (ShipKind sk : ShipKind.values()) {
            int count = sk.getCount();
            String shipType = count > 1 ? sk.getType() + "s" : sk.getType();
            System.out.printf("You need to place %d %s\n", count, shipType);
            while (count > 0) {
                place(sk);
                count--;
                if (count > 0) {
                    System.out.printf("%s placed, %d left", sk.getType(), count);
                }
            }
        }
    }

    @Override
    public Coordinate move() {
        return null;
    }

    private void place(ShipKind kind) {
        String countOfCoordinates = kind.getLength() == 1 ? "one coordinate" : "two coordinates";
        System.out.printf("Please, input %s for %s: ", countOfCoordinates, kind.getType());
        while(true) {
            String[] coordinates = ConsoleSafeReader.read().trim().split("\\s+");
            if (kind.getLength() == 1) {
                if (coordinates.length == 1 && Coordinate.check(coordinates[0])) {
                    Cell cell = field.getCell(coordinates[0]);
                    cell.setState(CellState.DECK);
//                    playerShips.add(new Ship(kind, ));
                } else {
                    System.out.println(INVALID_INPUT);
                }
            }
        }
    }

//    private boolean checkAndAddShip(ShipKind kind, String input) {
//
//    }

}
