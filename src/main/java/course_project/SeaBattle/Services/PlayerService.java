package course_project.SeaBattle.Services;

import course_project.SeaBattle.Models.Player;
import course_project.SeaBattle.Models.Ship;
import course_project.SeaBattle.Models.Square;
import course_project.SeaBattle.Utility.SquareStatus;

import java.util.List;

public class PlayerService {

    static boolean turn = true;
    static List<Player> playerList;

    public static boolean shotProcess(Player shooterPlayer, Square square) {

        int x = square.getX();
        int y = square.getY();

        Square shotSquare = shooterPlayer.getEnemy().getGrid().getSquare(x, y);
        SquareStatus shotSquareStatus = shotSquare.getSquareStatus();

        if (shotSquareStatus.equals(SquareStatus.SHIP)) {
            shotSquare.setSquareStatus(SquareStatus.HIT);

            int remainingAliveSquares = shooterPlayer.getEnemy().getRemainingAliveSquares();
            remainingAliveSquares -= 1;
            shooterPlayer.getEnemy().setRemainingAliveSquares(remainingAliveSquares);

            return true;
        }
        else if (shotSquareStatus.equals(SquareStatus.OCEAN)){
            shotSquare.setSquareStatus(SquareStatus.MISSED);
            turn = !turn;
            System.out.println("tern");
            return false;
        }
        else if (shotSquareStatus.equals(SquareStatus.HIT)){
            return true;
        }
        else {
            return true;
        }
    }


    public static void setPlayers(List<Player> playerListFromInitialService) {
        playerList = playerListFromInitialService;
        Player player1 = playerList.get(0);
        player1.setEnemy(playerList.get(1));
        Player player2 = playerList.get(1);
        player2.setEnemy(playerList.get(0));

    }

    public static Player playerTurn() {
        if (turn){
            return playerList.get(0);
        }
        else{
            return playerList.get(1);
        }
    }

    public static boolean isBattleGoing() {
        for (Player player: playerList) {
            return player.getRemainingAliveSquares() != 0;
        }
        return false;
    }

    public static void setRemainingAliveSquares(Player player) {
        for (Ship ship : player.getShipList()){
            int remainingAliveSquares = player.getRemainingAliveSquares();
            remainingAliveSquares += ship.getShipType().getSize();
            player.setRemainingAliveSquares(remainingAliveSquares);
        }
    }
}
