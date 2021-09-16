package course_project;

import java.util.Scanner;

public class Human extends Player {

    private final Scanner scanner;

    public Human(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void placeShips(ShipPlacer shipPlacer) {
        printField(false);
        for (ShipKind sk : ShipKind.values()) {
            int count = sk.getCount();
            String shipType = count > 1 ? sk.getType() + "s" : sk.getType();
            System.out.printf("You need to place %d %s\n", count, shipType);
            while (count > 0) {
                shipPlacer.place(sk);
                System.out.println("\033[H\033[2J");
                count--;
                printField(false);
                if (count > 0) {
                    System.out.printf("%s placed, %d left\n", sk.getType(), count);
                }
            }
        }
    }

    @Override
    public Coordinate move() {
        System.out.print("Your turn. Input coordinate: ");
        while (true) {
            String shot = scanner.nextLine();
            if (Coordinate.check(shot)) {
                return new Coordinate(shot);
            } else {
                System.out.println("Invalid input. Try again.");
            }
        }
    }

    public Scanner getScanner() {
        return scanner;
    }
}
