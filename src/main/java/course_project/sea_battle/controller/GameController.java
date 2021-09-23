package course_project.sea_battle.controller;

import course_project.sea_battle.boards.MyBoard;
import course_project.sea_battle.model.Player;
import course_project.sea_battle.model.Ship;
import course_project.sea_battle.service.inputs.InputShipReader;
import course_project.sea_battle.service.GameModeAndNameSetter;
import course_project.sea_battle.service.inputs.InputShooterReader;
import course_project.sea_battle.service.ShipPlacer;

import java.util.Scanner;

import static course_project.sea_battle.utils.Constants.*;

public class GameController extends Thread {

    private final Scanner scanner = new Scanner(System.in);
    private final InputShipReader inputShipReader = new InputShipReader(scanner);

    private Player player1;
    private Player player2;

    public GameController() {
        this.player1 = new Player(new MyBoard(), new MyBoard());
        this.player2 = new Player(new MyBoard(), new MyBoard());
    }

    @Override
    public void run() {
        setUpNames();
        setUpShips();
        play();
        defineWinner();
    }

    public void setUpNames() {
        new GameModeAndNameSetter(inputShipReader).setNames(player1, player2);
    }

    public void setUpShips() {
        new ShipPlacer(inputShipReader).placeShip(player1, player2);
        new ShipPlacer(inputShipReader).placeShip(player2, player1);
    }

    public void play() {
        while (bothPlayersHaveShips(player1, player2)) {
            new InputShooterReader(scanner).checkAndValidatePlayerShot(player1, player2);
            new InputShooterReader(scanner).checkAndValidatePlayerShot(player2, player1);
        }
    }

    public boolean bothPlayersHaveShips(Player player1, Player player2) {
        return countShips(player1) > 0 && countShips(player2) > 0;
    }

    public long countShips(Player player) {
        return player.getMyShips().stream().filter(Ship::isAlive).count();
    }

    public void defineWinner() {
        if (countShips(player1) == 0 && countShips(player2) == 0) {
            System.out.println(TIE);
        } else if (countShips(player1) == 0) {
            System.out.println(GAMEOVER + player2.getName() + "!");
        } else if (countShips(player2) == 0) {
            System.out.println(GAMEOVER + player1.getName() + "!");
        }
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

}
