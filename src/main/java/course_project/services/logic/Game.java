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
public class Game {

    private final Player player1;
    private final Player player2;
    private Player currentPlayer;

    public Game(Player firstPlayer, Player secondPlayer) {
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


    public void start() {
        while (currentPlayer.getField().hasAvailableShips() && getEnemy().getField().hasAvailableShips()) {
            if (currentPlayer.isComputer() && getEnemy().isComputer()) {
                computerMotion(currentPlayer);
            } else if (!currentPlayer.isComputer() && getEnemy().isComputer()) {
                humanMotion(currentPlayer);
            } else if (currentPlayer.isComputer() && !getEnemy().isComputer()) {
                computerMotion(currentPlayer);
            } else {
                waitForSeconds(2);
                printEmptyLines();
                printInvitePlayerMessage(currentPlayer);
                waitForSeconds(3);
                printPlayerMotionHelp();
                humanMotion(currentPlayer);
            }
        }
    }

    private void computerMotion(Player currentPlayer) {
        Cell enemyCell = getEnemy().getField().getCellByPosition(generateRandomForCell(), generateRandomForCell());
        if (!enemyCell.isHit()) {
            enemyCell.setHit(true);
            Battlefield enemyBattlefield = getEnemy().getField();
            if (!enemyBattlefield.isCellEmpty(enemyCell)) {
                Ship enemyShip = enemyCell.getRef();
                enemyShip.hitCountIncrease();
                if (enemyShip.isShipDestroyed()) {
                    enemyBattlefield.availableShipsDecrease(enemyShip);
                    enemyBattlefield.setAroundShipCellsAsHit(getEnemy(), enemyShip);
                    printShipDestroyedMessage(getEnemy().getName(), enemyShip);
                    if (!enemyBattlefield.hasAvailableShips()) {
                        printCongratulationsAndQuit(currentPlayer, getEnemy());
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
        String pos = getPlayerMotionInput();
        Cell enemyCell = getEnemy().getField().getCellByPosition(
                Integer.parseInt(pos.substring(1)) - 1,
                Integer.parseInt(String.valueOf(pos.charAt(0) - 97))
        );
        if (enemyCell.isHit()) {
            printSamePositionMessage();
            humanMotion(currentPlayer);
        } else {
            enemyCell.setHit(true);
            Battlefield enemiesField = getEnemy().getField();
            if (!enemiesField.isCellEmpty(enemyCell)) {
                Ship enemyShip = enemyCell.getRef();
                enemyShip.hitCountIncrease();
                if (enemyShip.isShipDestroyed()) {
                    enemiesField.setAroundShipCellsAsHit(getEnemy(), enemyShip);
                    enemiesField.availableShipsDecrease(enemyShip);
                    printShipDestroyedMessage(getEnemy().getName(), enemyShip);
                    if (!enemiesField.hasAvailableShips()) {
                        currentPlayer.getField().printBothFields(currentPlayer, getEnemy());
                        printCongratulationsAndQuit(currentPlayer, getEnemy());
                    }
                    printShipsLeftMessage(enemiesField.countOfAvailableShips());
                } else {
                    printShipHitMessage(currentPlayer.getName(), getEnemy().getName());
                }
                humanMotion(currentPlayer);
            } else {
                printMiss();
                swapPlayers();
            }
        }
    }

}
