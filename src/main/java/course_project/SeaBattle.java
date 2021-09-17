package course_project;

import course_project.enums.CellState;
import course_project.field_components.Coordinate;
import course_project.input_readers.ConsoleInputReader;
import course_project.input_readers.InputReader;
import course_project.players.Human;
import course_project.players.Player;
import course_project.ship_placers.Ship;

public class SeaBattle {
    public static final int FIELD_SIZE = 10;
    private InputReader reader = new ConsoleInputReader();
    private Player playerOne;
    private Player playerTwo;



    public void run() {
        System.out.println("Welcome to SeaBattle!");
        beginning();
        play();
        ending();
    }

    public void setReader(InputReader reader) {
        this.reader = reader;
//        Human.setReader(reader);
    }

    private void printMessage(boolean first) {
        String youTurn = switchPlayer(first);
        String turnAround = switchPlayer(!first);
        System.out.printf("%s, turn around. %s it's your turn to fill the field!%n", turnAround, youTurn);
        System.out.println("Press enter if you are ready.");
        waitingForPressKey();
    }

    private void beginning() {
        playerOne = new Human(reader);
        playerTwo = new Human(reader);
        printMessage(true);
        fieldsFilling(playerOne);
        flushScreen();
        printMessage(false);
        fieldsFilling(playerTwo);
        flushScreen();
//        setReader(new ConsoleInputReader()); // debugging
    }

    private void fieldsFilling(Player player) {
        if (true) {
            player.placeShips("manually");
            return;
        } else if (player instanceof Human) {
            System.out.println("Do you want to place ships manually or in a random order? Enter \"manually\" or \"random\"");
            while (true) {
                String mode = reader.takeInput().trim();
                if ("manually".equals(mode)) {
                    player.placeShips(mode);
                    return;
                } else if ("random".equals(mode)) {
                    break;
                } else
                    System.out.println("Invalid input. Please, enter \"manually\" or \"random\"");
            }
        }
        player.placeShips("random");
    }

    private void play() {
        boolean playerOneTurn = true;
        while (true) {
            flushScreen();
            System.out.println(switchPlayer(playerOneTurn) + " press Enter and make a move");
            waitingForPressKey();
            seeAndShot(playerOneTurn);
            if (playerOne.isDefeated() || playerTwo.isDefeated()) {
                break;
            }
            playerOneTurn = !playerOneTurn;
            System.out.println("Now press Enter and call " + switchPlayer(playerOneTurn));
            waitingForPressKey();
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
        CellState targetCell = enemy.getField().getCellState(shot);
        if (targetCell.equals(CellState.DECK)) {
            Ship enemyShip = enemy.takeAShot(shot);
            System.out.print("You hit a ship!\n");
            enemy.printField(true);
            if (enemyShip.isDestroyed()) {
                System.out.println(" And even destroyed it!\n");
                return true;
            }
            System.out.println(" Move again.");
            return false;
        } else if (targetCell.equals(CellState.EMPTY)) {
            enemy.getField().getCell(shot).setState(CellState.MISS);
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

    private void waitingForPressKey() {
        reader.takeInput();
    }


}

