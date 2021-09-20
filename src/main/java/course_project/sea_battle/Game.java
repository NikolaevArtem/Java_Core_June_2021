package course_project.sea_battle;

import course_project.sea_battle.boards.MyBoard;
import course_project.sea_battle.boards.MyShots;
import course_project.sea_battle.model.Player;
import course_project.sea_battle.service.Engine;
import course_project.sea_battle.service.ShipPlacer;

import java.util.Scanner;

import static course_project.sea_battle.service.NameSetter.setNames;

public class Game extends Thread{
    private final Scanner scanner = new Scanner(System.in);
    private final Player player1;
    private final Player player2;
    private static final String TIE = "Game over. It's a TIE!";
    private static final String GAMEOVER = "Game over. The winner is: ";

    public Game() {
        this.player1 = new Player(new MyBoard(), new MyShots());
        this.player2 = new Player(new MyBoard(), new MyShots());
    }

    public void run() {
        setNames(player1, player2);
        setUpShips();
        startGame();
    }

    public void setUpShips() {
        new ShipPlacer(scanner).placeShip(player1);
        new ShipPlacer(scanner).placeShip(player2);
    }

    public void startGame() {
        while (!countShipsPlayers(player1, player2)) {
            new Engine(scanner).checkAndValidatePlayerShot(player1, player2);
            new Engine(scanner).checkAndValidatePlayerShot(player2, player1);
        }
    }

    public boolean countShipsPlayers(Player player1, Player player2) {
        long p1ships = player1.getMyShips().stream().filter(e -> e.isAlive()).count();
        long p2ships = player2.getMyShips().stream().filter(e -> e.isAlive()).count();

        if (p1ships == 0 && p2ships == 0) {
            System.err.println(TIE);
        } else if (p1ships == 0) {
            System.err.println(GAMEOVER + player2.getName() + "!");
        } else if (p2ships == 0) {
            System.err.println(GAMEOVER + player1.getName() + "!");
        }
        return p1ships < 1 || p2ships < 1;
    }

}
