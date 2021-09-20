package course_project;

import lombok.Data;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Pattern;

@Data
public class Player {
    public static int numberOfUsers;
    private String name;
    private Field field;
    private Scanner scanner;

    public Player(String name, Scanner scanner) {
        this.name = name == null || !(Pattern.matches("[a-zA-Z]+", name)) ? "Unknown" + ++numberOfUsers : name;
        this.field = new Field();
        this.scanner = scanner;
    }

    void fillField(TreeMap<Integer, Integer> numberOfShips) throws InterruptedException {
        field.printField(true);

        for (Integer key : numberOfShips.keySet()) {
            int numberOfShipType = numberOfShips.get(key);

            for (int i = 0; i < numberOfShipType; i++) {
                boolean shipCreated = false;

                while (!shipCreated) {
                    System.out.println(this.name + ", enter the coordinates of the ship (" + key + " cell(s)).");
                    System.out.println("Input format must be \"A1 A2\" or \"A1 B1\" for multitube ship and \"A1\" for one-pipe ship.\n");
                    String shot = scanner.nextLine();
                    String[] shipCoordinates = shot.trim().split("\\s");
                    shipCreated = field.createShip(key, shipCoordinates);

                    if (!shipCreated) {
                        field.printField(true);
                    } else {
                        field.printField(true);
                    }
                }
            }
        }
        Thread.sleep(4000);
    }

    int[] makeShot() {
        boolean shotFired = false;
        int[] shotCell = new int[]{};
        System.out.println(this.name + ", enter the coordinates of the shot.\n");

        while (!shotFired) {
            shotCell = Field.stringToCell(scanner.nextLine());
            if (shotCell == null) {
                System.out.println("Error! You entered the wrong coordinates! Try again.\n");
            } else {
                shotFired = true;
            }
        }
        return shotCell;
    }

    String checkShot(int[] shotCell) {
        return field.shotResult(shotCell);
    }

    boolean allShipsSunk() {
        return field.allShipsSunk();
    }

    public void printField(boolean showShips) {
        field.printField(showShips);
    }

}
