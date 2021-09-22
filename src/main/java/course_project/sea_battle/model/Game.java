package course_project.sea_battle.model;


public class Game {
    private GamePlayer player1;
    private GamePlayer player2;

    private GamePlayer playerWin = null;

    public GamePlayer getPlayer1() {
        return player1;
    }

    public void setPlayer1(GamePlayer player1) {
        this.player1 = player1;
    }

    public GamePlayer getPlayer2() {
        return player2;
    }

    public void setPlayer2(GamePlayer player2) {
        this.player2 = player2;
    }

    public GamePlayer getPlayerWin() {
        return playerWin;
    }

    public void setPlayerWin(GamePlayer playerWin) {
        this.playerWin = playerWin;
    }
}
