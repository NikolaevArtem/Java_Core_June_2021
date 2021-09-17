package course_project.SeaBattle.Controller;

import course_project.SeaBattle.Models.Player;
import course_project.SeaBattle.Models.Square;
import course_project.SeaBattle.Utility.SquareStatus;

import java.util.List;

public class PlayerService {

    static boolean turn = true;
    List<Player> playerList;

    public boolean shotProcess(Player shooterPlayer, Square square) {

        int x = square.getX();
        int y = square.getY();

        Square shotSquare = shooterPlayer.getEnemy().getGrid().getSquare(x, y);
        SquareStatus shotSquareStatus = shotSquare.getSquareStatus();

        if (shotSquareStatus.equals(SquareStatus.SHIP)) {
            shotSquare.setSquareStatus(SquareStatus.HIT);
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


    public void setPlayers(List<Player> playerList) {
        this.playerList = playerList;

        Player player1 = playerList.get(0);
        player1.setEnemy(playerList.get(1));
        Player player2 = playerList.get(1);
        player2.setEnemy(playerList.get(0));
    }

    public Player playerTurn() {
        if (turn){
            return playerList.get(0);
        }
        else{
            return playerList.get(1);
        }
    }

}
