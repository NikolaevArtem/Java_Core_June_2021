package course_project.logic;

import course_project.player.Player;
import course_project.ships.Ship;

import static course_project.dialogue.Menu.*;
import static course_project.utils.RandomPositionGenerator.generateRandomForCell;

public class GameLogic {

    private final Player player1;
    private final Player player2;
    private Player currentPlayer;

    public GameLogic(Player firstPlayer, Player secondPlayer) {
        this.player1 = firstPlayer;
        this.player2 = secondPlayer;
        currentPlayer = firstPlayer;
    }

    private void changeCurrentPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    private Player getEnemy() {
        return currentPlayer == player1 ? player2 : player1;
    }

    public void run() {
        showCoordinatesHelp();
        while (currentPlayer.getField().hasAvailableShips() && getEnemy().getField().hasAvailableShips()) {
            if (currentPlayer.isComputer() && getEnemy().isComputer()) {
                CPUTurn(currentPlayer);
            } else if (!currentPlayer.isComputer() && getEnemy().isComputer()) {
                playerTurn(currentPlayer);
            } else if (currentPlayer.isComputer() && !getEnemy().isComputer()) {
                CPUTurn(currentPlayer);
            }
        }
    }

    private void endGame() {
        if (currentPlayer.getField().hasAvailableShips()) {
            showWinScreen(currentPlayer, getEnemy());
        } else {
            showWinScreen(getEnemy(), currentPlayer);
        }
    }

    private void CPUTurn(Player currentPlayer) {
        int x = generateRandomForCell();
        int y = generateRandomForCell();

        if (!getEnemy().getField().getCellByPosition(x, y).isHit()) {
            getEnemy().getField().getCellByPosition(x, y).setHit(true);
            if (!getEnemy().getField().isCellEmpty(getEnemy().getField().getCellByPosition(x, y))) {
                Ship enemyShip = getEnemy().getField().getCellByPosition(x, y).getReference();
                enemyShip.hitCountIncrease();
                if (enemyShip.isDestroyed()) {
                    destroyTrigger(getEnemy().getName(), currentPlayer.getName(), enemyShip, x, y);
                    getEnemy().getField().availableShipsDecrease(enemyShip);
                    if (!getEnemy().getField().hasAvailableShips()) {
                        endGame();
                    }
                } else {
                    System.out.println(currentPlayer.getName() + " hit " + getEnemy().getName() + "'s ship at coordinates " + Character.toUpperCase((char) (y + 97)) + "" + (x + 1) + ".");
                    System.out.println(currentPlayer.getName() + " makes a move one more time.");
                }
                CPUTurn(currentPlayer);
            } else {
                System.out.println(currentPlayer.getName() + " select " + Character.toUpperCase((char) (y + 97)) + "" + (x + 1) + " and miss.\n");
                changeCurrentPlayer();
            }
        } else {
            CPUTurn(currentPlayer);
        }
    }

    private void playerTurn(Player currentPlayer) {
        currentPlayer.getField().showTwoFields(currentPlayer, getEnemy());
        System.out.println(currentPlayer.getName() + ", it's your turn. Enter coordinates: ");
        try {
            String pos = getPlayerMotionInput();
            int x = Integer.parseInt(pos.substring(1)) - 1;
            int y = Integer.parseInt(String.valueOf(pos.charAt(0) - 97));

            if (getEnemy().getField().getCellByPosition(x, y).isHit()) {
                System.out.println(currentPlayer.getName() + ", you have already chosen " + Character.toUpperCase((char) (y + 97)) + "" + (x + 1) + " coordinate, please re-enter: ");
                playerTurn(currentPlayer);
            } else {
                getEnemy().getField().getCellByPosition(x, y).setHit(true);
                if (!getEnemy().getField().isCellEmpty(getEnemy().getField().getCellByPosition(x, y))) {
                    Ship enemyShip = getEnemy().getField().getCellByPosition(x, y).getReference();
                    enemyShip.hitCountIncrease();
                    if (enemyShip.isDestroyed()) {
                        destroyTrigger(getEnemy().getName(), currentPlayer.getName(), enemyShip, x, y);
                        getEnemy().getField().availableShipsDecrease(enemyShip);

                        if (!getEnemy().getField().hasAvailableShips()) {
                            endGame();
                        }
                    } else {
                        System.out.println(currentPlayer.getName() + " hit " + getEnemy().getName() + "'s ship at coordinates " + Character.toUpperCase((char) (y + 97)) + "" + (x + 1));
                        System.out.println(currentPlayer.getName() + " makes a move one more time.");
                    }
                    playerTurn(currentPlayer);
                } else {
                    System.out.println(currentPlayer.getName() + " select " + Character.toUpperCase((char) (y + 97)) + "" + (x + 1) + " and miss.");
                    changeCurrentPlayer();
                }
            }
        } catch (NumberFormatException e) {
            playerTurn(currentPlayer);
        }
    }
}