package course_project;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Field f = new Field();
        Ship s = new Ship(ShipKind.THREE_DECK_SHIP, Arrays.asList(f.getCell("B2"), f.getCell("B3"), f.getCell("B4")));
        f.print(true);
        f.print(false);
        System.out.println(f.getCell("B2"));
        System.out.println(s.containsCell(f.getCell("B1")));
        System.out.println(s.containsCell(f.getCell("B2")));
        System.out.println(s.containsCell(f.getCell("B3")));
        System.out.println(s.containsCell(f.getCell("B4")));
        System.out.println(s.containsCell(f.getCell("B5")));
        f.getCell("B2").setState(CellState.HIT);
        System.out.println(f.getCell("B2"));
        System.out.println(s.isDestroyed());
        f.getCell("B3").setState(CellState.HIT);
        System.out.println(f.getCell("B3"));
        System.out.println(s.isDestroyed());
        f.getCell("B4").setState(CellState.HIT);
        System.out.println(f.getCell("B4"));
        System.out.println(s.isDestroyed());
        f.print(false);


    }
}
