package course_project.SeaBattle.service;

import course_project.SeaBattle.model.Player;
import course_project.SeaBattle.model.Ship;
import course_project.SeaBattle.model.Square;
import course_project.SeaBattle.utility.Computer;
import course_project.SeaBattle.utility.InputUtil;
import course_project.SeaBattle.model.SquareType;

import java.util.List;

public class PlayerService {

    private static List<Player> playerList;
    private static Player winnerPlayer;
    private static boolean turn = false;
    private static boolean gameOn = true;
    private static int mod = 0;

    public static void fire(Player shooterPlayer) {

        Player enemyPlayer = shooterPlayer.getEnemy();
        Square square = shooterPlayer.isComputer() ? Computer.giveSquare() : InputUtil.getSquare();
        Square shotSquare = shooterPlayer.getEnemy().getGrid().getSquare(square.getX(), square.getY());

        if (isHit(enemyPlayer, shotSquare)) {
            ShipService.processFire(enemyPlayer, square);
        } else {
            turn = !turn;
            DisplayService.showMissMsg(enemyPlayer);
            delayBetweenBattleScreens(mod);
        }
    }

    public static Player getWhoseTurn() {
        return turn ? playerList.get(0) : playerList.get(1);
    }

    public static Player getWinner() {
        return winnerPlayer;
    }

    public static void setMod(int modFromInitialGameService) {
        mod = modFromInitialGameService;
    }

    public static int getScore() {
        return winnerPlayer.getRemainingAliveSquares() + 1;

    }

    public static boolean isBattleGoing() {
        for (Player player : playerList) {
            if (player.getRemainingAliveSquares() == 0) {
                gameOn = false;
                winnerPlayer = player.getEnemy();
            }
        }
        return gameOn;
    }

    private static void delayBetweenBattleScreens(int mod) {
        if (mod == 1) {
            try {
                Thread.sleep(1000);
                DisplayService.cleanScreen();
                DisplayService.callPlayerScreen();
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (mod == 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void setEnemyPlayers(List<Player> playerListFromInitialService) {
        playerList = playerListFromInitialService;
        Player player1 = playerList.get(0);
        player1.setEnemy(playerList.get(1));
        Player player2 = playerList.get(1);
        player2.setEnemy(playerList.get(0));
    }

    private static boolean isHit(Player enemyPlayer, Square shotSquare) {

        SquareType shotSquareStatus = shotSquare.getSquareStatus();

        if (shotSquareStatus.equals(SquareType.OCEAN) || shotSquareStatus.equals(SquareType.BOARD)) {
            shotSquare.setSquareStatus(SquareType.MISSED);
            return false;
        } else if (shotSquare.getSquareStatus().equals(SquareType.SHIP)) {
            shotSquare.setSquareStatus(SquareType.HIT);
            decreaseRemainingAliveSquares(enemyPlayer);
            return true;
        } else if (shotSquare.getSquareStatus().equals(SquareType.HIT)) {
            return false;
        } else if (shotSquare.getSquareStatus().equals(SquareType.MISSED)) {
            DisplayService.showMsgAlreadyShot();
            return true;
        } else {
            return false;
        }
    }

    public static void setRemainingAliveSquares(Player player) {

        for (Ship ship : player.getShipList()) {
            int remainingAliveSquares = player.getRemainingAliveSquares();
            remainingAliveSquares += ship.getShipHeal();
            player.setRemainingAliveSquares(remainingAliveSquares);
        }
    }

    private static void decreaseRemainingAliveSquares(Player enemyPlayer) {

        int remainingAliveSquares = enemyPlayer.getRemainingAliveSquares();

        enemyPlayer.setRemainingAliveSquares(--remainingAliveSquares);
    }
}
