package course_project.SeaBattle.services;

import course_project.SeaBattle.models.Player;
import course_project.SeaBattle.models.Ship;
import course_project.SeaBattle.models.Square;
import course_project.SeaBattle.utility.Computer;
import course_project.SeaBattle.utility.Input;
import course_project.SeaBattle.utility.SquareStatus;

import java.util.List;

public class PlayerService {

    static List<Player> playerList;
    static Player winnerPlayer;
    static boolean turn = true;
    static boolean gameOn = true;
    static int mod = 0;

    public static Player getWhoseTurn() {
        return turn ? playerList.get(0) : playerList.get(1);
    }

    public static Player getWinner() {
        return winnerPlayer;
    }

    public static void fire(Player shooterPlayer) {

        Player enemyPlayer = shooterPlayer.getEnemy();
        Square square = shooterPlayer.isComputer() ? Computer.giveSquare() : Input.getSquare();
        int x = square.getX();
        int y = square.getY();
        Square shotSquare = shooterPlayer.getEnemy().getGrid().getSquare(x, y);

        if (isHit(shotSquare)) {
            ShipService.processFire(enemyPlayer, square);
            decreaseRemainingAliveSquares(enemyPlayer);
        } else {
            turn = !turn;
            DisplayService.showMiss(enemyPlayer);
            delayBetweenBattleScreens(mod);
        }

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

    public static boolean isBattleGoing() {
        for (Player player : playerList) {
            if (player.getRemainingAliveSquares() == 0) {
                gameOn = false;
                winnerPlayer = player.getEnemy();
            }
        }
        return gameOn;
    }

    public static void setEnemyPlayers(List<Player> playerListFromInitialService) {
        playerList = playerListFromInitialService;
        Player player1 = playerList.get(0);
        player1.setEnemy(playerList.get(1));
        Player player2 = playerList.get(1);
        player2.setEnemy(playerList.get(0));
    }

    public static void setRemainingAliveSquares(Player player) {

        for (Ship ship : player.getShipList()) {
            int remainingAliveSquares = player.getRemainingAliveSquares();
            remainingAliveSquares += ship.getShipHeal();
            player.setRemainingAliveSquares(remainingAliveSquares);
        }
    }

    private static boolean isHit(Square shotSquare) {

        SquareStatus shotSquareStatus = shotSquare.getSquareStatus();

        if (shotSquareStatus.equals(SquareStatus.OCEAN) || shotSquareStatus.equals(SquareStatus.BOARD)) {
            shotSquare.setSquareStatus(SquareStatus.MISSED);
            return false;
        } else if (shotSquare.getSquareStatus().equals(SquareStatus.SHIP)) {
            shotSquare.setSquareStatus(SquareStatus.HIT);
            return true;
        } else if (shotSquare.getSquareStatus().equals(SquareStatus.HIT)) {
            return false;
        } else {
            return false;
        }
    }

    private static void decreaseRemainingAliveSquares(Player enemyPlayer) {

        int remainingAliveSquares = enemyPlayer.getRemainingAliveSquares();
        remainingAliveSquares -= 1;
        enemyPlayer.setRemainingAliveSquares(remainingAliveSquares);

    }

    public static void setMod(int modFromInitialGameService) {
        mod = modFromInitialGameService;
    }

    public static int getScore() {
        return   winnerPlayer.getRemainingAliveSquares();

    }
}
