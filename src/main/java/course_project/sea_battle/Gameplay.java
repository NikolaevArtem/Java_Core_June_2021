package course_project.sea_battle;

import course_project.sea_battle.players.ComputerPlayer;
import course_project.sea_battle.players.Player;
import course_project.sea_battle.playground.CellData;
import course_project.sea_battle.utils.ShotResultCode;
import homework_2.WrongInputException;

import java.io.IOException;

public class Gameplay {
    private final Player player;
    private final Player computer;

    public Gameplay(Player player, Player computer) {
        this.player = player;
        this.computer = computer;
    }

    public void setShips() throws IOException, WrongInputException, InterruptedException {
        System.out.println(player.getPlayground().toStringMine());
        player.setShips();

        System.out.println("Setting ships for computer...\n");
        computer.setShips();

        //imitating AI thinking while setting ships
        Thread.sleep(2000);
    }

    public void printPlaygrounds() {
        System.out.println("Computer's playground:");
        System.out.println(computer.getPlayground().toStringOthers());
        System.out.println("Your playground:");
        System.out.println(player.getPlayground().toStringMine());
    }

    public Player getWinner() throws IOException, WrongInputException {
        while (true) {
            makeMove(player, computer);
            if (computer.isLoser()) {
                return player;
            }

            makeMove(computer, player);

            if (player.isLoser()) {
                return computer;
            }
        }
    }

    private void makeMove(Player p1, Player p2) throws IOException, WrongInputException {
        while (true) {
            System.out.println("\n======= " + p1.toStringWhose() + " MOVE =======");

            CellData cellData = p1.makeMove();
            ShotResultCode code = p2.checkOwnField(cellData);

            printPlaygrounds();
            if (p1 instanceof ComputerPlayer) {
                System.out.println("Computer made a move: " + cellData);
            }
            System.out.println(code);

            if (code == ShotResultCode.MISS || p2.isLoser()) {
                break;
            }
        }
    }

    public void printCongratsToWinner(Player winner) {
        System.out.println("\n\n********************");
        System.out.println("      " + winner + " WIN!");
        System.out.println("********************");
    }
}
