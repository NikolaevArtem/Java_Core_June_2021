package course_project;

import lombok.Data;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeMap;

@Data
public class SeaBattle {
    static final TreeMap<Integer, Integer> numberOfShips = new TreeMap<Integer, Integer>(Collections.reverseOrder()) {{
        /*put(4, 1);
        put(3, 2);
        put(2, 3);
        put(1, 4);*/
        put(3, 1);
        put(1, 1);
    }};
    private static Scanner scanner = new Scanner(System.in);
    private Player player1;
    private Player player2;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Player1, enter your name.");
        String playerName1 = scanner.nextLine();
        System.out.println("\nPlayer2, enter your name.");
        String playerName2 = scanner.nextLine();

        System.out.println("Thank you. The game is started.\n");
        SeaBattle game = new SeaBattle(playerName1, playerName2);
        game.fillFields();

        System.out.println("Ships are drawn. Let's start shooting.\n");
        Player winner = game.makeShots();
        System.out.println("Congratulations! " + winner.getName() + " is the winner!\n");
        Thread.sleep(4000);

        System.out.println("The field of the winner.\n");
        winner.printField(true);

        scanner.close();
    }

    public SeaBattle(String playerName1, String playerName2) {
        this.player1 = new Player(playerName1, scanner);
        this.player2 = new Player(playerName2, scanner);
    }

    private void fillFields() throws InterruptedException {
        player1.fillField(numberOfShips);
        clearScreen();
        System.out.println("Next player's turn.\n");
        player2.fillField(numberOfShips);
    }

    private Player makeShots() throws InterruptedException {
        Player nextPlayer = player1;
        Player firedPlayer = player2;
        boolean gameOver = false;

        clearScreen();
        while (!gameOver) {
            firedPlayer.printField(false);
            int[] shotCell = nextPlayer.makeShot();
            String shotResult = firedPlayer.checkShot(shotCell);

            if ("miss".equals(shotResult)) {
                System.out.println("You missed. Next player's turn.\n");
                firedPlayer.printField(false);
                firedPlayer = nextPlayer;
                nextPlayer = nextPlayer == player1 ? player2 : player1;
                Thread.sleep(4000);
                clearScreen();
            } else if ("repeat".equals(shotResult)) {
                System.out.println("Error! You have already shot this cell! Try again.\n");
            } else if ("hit".equals(shotResult)) {
                System.out.println("Congratulations! You hit the ship! Try again.\n");
            } else if ("sunk".equals(shotResult)) {
                gameOver = firedPlayer.allShipsSunk();
                if (gameOver) {
                    System.out.println("You sunk all ships!\n");
                    firedPlayer.printField(false);
                } else {
                    System.out.println("Congratulations! You sunk the ship! Try again.\n");
                }
            }
        }
        return nextPlayer;
    }

    public static void clearScreen() {
        for (int i = 0; i < 50; ++i) {
            System.out.println();
        }
    }

}

