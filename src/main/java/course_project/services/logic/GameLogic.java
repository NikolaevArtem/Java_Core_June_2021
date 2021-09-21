package course_project.services.logic;

import course_project.gamestuff.field.Battlefield;
import course_project.gamestuff.field.Cell;
import course_project.gamestuff.player.Player;
import course_project.gamestuff.ships.Ship;

import static course_project.services.conversation.DialogueMenu.*;
import static course_project.utils.RandomCellPositionGenerator.generateRandomForCell;

/**
 * Game logic provides control through the game process;
 */
public class GameLogic {

    private final Player player1;
    private final Player player2;
    private Player currentPlayer;

    public GameLogic(Player firstPlayer, Player secondPlayer) {
        this.player1 = firstPlayer;
        this.player2 = secondPlayer;
        currentPlayer = getRandomPlayer();
    }

    private Player getRandomPlayer() {
        return Math.random() <= 0.5 ? this.player1 : this.player2;
    }

    // switch to opponents turn
    private void swapPlayers() {
        if (currentPlayer == player1) {
            this.currentPlayer = this.player2;
        } else {
            this.currentPlayer = this.player1;
        }
    }

    private Player getEnemy() {
        return currentPlayer == player1 ? player2 : player1;
    }

    public void run() {
        while (currentPlayer.getField().hasAvailableShips() && getEnemy().getField().hasAvailableShips()) {
            if (currentPlayer.isComputer() && getEnemy().isComputer()) {
                computerMotion(currentPlayer);
            } else if (!currentPlayer.isComputer() && getEnemy().isComputer()) {
                humanMotion(currentPlayer);
            } else if (currentPlayer.isComputer() && !getEnemy().isComputer()) {
                computerMotion(currentPlayer);
            } else {
                try {
                    printInviteOpponentMessage(currentPlayer);
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                humanMotion(currentPlayer);
            }
        }
    }

    private void finishGame() {
        if (currentPlayer.getField().hasAvailableShips()) {
            printCongratulationsAndQuit(currentPlayer, getEnemy());
        } else {
            printCongratulationsAndQuit(getEnemy(), currentPlayer);
        }
    }

    private void computerMotion(Player currentPlayer) {
        int x = generateRandomForCell();
        int y = generateRandomForCell();
        if (!getEnemy().getField().getCellByPosition(x, y).isHit()) {
            getEnemy().getField().getCellByPosition(x, y).setHit(true);
            if (!getEnemy().getField().isCellEmpty(getEnemy().getField().getCellByPosition(x, y))) {
                Ship enemyShip = getEnemy().getField().getCellByPosition(x, y).getRef();
                enemyShip.hitCountIncrease();
                if (enemyShip.isShipDestroyed()) {
                    getEnemy().getField().setAroundShipCellsAsHit(getEnemy(), enemyShip);
                    printShipDestroyedMessage(getEnemy().getName(), enemyShip);
                    getEnemy().getField().availableShipsDecrease(enemyShip);
                    if (!getEnemy().getField().hasAvailableShips()) {
                        finishGame();
                    }
                } else {
                    printShipHitMessage(currentPlayer.getName(), getEnemy().getName());
                }
                computerMotion(currentPlayer);
            } else {
                swapPlayers();
            }
        } else {
            computerMotion(currentPlayer);
        }
    }

    private void humanMotion(Player currentPlayer) {
        currentPlayer.getField().printBothFields(currentPlayer, getEnemy());
        try {
            String pos = getPlayerMotionInput();
            int x = Integer.parseInt(pos.substring(1)) - 1;
            int y = Integer.parseInt(String.valueOf(pos.charAt(0) - 97));
            if (getEnemy().getField().getCellByPosition(x, y).isHit()) {
                printSamePositionMessage();
                humanMotion(currentPlayer);
            } else {
                Cell enemyCell = getEnemy().getField().getCellByPosition(x, y);
                enemyCell.setHit(true);
                if (!getEnemy().getField().isCellEmpty(enemyCell)) {
                    Ship enemyShip = enemyCell.getRef();
                    enemyShip.hitCountIncrease();
                    if (enemyShip.isShipDestroyed()) {
                        Battlefield enemiesField = getEnemy().getField();
                        enemiesField.setAroundShipCellsAsHit(getEnemy(), enemyShip);
                        enemiesField.availableShipsDecrease(enemyShip);
                        if (!enemiesField.hasAvailableShips()) {
                            currentPlayer.getField().printBothFields(currentPlayer, getEnemy());
                            finishGame();
                        }
                        printShipsLeftMessage(enemiesField.countOfAvailableShips());
                        printShipDestroyedMessage(getEnemy().getName(), enemyShip);
                    } else {
                        printShipHitMessage(currentPlayer.getName(), getEnemy().getName());
                    }
                    humanMotion(currentPlayer);
                } else {
                    printMiss();
                    swapPlayers();
                }
            }
        } catch (NumberFormatException exception) {
            humanMotion(currentPlayer);
        }
    }

}
