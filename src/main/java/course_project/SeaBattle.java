package course_project;

import java.util.Scanner;

public class SeaBattle {
    static final int FIELD_SIZE = 10;
    private final Scanner scanner = new Scanner(System.in);
    private final Player playerOne = new Human(scanner);
    private final Player playerTwo = new Human(scanner);



    public void run() {
        System.out.println("Welcome to SeaBattle!");
        beginning();
        play();
        ending();
    }

    private void printMessage(boolean first) {
        String youTurn = switchPlayer(first);
        String turnAround = switchPlayer(!first);
        System.out.printf("%s, turn around. %s it's your turn to fill the field!%n", turnAround, youTurn);
        System.out.println("Press enter if you are ready.");
        scanner.nextLine();
    }

    private void beginning() {
        printMessage(true);
        fieldsFilling(playerOne);
        flushScreen();
        printMessage(false);
        fieldsFilling(playerTwo);
        flushScreen();
    }

    private void fieldsFilling(Player player) {
        if (true) {
            fieldsFillingManuallyOnly(player);
            return;
        } else if (player instanceof Human) {
            System.out.println("Do you want to place ships manually or in a random order? Enter \"manually\" or \"random\"");
            while (true) {
                String mode = scanner.nextLine().trim();
                if ("manually".equals(mode)) {
                    player.placeShips(new ManualShipPlacer((Human) player));
                    return;
                } else if ("random".equals(mode)) {
                    break;
                } else
                    System.out.println("Invalid input. Please, enter \"manually\" or \"random\"");
            }
        }
        player.placeShips(new RandomShipPlacer(player));
    }

    private void fieldsFillingManuallyOnly(Player player) {
        player.placeShips(new ManualShipPlacer((Human) player));
    }

    private void play() {
        boolean playerOneTurn = true;
        while (true) {
            flushScreen();
            System.out.println(switchPlayer(playerOneTurn) + " press Enter and make a move");
            scanner.nextLine();
            seeAndShot(playerOneTurn);
            if (playerOne.isDefeated() || playerTwo.isDefeated()) {
                break;
            }
            playerOneTurn = !playerOneTurn;
            System.out.println("Now press Enter and call " + switchPlayer(playerOneTurn));
            scanner.nextLine();
        }
    }

    private void ending() {
        String winner = playerOne.isDefeated() ? "Player 2" : "Player 1";
        System.out.println(winner + " won the game!");
    }

    private void seeAndShot(boolean playerOneTurn) {
        Player currentPlayer = playerOneTurn ? playerOne : playerTwo;
        Player enemyPlayer = playerOneTurn ? playerTwo : playerOne;
        System.out.println("Your field:");
        currentPlayer.printField(false);
        System.out.println("Enemy field:");
        enemyPlayer.printField(true);
        while (true) {
            if(checkShot(enemyPlayer, currentPlayer.move())) {
                break;
            }
        }
    }

    private String switchPlayer(boolean playerOneTurn) {
        return playerOneTurn ? "Player 1" : "Player 2";
    }

    private boolean checkShot(Player enemy, Coordinate shot) {
        CellState targetCell = enemy.field.getCellState(shot);
        if (targetCell.equals(CellState.DECK)) {
            Ship enemyShip = enemy.takeAShot(shot);
            System.out.print("You hit a ship!");
            enemy.printField(true);
            if (enemyShip.isDestroyed()) {
                System.out.println(" And even destroyed it!\n");
                return true;
            }
            System.out.println(" Move again.");
            return false;
        } else if (targetCell.equals(CellState.EMPTY)) {
            enemy.field.getCell(shot).setState(CellState.MISS);
            enemy.printField(true);
            System.out.println("Miss...");
            return true;
        } else {
            enemy.printField(true);
            System.out.println("You moved here before. Change target.");
            return false;
        }
    }

    private void flushScreen() {
        System.out.println("\033[H\033[2J");
    }
}

