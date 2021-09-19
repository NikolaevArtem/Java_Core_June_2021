package course_project;

import course_project.enums.CellState;
import course_project.field_components.Cell;
import course_project.input_readers.ConsoleInputReader;
import course_project.input_readers.InputReader;
import course_project.players.Human;
import course_project.players.Player;
import course_project.players.PlayerAI;
import course_project.ship_placers.ManualShipPlacer;
import course_project.ship_placers.RandomShipPlacer;
import course_project.field_components.Ship;

public class SeaBattle {
    public static final int FIELD_SIZE = 10;
    private InputReader reader = new ConsoleInputReader();
    private Player playerHuman;
    private Player playerAI;
    private boolean playerOneTurn = true;

    public void run() {
        System.out.println("Welcome to SeaBattle!");
        beginning();
        whoFirst();
        play();
        ending();
    }

    public void setReader(InputReader reader) {
        this.reader = reader;
    }

    private void beginning() {
        playerHuman = new Human(reader);
        playerAI = new PlayerAI();
        fieldsFilling(playerHuman);
        fieldsFilling(playerAI);

//        setReader(new ConsoleInputReader()); // debugging
    }

    private void fieldsFilling(Player player) {
        if (player instanceof Human) {
            System.out.println("It's time to fill the field! How do you want to place ships?");
            System.out.println("1. Manually");
            System.out.println("2. Random");
            while (true) {
                String mode = reader.takeInput().trim();
                if ("1".equals(mode)) {
                    new ManualShipPlacer(player, reader).placeShips();
                    return;
                } else if ("2".equals(mode)) {
                    break;
                } else
                    System.out.println("Invalid input. Please, choose 1 or 2");
            }
        }
        new RandomShipPlacer(player).placeShips();
    }

    private void whoFirst() {
        System.out.println("Would you like to start first? Enter yes or no");
        while (true) {
            String answer = reader.takeInput();
            if ("no".equals(answer)) {
                playerOneTurn = false;
                break;
            } else if ("yes".equals(answer)){
                break;
            }
        }
    }

    private void play() {
        while (true) {
            if (playerOneTurn) {
                seeAndShot();
            } else {
                System.out.println("Enemy's turn to make a move!");
                while (true) {
                    if (checkAIShot()) {
                        break;
                    }
                }
            }
            waitingPressEnter();
            if (playerHuman.isDefeated() || playerAI.isDefeated()) {
                break;
            }
            playerOneTurn = !playerOneTurn;
        }
    }

    private void ending() {
        String winner = playerHuman.isDefeated() ? "Your PC" : "You";
        System.out.println(winner + " won the game!");
    }

    private void seeAndShot() {
        System.out.println("Your field:");
        playerHuman.printField(false);
        System.out.println("Enemy field:");
        playerAI.printField(true);
        while (true) {
            if(checkHumanShot()) {
                break;
            }
        }
    }

    private boolean checkAIShot() {
        Cell target = playerHuman.getField().getCell(playerAI.move());
        if (target.checkState(CellState.HIT) || target.checkState(CellState.MISS)) {
            return false;
        }
        System.out.print("Enemy's move: " + target.getCoordinate() + " and ");
        if (target.checkState(CellState.DECK)) {
            System.out.print("Enemy hit your ship!\n");
            Ship enemyShip = playerHuman.takeAShot(target);
            if (enemyShip.isDestroyed()) {
                System.out.println(" And even destroyed it!\n");
                return true;
            }
            System.out.println("Your PC moves again.");
            return false;
        } else {
            target.setState(CellState.MISS);
            System.out.println("Miss.");
            return true;
        }
    }

    private boolean checkHumanShot() {
        Cell target = playerAI.getField().getCell(playerHuman.move());
        if (target.checkState(CellState.DECK)) {
            Ship enemyShip = playerAI.takeAShot(target);
            System.out.print("You hit a ship!\n");
            if (enemyShip.isDestroyed()) {
                System.out.println(" And even destroyed it!\n");
                playerAI.printField(true);
                return true;
            }
            System.out.println(" Move again.");
            playerAI.printField(true);
            return false;
        } else if (target.checkState(CellState.EMPTY)) {
            target.setState(CellState.MISS);
            System.out.println("Miss.");
            playerAI.printField(true);
            return true;
        } else {
                playerAI.printField(true);
                System.out.println("You moved here before. Change target.");
            return false;
        }
    }

    private void waitingPressEnter() {
        System.out.println("Press Enter to continue");
        reader.takeInput();
    }
}

