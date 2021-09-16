package course_project;

import java.util.Scanner;

public class SeaBattle {
    static final int FIELD_SIZE = 10;
    private final Player playerOne = new Human();
    private final Player playerTwo = new Human();
    private final Scanner scanner = new Scanner(System.in);


    public void run() {
        System.out.println("Welcome to SeaBattle!");
        greetingMenu();
        fieldsFilling(playerOne);
        fieldsFilling(playerTwo);

    }

    private void greetingMenu() {
        System.out.println("Player_2, turn around. Player_1 it's your turn to fill the field!");
    }

    private void fieldsFilling(Player player) {
        if (player instanceof Human) {
            System.out.println("Do you want to place ships manually or in a random order? Enter \"manually\" or \"random\"");
            while (true) {
                String mode = scanner.nextLine().trim();
                if ("manually".equals(mode)) {
                    player.placeShips(new ManualShipPlacer(player.field, player.playerShips, scanner));
                    return;
                } else if ("random".equals(mode)) {
                    break;
                } else
                    System.out.println("Invalid input. Please, enter \"manually\" or \"random\"");
            }
        }
        player.placeShips(new RandomShipPlacer(player.field, player.playerShips));
    }

}

